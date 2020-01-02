package view;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Request {
    private static final Request request = new Request();
    private ArrayList<Menu> menus = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private MajorLoginCommand lastMajorLoginCommand;
    private LoginCommand lastLoginCommand;
    private boolean invalidCommand = false;
    private MainMenuCommand lastMainMenuCommand;
    private LeaderBoardCommand lastLeaderBoardCommand;
    private ShopCommand lastShopCommand;
    private boolean exit = false;
    private boolean help = false;

    private Request() {
        menus.add(Menu.MAJOR_LOGIN);
    }

    public static Request getInstance() {
        return request;
    }

    public void getRequest() {
        String command = scanner.nextLine();
        if (command.equals("exit")) {
            exit = true;
            return;
        }
        if (command.equals("help")) {
            help = true;
            return;
        }
        transferCommandToRightPlace(command);
    }

    public void transferCommandToRightPlace(String command) {
        switch (getCurrentMenu()) {
            case MAJOR_LOGIN:
                majorLogin(command.toLowerCase());
                break;
            case LOGIN:
                login(command.toLowerCase());
                break;
            case SIGN_UP:
                signUp(command);
                break;
            case LEADER_BOARD:
                leaderBoard();
                break;
        }
    }

    private void leaderBoard() {
        invalidCommand = true;
    }

    private void signUp(String command) {
        if (command.matches("\\w+ \\w+")) {
            LoginCommand loginCommand = LoginCommand.USERNAME_PASSWORD;
            loginCommand.setName(command.split(" ")[0]);
            loginCommand.setPassword(command.split(" ")[1]);
            lastLoginCommand = loginCommand;
        } else {
            invalidCommand = true;
        }
    }

    public void shop(String command) {
    }

    public void setCommandOfShop(Matcher matcher, int i) {
    }

    public void login(String command) {
        if (command.matches("\\w+ \\w+")) {
            LoginCommand loginCommand = LoginCommand.USERNAME_PASSWORD;
            loginCommand.setName(command.split(" ")[0]);
            loginCommand.setPassword(command.split(" ")[1]);
            lastLoginCommand = loginCommand;
        } else {
            invalidCommand = true;
        }
    }


    public void majorLogin(String command) {
        if (command.equals("login")) {
            lastMajorLoginCommand = MajorLoginCommand.LOGIN;
        } else if (command.equals("leader board")) {
            lastMajorLoginCommand = MajorLoginCommand.LEADER_BOARD;
        } else if (command.equals("create account")) {
            lastMajorLoginCommand = MajorLoginCommand.SIGN_UP;
        } else {
            invalidCommand = true;
        }
    }
    public void Shop(String command){
        if (command.matches("buy \\w+")){
            ShopCommand shopCommand = ShopCommand.BUY;
            shopCommand.setName(command.split(" ")[1]);
            lastShopCommand =shopCommand;
        }else if (command.equals("show shop")){
            lastShopCommand= ShopCommand.SHOW_SHOP;
        }else if( command.equals("show my cards")){
            lastShopCommand= ShopCommand.SHOW_MY_CARDS;
        }else if(command.equals("money")){
            lastShopCommand = ShopCommand.MONEY;
        }
    }

    public void setCommandOfMajorLogin(int i) {
        lastMajorLoginCommand = MajorLoginCommand.values()[i];
    }

    public MajorLoginCommand getLastMajorLoginCommand() {
        return lastMajorLoginCommand;
    }

    public void nextMenu(Menu menu) {
        menus.add(menu);
    }

    public Menu getCurrentMenu() {
        return menus.get(menus.size() - 1);
    }

    public void exit() {
        menus.remove(menus.size() - 1);
    }

    public LoginCommand getLastLoginCommand() {
        return lastLoginCommand;
    }

    public boolean isInvalidCommand() {
        return invalidCommand;
    }

    public void setInvalidCommand(boolean invalidCommand) {
        this.invalidCommand = invalidCommand;
    }

    public MainMenuCommand getLastMainMenuCommand() {
        return lastMainMenuCommand;
    }

    public void setLastMainMenuCommand(MainMenuCommand lastMainMenuCommand) {
        this.lastMainMenuCommand = lastMainMenuCommand;
    }

    public LeaderBoardCommand getLastLeaderBoardCommand() {
        return lastLeaderBoardCommand;
    }

    public void setLastLeaderBoardCommand(LeaderBoardCommand lastLeaderBoardCommand) {
        this.lastLeaderBoardCommand = lastLeaderBoardCommand;
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public boolean isHelp() {
        return help;
    }

    public void setHelp(boolean help) {
        this.help = help;
    }

    public void setLastLoginCommand(LoginCommand lastLoginCommand) {
        this.lastLoginCommand = lastLoginCommand;
    }

    public ShopCommand getLastShopCommand() {
        return lastShopCommand;
    }

    public void setLastShopCommand(ShopCommand lastShopCommand) {
        this.lastShopCommand = lastShopCommand;
    }
}