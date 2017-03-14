package Module.TicTacToe;

import Module.TicTacToe.Controller.Controller;
import Module.TicTacToe.Model.Model;
import Module.TicTacToe.Model.Player.Player;
import Module.TicTacToe.Model.Player.PlayerFactory;
import Module.TicTacToe.View.View;

/**
 * Created by jasper wil.lankhorst on 25-2-2017.
 */
public class TicTacToe {

    Model model;
    View view;

    public TicTacToe() {
        view = new View();
        model = new Model(view);
        Controller controller = new Controller(view, model); //Controller of the
    }

    public void setPlayerOne(String playerOne) {
        Player pl = PlayerFactory.createPlayer(playerOne, model);
    }

    public void setPlayerTwo(String playerTwo) {
        PlayerFactory.createPlayer(playerTwo, model);
    }
}
