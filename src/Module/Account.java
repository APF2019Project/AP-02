package Module;

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
