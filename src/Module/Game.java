package Module;

public class Game {
    public enum GameMode {
        DAY, WATER, RAIL, ZOMBIE, MULTIPLAYER
    }

    private int sun;
    private int coin;
    private Playground playground;
    private Account[] players = new Account[2];
    private GameMode gameMode;
}
