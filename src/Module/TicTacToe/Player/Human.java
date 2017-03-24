package Module.TicTacToe.Player;

import Module.TicTacToe.Model.Board;

/**
 * Created by jasper wil.lankhorst on 12-3-2017.
 */
public class Human extends Player {

    int playerNumber;
    Board board;

    public Human(Board board, int playerNumber) {
        this.board = board;
        this.playerNumber = playerNumber;
    }

    @Override
    public int move() {
        return 0;
    }

    @Override
    public String identifier() {
        return "Human Player";
    }

    @Override
    public void setPlayerNumber(int player) {
        playerNumber = player;
    }

    @Override
    public int getPlayerNumber() {
        return playerNumber;
    }

    @Override
    public void run() {
        //we do nothing oh noes!
    }
}
