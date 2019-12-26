package Module;

import view.Output;

import java.util.ArrayList;

public class Account {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private String username, password;
    private int coins;
    private int killedZombies;
    private ArrayList<Card> hand = new ArrayList<>(7);
    private Collection collection;
    private Shop shop;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public static void addAccount(String username, String password) {
        Account account = new Account(username, password);
        accounts.add(account);
    }

    public static Account login(String username, String password) {
        for (Account account: accounts) {
            if (account.username.equals(username)) {
                if (account.password.equals(password)) {
                    return account;
                }
            }
        }
        return null;
    }
    public void readyShop(){
        shop.addCardToShop(Plant.getPlant() , Zombie.getZombies(),collection.getCards());
    }
    public void showMyCards(){
        for (int i = 0; i <collection.getCards().size() ; i++) {
            Output.getInstance().printMyCards(collection.getCards().get(i).getName());
        }
    }
    public void ShowShopCard(){
        for (int i = 0; i <shop.getCards().size() ; i++) {
           Output.getInstance().printShopCards( shop.getCards().get(i).getName(),shop.getCards().get(i).getPrice());
        }
    }
    public void setCoins(int coins){
        this.coins = coins;
    }


    public int getCoins() {
        return coins;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void deleteAccount() {

    }

    public void showHand() {

    }
}
