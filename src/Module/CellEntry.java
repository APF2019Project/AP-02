package Module;

import java.util.ArrayList;

public class CellEntry {
    private Card card;
    private Effect effect = null;

    public CellEntry() {
    }

    public CellEntry(Card card) {
        this.card = card;
    }

    public CellEntry(Card card, Effect effect) {
        this.card = card;
        this.effect = effect;
    }

    public Card getCard() {
        return card;
    }

    public Effect getEffect() {
        return effect;
    }

    public static ArrayList<Card> getCards(ArrayList<CellEntry> cellEntries) {
        ArrayList<Card> cards = new ArrayList<>();
        for (CellEntry cellEntry : cellEntries) {
            cards.add(cellEntry.getCard());
        }
        return cards;
    }
}
