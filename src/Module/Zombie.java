package Module;

import java.util.ArrayList;

public class Zombie extends Card {
    private static ArrayList<Card> zombies = new ArrayList<>();

    public enum Type {
        NORMAL, ARMORED, BUCKET, SHEID, SHEILD2, SHEILD3, SHEILD4, THIEF, AIR, MACHINE, STRONG_MACHINE, GIANT, SNORKEL,
        JUMP, SNORKEL_SHEILD
    }

    private int speed;
    private boolean environment; // true for ground, false for water
    private Type type;

    public Zombie() {
    }
    public static ArrayList<Card> getZombies(){return zombies;}

    public Zombie(String name, int hp, int damage, int speed, boolean environment, Type type) {
        super(name, hp, damage);
        this.speed = speed;
        this.environment = environment;
        this.type = type;
        this.setPrice((1 + speed) * hp * 10);
    }

    public static void addZombie(Card zombie) {
        zombies.add(zombie);
    }

    public static Card getByName(String name) {
        for (Card card : zombies) {
            if (card.getName().equals(name)) {
                return card;
            }
        }
        return null;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean getEnvironment() {
        return environment;
    }

    public Type getType() {
        return type;
    }
}
