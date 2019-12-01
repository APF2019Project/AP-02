package Module;

import java.util.ArrayList;

public class Plant extends Card {
    private static ArrayList<Card> plants = new ArrayList<>();
    private ArrayList<Bullet> bullets = new ArrayList<>();

    private enum Type {
        NORMAL, ICE, PROJECTILE, DOUBLE_SHOT, TRIPLE_LINE, CACTUS, RANGE, STOP, LILY_PAD, BOMB, EXPLDOE_NUT, DEFENCE,
        NEAR_HIT, MAGNET, MINE, SUNFLOWER, LINE_BOMB
    }

    private int cooldown;
    private int cost;
    private Type type;

    public static Card getByName() {

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
