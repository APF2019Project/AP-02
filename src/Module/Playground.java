package Module;

import java.util.ArrayList;
import java.util.HashMap;

class Playground {
    private class Position {
        private int x; // 0 to 18
        private int y; // 0 to 5

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private HashMap<Position, ArrayList<Card>> map = new HashMap<>();


}
