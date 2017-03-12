package Module.TicTacToe.Model.Player;

/**
 * Created by jasper wil.lankhorst on 12-3-2017.
 */
public class PlayerFactory {

    public static Player createPlayer(String playerType) {
        if (playerType == null) {
            return null;
        }

        if (playerType.equals("Player")) {
            return new Human();
        }

        if (playerType.equals("Random")) {
            return new RandomAI();
        }

        if (playerType.equals("Perfect")) {
            return new PerfectAI();
        }
        return null;
    }
}
