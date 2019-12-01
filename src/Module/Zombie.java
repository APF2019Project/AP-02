package Module;

import java.util.ArrayList;

public class Zombie extends Card {
    private static ArrayList<Card> zombies = new ArrayList<>();

    private enum Type {
        NORMAL, ARMORED, BUCKET, SHEILD, THIEF, MACHINE, STRONG, GIANT, SNORKEL, JUMP,
    }

    private int speed;
    private boolean environment; // true for ground, false for water
    private Type type;

    public int getSpeed() {
        return speed;
    }

    public static Card getByName() {

    }

    public boolean isEnvironment() {
        return environment;
    }

    public Type getType() {
        return type;
    }
}
