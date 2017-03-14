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
    public void sendPM(String message, String Player) {

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
    public String help() {
        return null;
    }

    @Override
    public void quit() {

    }

    @Override
    public String status(String playerName) {
        return null;
        //current status of player.
    }
}
