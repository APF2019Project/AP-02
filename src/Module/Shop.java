package Module;

import view.Output;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Card> cards = new ArrayList<>();
    public void addCardToShop (ArrayList<Card> plants , ArrayList<Card> zombies , ArrayList<Card> account ){
        for (int i = 0; i <plants.size() ; i++) {
            for (int j = 0; j <account.size() ; j++) {
                if (plants.get(i) != account.get(j))
                {
                    cards.add(plants.get(i));
                }

            }
        }
        for (int i = 0; i <zombies.size() ; i++) {
            for (int j = 0; j <account.size() ; j++) {
                if (zombies.get(i) != account.get(j))
                {
                    cards.add(zombies.get(i));
                }
            }
        }
    }
    public ArrayList<Card> getCards(){
        return cards;
    }
    public void buyCard(Account account ,String name) {
       if(Plant.getByName(name)!= null) {
           if (getCardsByName(name) == null) {
               if (account.getCoins() >= getCardsByName(name).getPrice()) {
                   cards.add(getCardsByName(name));
                   account.setCoins(account.getCoins() - getCardsByName(name).getPrice());
               } else Output.getInstance().notEnoughMoney();
           } else Output.getInstance().soldCard();
       }else Output.getInstance().invalidCard();

    }
    public Card getCardsByName(String name){
        for (int i = 0; i <cards.size() ; i++) {
            if (cards.get(i).getName().equals(name) )
                return cards.get(i);
        }
        return null;
    }




}
