package Module;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;


public class Map {
    private HashMap<Cell, ArrayList<CellEntry>> map = new HashMap<>();

    private ArrayList<ArrayList<Cell>> cells;
    private int updateTurn = 0;
    private int turn = 0 ;
    public Map(String type, boolean isLawnMowerExist) {
        String path = "src/Cards/Maps/" + type + ".json";
        ArrayList<ArrayList<Cell>> cells = initMap(path);
        assert cells != null;
        this.cells = cells;
        for (ArrayList<Cell> arrayList : cells) {
            for (Cell cell : arrayList) {
                ArrayList<CellEntry> cards = new ArrayList<>();
                if (isLawnMowerExist && cell.getX() == 0) {
                    cards.add(new CellEntry(new LawnMower()));
                }
                map.put(cell, cards);
            }
        }
    }

    private static ArrayList<ArrayList<Cell>> initMap(String path) {
        ArrayList<ArrayList<Cell>> cells;
        ObjectMapper objectMapper = new ObjectMapper().setVisibility(JsonMethod.FIELD,
                JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
                false);
        TypeReference<ArrayList<ArrayList<Cell>>> typeRef
                = new TypeReference<ArrayList<ArrayList<Cell>>>() {
        };
        try {
            cells = objectMapper.readValue(new File(path), typeRef);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return cells;
    }

    public boolean addCard(int x, int y, Card card) {
        Cell cell;
        try {
            cell = cells.get(y - 1).get(x);
        } catch (Exception ignore) {
            System.out.println("the entered coordination doesn't exist");
            return false;
        }
        boolean isFull = false, isWater = !cell.getMaterial(), isLilyPlanted = false;
        ArrayList<Card> cards = CellEntry.getCards(map.get(cell));
        for (Card card1 : cards) {
            if (card1 instanceof Plant) {
                if (((Plant) card1).getType() != PlantType.LILY_PAD) {
                    isFull = true;
                } else {
                    isLilyPlanted = true;
                }
            }
        }
        if (!isFull) {
            if (((Plant) card).getType() == PlantType.LILY_PAD && (!isWater || isLilyPlanted)) {
                System.out.println("you can't plant lily pad on ground or on other lily pad");
                return false;
            } else if (isWater && ((Plant) card).getType() != PlantType.LILY_PAD && !isLilyPlanted) {
                System.out.println("you can't plant on water");
                return false;
            } else {
                map.get(cell).add(new CellEntry(card));
                System.out.println("plant added");
                return true;
            }
        } else {
            System.out.println("this cell is full");
            return false;
        }
    }

    public void removeCard(int x, int y) {
        Cell cell;
        try {
            cell = cells.get(y - 1).get(x);
        } catch (Exception ignore) {
            System.out.println("the entered coordination doesn't exist");
            return;
        }
        boolean isPlantAvailable = false;
        ArrayList<Card> cards = CellEntry.getCards(map.get(cell));
        for (Card card1 : cards) {
            if (card1 instanceof Plant) {
                isPlantAvailable = true;
            }
        }
        if (isPlantAvailable) {
            map.get(cell).remove(cards.size() - 1);
            System.out.println("plan removed");
        } else {
            System.out.println("there're no plants here");
        }
    }

    public void print() {
        for (ArrayList<Cell> arrayList : cells) {
            for (Cell cell : arrayList) {
                ArrayList<Card> cards = CellEntry.getCards(map.get(cell));
                if (cards.size() == 0) {
                    if (cell.getMaterial()) {
                        if (cell.getX() == 0) {
                            System.out.print("|| ");
                        } else {
                            System.out.print("__ ");
                        }
                    } else {
                        if (cell.getX() == 0) {
                            System.out.print("|| ");
                        } else {
                            System.out.print("// ");
                        }
                    }
                } else {
                    for (Card card : cards) {
                        if (card instanceof Plant) {
                            if (((Plant) card).getType() == PlantType.LILY_PAD) {
                                System.out.print("l");
                            } else {
                                System.out.print("p");
                            }
                        } else if (card instanceof Zombie) {
                            System.out.print("z");
                        } else if (card instanceof LawnMower) {
                            System.out.print("LM");
                        }
                    }
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void update() {
        for (ArrayList<Cell> cellInRow : cells) {
            boolean isZobmbieInLine = false;
            for (Cell cell : cellInRow) {
                ArrayList<Card> cards = CellEntry.getCards(map.get(cell));
                if (cards.size() != 0) {
                    for (Card card : cards) {
                        if (card instanceof Zombie) {
                            isZobmbieInLine = true;
                            break;
                        }
                    }
                }
            }
            if (isZobmbieInLine) {
                for (Cell cell : cellInRow) {
                    ArrayList<Card> cards = CellEntry.getCards(map.get(cell));
                    if (cards.size() != 0) {
                        for (Card card : cards) {
                            if (card instanceof Plant) {

                                if (((Plant) card).getType() == PlantType.DOUBLE_SHOT) {

                                    ((Plant) card).moveBullet();
                                    ((Plant) card).shot(cell.getX(), cell.getY() , true);
                                    ((Plant) card).shot(cell.getX(), cell.getY() , true ) ;


                                }
                                if (((Plant) card).getType() == PlantType.ICE) {


                                    ((Plant) card).shot(cell.getX() , cell.getY() ,true);

                                }
                                if (((Plant) card).getType() == PlantType.STOP) {


                                }
                                if (((Plant) card).getType() == PlantType.CACTUS) {


                                }
                                if (((Plant) card).getType() == PlantType.BOMB) {


                                }
                                if (((Plant) card).getType() == PlantType.GATLING_PEA) {


                                }
                                if (((Plant) card).getType() == PlantType.EXPLDOE_NUT) {


                                }
                                if (((Plant) card).getType() == PlantType.LINE_BOMB) {


                                }
                                if (((Plant) card).getType() == PlantType.MAGNET) {


                                }
                                if (((Plant) card).getType() == PlantType.MINE) {


                                }
                                if (((Plant) card).getType() == PlantType.ICE_PROJECTILE) {


                                }
                                if (((Plant) card).getType() == PlantType.NORMAL) {


                                }
                                if (((Plant) card).getType() == PlantType.PROJECTILE) {


                                }
                                if (((Plant) card).getType() == PlantType.TRIPLE_LINE) {


                                }
                                if (((Plant) card).getType() == PlantType.RANGE) {
                                }

                                if (((Plant) card).getType() == PlantType.SPLIT) {
                                }

                                if (((Plant) card).getType() == PlantType.DEFENCE) {
                                }

                                if (((Plant) card).getType() == PlantType.NEAR_HIT) {
                                }


                            } else {


                            }


                        }

                    }


                }


            }


        }


    }

    public void reset() {
        updateTurn = 0;
    }
}
