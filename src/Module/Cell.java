package Module;

public class Cell {
    private int x; // 0 to 19
    private int y; // 1 to 6
    private boolean material; //true for dirt, false for water

    public Cell() {
    }

    public Cell(int x, int y, boolean material) {
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

    @Override
    public int hashCode() {
        int i = 0;
        if (material) {
            i = 1000;
        }
        return 10000 + x + y + i;
    }
}