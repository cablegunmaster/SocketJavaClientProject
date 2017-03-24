package Module.TicTacToe.Player;

import Module.TicTacToe.Model.Board;


/**
 * Created by jasper wil.lankhorst on 12-3-2017.
 */
public class PlayerFactory {

    public static Player createPlayer(String playerType, Board board, int playerNumber) {
        if (playerType == null) {
            return null;
        }

        if (playerType.equals("Player")) {
            return new Human(board, playerNumber);
        }

        if (playerType.equals("Random")) {
            return new RandomAI(board, playerNumber);
        }

        if (playerType.equals("Perfect")) {
            return new PerfectAI(board, playerNumber);
        }
        return null;
    }
}
