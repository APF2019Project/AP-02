package Module;

public class Game {
    public enum GameMode {
        DAY, WATER, RAIL, ZOMBIE, MULTIPLAYER
    }

    private int turn = 0;
    private int killedZombies = 0;
    private int sun;
    private int coin;
    private Playground playground;
    private Account[] players = new Account[2];
    private GameMode gameMode;


    public void setPlayground() {
        playground = new Playground(gameMode);
    }

    public void endTurn() {
    turn +=1 ;
    playground.moveCards();

    }
}
