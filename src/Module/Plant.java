package Module;

import java.util.ArrayList;

public class Plant extends Card {
    private static ArrayList<Card> plants = new ArrayList<>();
    private ArrayList<Bullet> bullets = new ArrayList<>();

    private enum Type {
        NORMAL, ICE, PROJECTILE, DOUBLE_SHOT, TRIPLE_LINE, CACTUS, GATLING_PEA, RANGE, STOP, SPLIT, LILY_PAD, BOMB,
        EXPLDOE_NUT, DEFENCE, NEAR_HIT, MAGNET, MINE, SUNFLOWER, LINE_BOMB, ICE_PROJECTILE, TWIN_SUNFLOWER
    }

    private int cooldown;
    private int cost;
    private Type type;

    public Plant() {
    }

    public Plant(String name, int hp, int damage, int cooldown, int cost, Type type) {
        super(name, hp, damage);
        this.cooldown = cooldown;
        this.cost = cost;
        this.type = type;
        this.setPrice(cost * cooldown * hp + 1);
    }

    public static void addPlant(Card plant) {
        plants.add(plant);
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

    public Type getType() {
        return type;
    }
}
