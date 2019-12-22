package Module;

import java.util.ArrayList;

public class Collection {
    private ArrayList<Card> cards = new ArrayList<>();

    public void addCard(Card card) {

    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card getByName(String name) {
        for (Card card: cards) {
            if(card.getName().equals(name)) {
                return card;
            }
        }
        return null;
    }
}
