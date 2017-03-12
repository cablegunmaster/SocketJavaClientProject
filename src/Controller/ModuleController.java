package Controller;

import Model.GameModel;

/**
 * Created by jasper wil.lankhorst on 12-3-2017.
 */
public class ModuleController implements GameModel {

    @Override
    public void sendMove(int move) {

    }

    @Override
    public void sendWin() {

    }

    @Override
    public void sendChat(String message) {

    }

    @Override
    public void receiveChat(String message) {

    }

    @Override
    public void requestDuel(String playerName, String game) {

    }

    @Override
    public void acceptDuel(String duelRequestName) {

    }

    @Override
    public void cancelRequestDuel(String duelRequestName) {

    }

    @Override
    public void help() {

    }

    @Override
    public void quit() {

    }

    @Override
    public void status(String playerName) {
        //current status of player.
    }
}
