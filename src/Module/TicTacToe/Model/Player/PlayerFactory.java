package Module.TicTacToe.Model.Player;

import Module.TicTacToe.Model.Model;


/**
 * Created by jasper wil.lankhorst on 12-3-2017.
 */
public class PlayerFactory {

    public static Player createPlayer(String playerType, Model model) {
        if (playerType == null) {
            return null;
        }

        if (playerType.equals("Player")) {
            return new Human();
        }

        if (playerType.equals("Random")) {
            return new RandomAI(model);
        }

        if (playerType.equals("Perfect")) {
            return new PerfectAI(model);
        }
        return null;
    }
}
