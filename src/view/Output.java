package view;



public class Output {
    private static Output instance = new Output();

    private Output() {

    }

    public void printHelp(Menu menu) {
        switch (menu) {
            case MAJOR_LOGIN:
                break;
            case MAIN:
                break;
            case SIGN_UP:
                break;
            case LOGIN:
                break;
            case SHOP:
                break;
            case PLAY:
                break;
            case PROFILE:
                break;
            case LEADER_BOARD:
                break;
        }
    }

    public static Output getInstance() {
        return instance;
    }
    public void invalidAccount(){
        System.out.println("invalid account");
    }
    public void invalidCard(){
        System.out.println("invalid card");
    }
    public void soldCard(){
        System.out.println("already sold!");
    }
    public void boughtSuccessfully(){
        System.out.println("the card bought successfully!");
    }
    public void notEnoughMoney(){
        System.out.println("not enough money!");
    }
    public void showMenu(Menu menu) {
        System.out.println(" *** " + menu.name() + " Menu *** ");
    }

}