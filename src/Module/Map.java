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
    private int turn = 0;

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
            boolean isZobmbieInLine = isZobmbieInLine(cellInRow);
            if (isZobmbieInLine) {
                for (Cell cell : cellInRow) {
                    ArrayList<Card> cards = CellEntry.getCards(map.get(cell));
                    if (cards.size() != 0) {
                        for (Card card : cards) {
                            if (card instanceof Plant) {
                                /*baraye hamashon omadam ye shot tarif kardam ke ba
                                 tajoh be modelesh ke badan tarif mikonim harekat mikone ya kheir
                                */
                                normal(cell, (Plant) card);
                                iceShot(cell, (Plant) card);
                                projectile(cell, (Plant) card);
                                doubleShot(cell, (Plant) card);
                                tripleLine(cell, (Plant) card);
                                cactus(cell, (Plant) card);
                                gatlingPea(cell, (Plant) card);
                                stop(cell, (Plant) card);
                                scaredyShroom(cell, (Plant) card);
                                bomb(cell, (Plant) card);
                                //in Explode-o-nut we don't have shot method
                                lineBomb(cell, (Plant) card);
                                magnet(cell,  (Plant) card);
                                // baraye mine shot nadarim omadim miaim to check kardan harekat jambi ha check mikonim
                                split(cell, (Plant) card);
                                //defence shot nadare :)
                                //nemidonam near hit che ghalati mikone \0/


                            } else {


                            }


                        }

                    }


                }


            }


        }


    }

    private void split(Cell cell, Plant card) {
        if (card.getType() == PlantType.SPLIT) {
            if (updateTurn == 0 && card.checkForShotTurn(turn)) {
                card.shot(cell.getX(), cell.getY(), true);
                card.shot(cell.getX(), cell.getY(), true);
            }
        }
    }

    private void magnet(Cell cell, Plant card) {
        if (card.getType() == PlantType.MAGNET) {
            // we don't move this shot if is valid
            boolean isZobmbieInAround = isZobmbieInAround(cell);
            if (isZobmbieInAround) {
                if (updateTurn == 0 && card.checkForShotTurn(turn)) {
                    card.shot(cell.getX(), cell.getY(), false);
                }
            }
        }
    }

    private boolean isZobmbieInAround(Cell cell) {
        boolean isZobmbieInAround = false;
        int x = cell.getX() - 1;
        int y = cell.getY() - 1;
        overLoop:
        for (x = cell.getX() - 1; x <= cell.getX() + 1; x++) {
            for (y = cell.getY() - 1; x <= cell.getY() + 1; x++) {
                try {
                    Cell cellnew = cells.get(y).get(x);
                    ArrayList<Card> cardss = CellEntry.getCards(map.get(cells.get(y).get(x)));
                    if (cardss.size() != 0) {
                        for (Card card1 : cardss) {
                            if (card1 instanceof Zombie) {
                                isZobmbieInAround = true;
                                break overLoop;
                            }
                        }
                    }
                } catch (Exception ignore) {
                    continue;
                }
            }
        }
        return isZobmbieInAround;
    }

    private void lineBomb(Cell cell, Plant card) {
        if (card.getType() == PlantType.LINE_BOMB) {
            if (updateTurn == 0 && card.checkForShotTurn(turn)) {
                card.shot(cell.getX(), cell.getY(), true);
            }
        }
    }


    private void bomb(Cell cell, Plant card) {
        if (card.getType() == PlantType.BOMB) {
            if (updateTurn == 0 && card.checkForShotTurn(turn)) {
                card.shot(cell.getX(), cell.getY(), false);
            }
        }
    }

    private void scaredyShroom(Cell cell, Plant card) {
        if (card.getType() == PlantType.SCAREDY_SHROOM) {
            boolean isZobieInLineUntilTheNextTwoCell = isZobmbieInLineUntilTheNextTwoCell(cell);
            if (!isZobieInLineUntilTheNextTwoCell) {
                if (updateTurn == 0 && card.checkForShotTurn(turn)) {
                    card.shot(cell.getX(), cell.getY(), true);
                }
            }

        }
    }

    private boolean isZobmbieInLine(ArrayList<Cell> cellInRow) {
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
        return isZobmbieInLine;
    }

    private boolean isZobmbieInLineUntilTheNextTwoCell(Cell cell) {
        boolean isZobmbieInLineUntilTheNextTwoCall = false;
        if (cell.getX() < 18) {
            ArrayList<Card> cards = CellEntry.getCards(map.get(cells.get(cell.getY()).get(cell.getX() + 1)));
            if (cards.size() != 0) {
                for (Card card : cards) {
                    if (card instanceof Zombie) {
                        isZobmbieInLineUntilTheNextTwoCall = true;
                        return isZobmbieInLineUntilTheNextTwoCall;
                    }
                }
            }
            cards = CellEntry.getCards(map.get(cells.get(cell.getY()).get(cell.getX() + 2)));
            if (cards.size() != 0) {
                for (Card card : cards) {
                    if (card instanceof Zombie) {
                        isZobmbieInLineUntilTheNextTwoCall = true;
                        return isZobmbieInLineUntilTheNextTwoCall;
                    }
                }
            }
        }
        return isZobmbieInLineUntilTheNextTwoCall;
    }

    //this method for shooting

    private void stop(Cell cell, Plant card) {
        if (card.getType() == PlantType.STOP) {
            if (updateTurn == 0 && card.checkForShotTurn(turn)) {
                card.shot(cell.getX(), cell.getY(), true);
            }

        }
    }

    private void gatlingPea(Cell cell, Plant card) {
        if (card.getType() == PlantType.GATLING_PEA) {
            if (updateTurn == 0 && card.checkForShotTurn(turn)) {
                card.shot(cell.getX(), cell.getY(), true);
            }
        }
    }

    private void cactus(Cell cell, Plant card) {
        if (card.getType() == PlantType.CACTUS) {
            if (updateTurn == 0 && card.checkForShotTurn(turn)) {
                card.shot(cell.getX(), cell.getY(), true);
            }
        }
    }

    private void tripleLine(Cell cell, Plant card) {
        if (card.getType() == PlantType.TRIPLE_LINE) {
            if (updateTurn == 0 && card.checkForShotTurn(turn)) {
                card.shot(cell.getX(), cell.getY(), true);
                if (cell.getY() != 5)
                    card.shot(cell.getX(), cell.getY() + 1, true);
                if (cell.getY() != 0)
                    card.shot(cell.getX(), cell.getY() + 1, true);
            }
        }
    }

    private void projectile(Cell cell, Plant card) {
        if (card.getType() == PlantType.PROJECTILE) {
            if (updateTurn == 0 && card.checkForShotTurn(turn)) {
                card.shot(cell.getX(), cell.getY(), false);
            }

        }
    }

    private void normal(Cell cell, Plant card) {
        if (card.getType() == PlantType.NORMAL) {
            if (updateTurn == 0 && card.checkForShotTurn(turn)) {
                card.shot(cell.getX(), cell.getY(), true);
            }

        }
    }

    private void iceShot(Cell cell, Plant card) {
        if (card.getType() == PlantType.ICE) {
            card.moveBullet();
            if (updateTurn == 0 && card.checkForShotTurn(turn)) {
                card.shot(cell.getX(), cell.getY(), true);
            }
        }
    }

    private void doubleShot(Cell cell, Plant card) {
        if (card.getType() == PlantType.DOUBLE_SHOT) {
            if (updateTurn == 0 && card.checkForShotTurn(turn)) {
                card.shot(cell.getX(), cell.getY(), true);
            }
        }
    }

    public void reset() {
        updateTurn = 0;
    }
}
/*

                                    if (updateTurn == 0 && ((Plant)card).checkForShotTurn(turn)) {
                                            ((Plant)card).shot(cell.getX(), cell.getY(), true);
                                            }
                                            */
/*

                                if (((Plant) card).getType() == PlantType.RANGE) {
                                        }
                                        */
