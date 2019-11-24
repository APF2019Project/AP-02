package Controller;

import Module.*;
import java.util.Scanner;

public class Controller {
    private static Account loggedAccount;
    private enum MenuStatus {
        LOGIN{
            private void createAccount(String username, String password) {
                Account.addAccount(username, password);
                setState(LOGIN);
            }

            private void login(String username, String password) {
                loggedAccount = Account.login(username, password);
            }
            @Override
            public void runCommand(String input) {

            }
        }, LEADERBOARD, MAIN_MENU, PROFILE, PLAY, COLLECTION, SHOP, DAY_WATER, RAIL, ZOMBIE, PVP;

        private MenuStatus state;

        public void runCommand(String toLowerCase) {
        }

        public MenuStatus getState() {
            return state;
        }

        public void setState(MenuStatus state) {
            this.state = state;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        MenuStatus menuStatus = MenuStatus.LOGIN;
        menuStatus.state = MenuStatus.LOGIN;
        do{
            input = scanner.nextLine();
            menuStatus.getState().runCommand(input.toLowerCase());
        } while (!(menuStatus == MenuStatus.LOGIN && input.matches("exit")));
    }
}
