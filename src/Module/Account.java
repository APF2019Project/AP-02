package Module;

import java.util.ArrayList;

public class Account {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private String username, password;
    private int coins;
    private ArrayList<Card> cards = new ArrayList<>();
    private Collection collection;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static void addAccount(String username, String password) {
        Account account = new Account(username, password);
        accounts.add(account);
    }

    public static Account login(String username, String password) {
        
    }
}
