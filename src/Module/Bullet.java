package Module;

public class Bullet {
    private int x;
    private int y;
    private int damage;
    private int speed;

    public Bullet(int x, int y, int damage, int speed) {
        this.x = x;
        this.y = y;
        this.damage = damage;
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }
}
