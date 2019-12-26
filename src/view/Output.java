package view;



public class Output {
    private static Output instance = new Output();

    private Output() {

    }
    public void menuHelp(){
        System.out.println("play");
        System.out.println("shop");
        System.out.println("profile");
        System.out.println("exit");
    }
    public void signInHelp(){
        System.out.println("exit");
        System.out.println("newUserName password");
    }
    public void leaderBoardHelp(){
        System.out.println("exit");
    }
    public void profileHelp(){
        System.out.println("change");
        System.out.println("delete");
        System.out.println("rename");
        System.out.println("create");
        System.out.println("show");
        System.out.println("exit");
    }
    public void shopHelp(){
        System.out.println("show shop");
        System.out.println("show collection");
        System.out.println("buy <cardName>");
        System.out.println("money");
        System.out.println("exit");
    }
    public void playHelp(){
        System.out.println("day");
        System.out.println("water");
        System.out.println("rail");
        System.out.println("zombie");
        System.out.println("exit");
        System.out.println("pvp");
        System.out.println("exit");
    }
    public void majorLogin(){
        System.out.println("login");
        System.out.println("create account");
        System.out.println("leader board");
        System.out.println("exit");
    }
    public void loginHelp(){
        System.out.println("username password");
        System.out.println("exit");
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
    public void invalidCommand(){System.out.println("invalid Command");}
    public void boughtSuccessfully(){
        System.out.println("the card bought successfully!");
    }
    public void notEnoughMoney(){
        System.out.println("not enough money!");
    }
    public void showMenu(Menu menu) {
        System.out.println(" *** " + menu.name() + " Menu *** ");
    }
    public  void printShopCards(String string , int price){
        System.out.println( string + " " +price);
    }
    public void printMyCards(String string){
        System.out.println(string);
    }

}