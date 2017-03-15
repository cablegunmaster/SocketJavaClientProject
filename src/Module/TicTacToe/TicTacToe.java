package Module.TicTacToe;

import Controller.MainController;
import Module.TicTacToe.Controller.Controller;
import Module.TicTacToe.Model.Model;
import Module.TicTacToe.View.View;

/**
 * Created by jasper wil.lankhorst on 25-2-2017.
 */
public class TicTacToe {

    Model model;
    View view;

    public TicTacToe(String playerOne, String playerTwo) {

        view = new View();
        model = new Model(view);
        Controller controller = new Controller(view, model); //MainController of the

        controller.setPlayerOne(playerOne);
        controller.setPlayerTwo(playerTwo);
    }
}
