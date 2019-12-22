package Module;

public class Card {
    private String name;
    private int hp;
    private int price;
    private int damage;

    public Card() {
    }

    public Card(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getPrice() {
        return price;
    }

    public int getDamage() {
        return damage;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
