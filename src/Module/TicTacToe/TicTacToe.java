package Module.TicTacToe;

import Module.TicTacToe.Controller.Controller;
import Module.TicTacToe.Model.Board;
import Module.TicTacToe.View.View;

/**
 * Created by jasper wil.lankhorst on 25-2-2017.
 */
public class TicTacToe {

    Board board;
    View view;

    public TicTacToe(String playerOne, String playerTwo) {

        view = new View();
        board = new Board(view);
        Controller controller = new Controller(view, board); //MainController of the

        controller.setPlayerOne(playerOne);
        controller.setPlayerTwo(playerTwo);
    }
}
