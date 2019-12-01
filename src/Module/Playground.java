package Module;

import java.util.ArrayList;
import java.util.HashMap;

class Playground {
    public Playground(Game.GameMode gameMode) {

    }

    private class Position {
        private int x; // 0 to 18
        private int y; // 0 to 5
        private boolean material; //true for water, false for dirt

        public Position(int x, int y, boolean material) {
            this.x = x;
            this.y = y;
            this.material = material;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean getMaterial() {
            return material;
        }
    }

    private HashMap<Position, ArrayList<Card>> map = new HashMap<>();

    public void plant(int x, int y) {

    }

    public void remove(int x, int y) {

    }

    public void moveCards() {

    }
}
