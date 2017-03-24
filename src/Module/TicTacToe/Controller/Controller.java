package Module.TicTacToe.Controller;

import Model.GameModel;
import Module.TicTacToe.Model.Board;
import Module.TicTacToe.Player.Player;
import Module.TicTacToe.Player.PlayerFactory;
import Module.TicTacToe.View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jasper wil.lankhorst on 25-2-2017.
 */
public class Controller implements GameModel {

    View view;
    Board model;
    Controller controller;

    public Controller(View view, Board model) {
        this.view = view;
        this.model = model;
        setListeners();
    }

    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (!model.isGameEnded()) {
                JButton[] jButtonList = view.getJButtonList();
                for (JButton button : jButtonList) {
                    if (e.getSource() == button) {
                        int identifier = -1;
                        Object property = button.getClientProperty("id");
                        if (property instanceof Integer) {
                            identifier = ((Integer) property);
                            // do stuff
                        }

                        if (button.getText().equals("-")) {
                            button.setText(model.numberToToken(model.getCurrentPlayer()));
                            model.setMove(identifier);
                        }
                    }
                }
            } else {
                System.out.println("BYE BYE PLAY AGAIN.");
            }
        }
    }

    public void setListeners() {
        JButton[] jButtonList = view.getJButtonList();
        for (JButton button : jButtonList) {
            button.addActionListener(new ButtonListener());
        }
    }

    //combine this to the JComboBox.
    public void setPlayerOne(String playerOneIdentifier) {
        model.setPlayerOne(playerOneIdentifier);
    }


    public void setPlayerTwo(String playerTwoIdentifier) {
        model.setPlayerTwo(playerTwoIdentifier);
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
