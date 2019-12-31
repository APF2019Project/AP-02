package Module;

public class Bullet {
    private int x;
    private int y;
    private int damage;
    private int speed = 3;
    private boolean isBulletPea ;
    //true for pea shot and false for pult shot


    public Bullet(int x, int y, int damage, int speed, boolean isBulletPea) {
        this.x = x;
        this.y = y;
        this.damage = damage;
        this.speed = speed;
        this.isBulletPea = isBulletPea ;
    }

    public boolean isBulletPea(){
        return isBulletPea ;
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
