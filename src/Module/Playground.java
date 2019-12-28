package Module;

public class Playground {
    private Map map;

    public Playground(Game.GameMode gameMode) {
        if (gameMode == Game.GameMode.DAY || gameMode == Game.GameMode.RAIL || gameMode == Game.GameMode.MULTIPLAYER) {
            map = new Map("day", true);
        } else if (gameMode == Game.GameMode.WATER) {
            map = new Map("water", true);
        } else {
            map = new Map("day", false);
        }
    }

    public boolean plant(int x, int y, Card card) {
        if (x % 2 != 0) {
            System.out.println("you can't plant this here");
            return false;
        }
        return map.addCard(x, y, card);
    }

    public void remove(int x, int y) {
        map.removeCard(x, y);
    }

    public void printMap() {
        map.print();
    }

    public void moveCards() {

    }
}
