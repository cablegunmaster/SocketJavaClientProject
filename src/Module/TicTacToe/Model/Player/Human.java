package Module.TicTacToe.Model.Player;

/**
 * Created by jasper wil.lankhorst on 12-3-2017.
 */
public class Human implements Player {
    @Override
    public int Move() {
        return 0;
    }

    @Override
    public String Identifier() {
        return "Human Player";
    }

}
