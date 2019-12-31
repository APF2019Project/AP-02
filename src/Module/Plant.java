package Module;

import java.util.ArrayList;

public class Plant extends Card {
    private static ArrayList<Card> plants = new ArrayList<>();
    private ArrayList<Bullet> bullets = new ArrayList<>();

    private int cooldown;
    private int cost;
    private PlantType type;
    private int turn;

    public Plant() {
    }

    public Plant(String name, int hp, int damage, int cooldown, int cost, PlantType type, int turn) {
        super(name, hp, damage);
        this.cooldown = cooldown;
        this.cost = cost;
        this.type = type;
        this.setPrice(cost * cooldown * hp + 1);
        this.turn = turn;
    }
    // add turn for bullet we need

    public static void addPlant(Card plant) {
        plants.add(plant);
    }

    public static ArrayList<Card> getPlant() {
        return plants;
    }

    public static Card getByName(String name) {
        for (Card card : plants) {
            if (card.getName().equals(name)) {
                return card;
            }
        }
        return null;
    }

    public int getCooldown() {
        return cooldown;
    }

    public int getCost() {
        return cost;
    }

    public PlantType getType() {
        return type;
    }

    public void moveBullet() {
        for (Bullet bullet : bullets) {
            try {
                if (bullet.getX() < 19) {
                    bullet.setX(bullet.getX() + 1);
                }
            } catch (Exception ignore) {
                bullets.remove(bullet);
            }
        }
    }

    public void shot(int x, int y , boolean isPeaShot) {
        bullets.add(new Bullet(x, y, this.getDamage(), 3 , isPeaShot));
    }

    public boolean checkForShotTurn(int turnGame) {
        if (turnGame % turn == 0) {
            return true;
        } else
            return false;
    }
}
