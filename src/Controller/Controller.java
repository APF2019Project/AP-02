package Controller;


import view.*;

import java.util.ArrayList;


public class Controller {
    private final static Controller instance = new Controller();
    private boolean endGame = false;
//    private ArrayList<Menu> menus = new ArrayList<>();

    private Controller() {
//        menus.add(Menu.MAJOR_LOGIN);
    }

    public static Controller getInstance() {
        return instance;
    }

    public void main() {
        Request request = Request.getInstance();
        while (!endGame) {
            Output.getInstance().showMenu(request.getCurrentMenu());

            request.getRequest();

            if (firstCheck()) {
                continue;
            }

            commandManagement(request, request.getCurrentMenu());

            //TODO output
        }
    }

    private void commandManagement(Request request, Menu currentMenu) {
        switch (currentMenu) {
            case MAJOR_LOGIN:
                majorLoginMenu(request.getLastMajorLoginCommand());
                break;
            case LOGIN:
                loginMenu(request.getLastLoginCommand());
                break;
            case LEADER_BOARD:
                leaderBoard();
                break;
            case SIGN_UP:
                signUp(request.getLastLoginCommand());
                break;
            case MAIN:
                mainMenu(request.getLastMainMenuCommand());
                break;
        }
    }

    private void majorLoginMenu(MajorLoginCommand majorLoginCommand) {
        switch (majorLoginCommand) {
            case LOGIN:
                Request.getInstance().nextMenu(Menu.LOGIN);
                break;
            case EXIT:
                endGame();
                break;
            case SIGN_UP:
                Request.getInstance().nextMenu(Menu.SIGN_UP);
                break;
            case LEADER_BOARD:
                Request.getInstance().nextMenu(Menu.LEADER_BOARD);
        }
    }


    private boolean firstCheck() {
        if (Request.getInstance().isInvalidCommand()) {
            System.out.println("invalid Command");
            Request.getInstance().setInvalidCommand(false);
            return true;
        }
        if (Request.getInstance().isExit()) {
            exit();
            Request.getInstance().setExit(false);
            return true;
        }
        if (Request.getInstance().isHelp()) {
            help();
            Request.getInstance().setHelp(false);
            return true;
        }
        return false;
    }

    private void help() {
        switch (Request.getInstance().getCurrentMenu()) {
            case MAIN:
                break;
            case SIGN_UP:
                break;
            case LEADER_BOARD:
                break;
            case PROFILE:
                break;
            case SHOP:
                break;
            case PLAY:
                break;
            case MAJOR_LOGIN:
                break;
            case LOGIN:
                break;
        }
        System.out.println("help");
    }


    private void mainMenu(MainMenuCommand lastMainMenuCommand) {
        switch (lastMainMenuCommand) {
            case PROFILE:
                profile();
                break;
            case PLAY:
                play();
                break;
            case SHOP:
                shop();
                break;
        }
    }

    private void profile() {
        Request.getInstance().nextMenu(Menu.PROFILE);
    }

    private void play() { //todo don't touch this for now because battle is not ready yet!
        Request.getInstance().nextMenu(Menu.PLAY);
    }

    private void shop() { //todo don't touch this it's mine
        Request.getInstance().nextMenu(Menu.SHOP);
    }


    public void endGame() {
        endGame = true;
    }

    private void exit() {
        if (Request.getInstance().getCurrentMenu().equals(Menu.MAJOR_LOGIN)) {
            endGame();
            return;
        }
        Request.getInstance().exit();
    }

    private void leaderBoard() {
        //TODO show leader board
    }

    private void signUp(LoginCommand loginCommand) {
        String name = loginCommand.getName();
        String password = loginCommand.getPassword();
        //TODO handle sign up
        System.out.println(name + " create successfully");
        Request.getInstance().nextMenu(Menu.MAJOR_LOGIN);
        Request.getInstance().nextMenu(Menu.MAIN);
    }

    public void loginMenu(LoginCommand loginCommand) {
        String name = loginCommand.getName();
        String password = loginCommand.getPassword();
        //TODO handle login
        System.out.println(name + " login successfully");
        Request.getInstance().nextMenu(Menu.MAJOR_LOGIN);
        Request.getInstance().nextMenu(Menu.MAIN);
    }

    public void shopMenu(ShopCommand shopCommand) {

    }


    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

}