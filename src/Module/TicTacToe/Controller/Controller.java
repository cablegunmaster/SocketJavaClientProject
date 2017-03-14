package Module.TicTacToe.Controller;

import Module.TicTacToe.Model.Model;
import Module.TicTacToe.View.View;
import Model.GameModel;

/**
 * Created by jasper wil.lankhorst on 25-2-2017.
 */
public class Controller implements GameModel {

    View view;
    Model model;
    Controller controller;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void sendMove(int i) {
        model.setMove(i);
        //todo make sendTEXT action.
        //this.sendText("Move "+ i);
    }

    @Override
    public void sendWin() {
        //Send to other player request or bot.
    }

    @Override
    public void sendPM(String message, String Player) {

    }

    @Override
    public void requestDuel(String playerName, String game) {
            //Request duel to other player.
    }

    @Override
    public void acceptDuel(String duelRequestName) {
            //Accept duel. (send duel request to other player.)
    }

    @Override
    public void cancelRequestDuel(String duelRequestName) {
            //send duel request to player.
    }

    @Override
    public String help() {
        //show all arguments
        return "TicTacToe options: /r/n " +
                "/move - 0-8 in TicTacToe /r/n" +
                "/quit to quit the game /r/n" +
                "/help to show this message! /r/n";
    }

    @Override
    public void quit() {
        //remove module from launcher
    }

    @Override
    public String status(String playerName) {
        if (!model.isGameEnded()) {
            return playerName + " ended playing TicTacToe game";
        } else if (model.isGameEnded()) {
            return playerName + " is playing TicTacToe game";
        }
        return playerName + "is idle";
    }

    public void receiveMove(int i) {
        model.setMove(i);
    }
}
