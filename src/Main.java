import Controller.Controller;
import Module.CardGenerator;

public class Main {
    public static void main(String[] args) {
        CardGenerator.importCards();
        Controller.getInstance().main();
    }
}
