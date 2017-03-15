package Module.TicTacToe.Player;

/**
 * Created by jasper wil.lankhorst on 12-3-2017.
 */
public abstract class Player implements Runnable {

    public abstract int move();

    public abstract String identifier();

    public abstract void setPlayerNumber(int player);

    public abstract int getPlayerNumber();

}
