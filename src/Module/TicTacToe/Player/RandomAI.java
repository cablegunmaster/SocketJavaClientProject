package Module.TicTacToe.Player;

import Module.TicTacToe.Model.Board;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;

/**
 * Created by jasper wil.lankhorst on 12-3-2017.
 */
public class RandomAI extends Player {

    private Board model;
    private int playerNumber;
    private Thread t;

    @Override
    public int move() {
        return makeMove();
    }

    public RandomAI(Board model, int playerNumber) {
        this.playerNumber = playerNumber;
        this.model = model;
    }

    public void run() {
        while (!model.isGameEnded()) {
            if (model.getCurrentPlayer() == playerNumber) {

                try {
                    sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while (!model.isGameEnded() && model.getCurrentPlayer() == playerNumber) {

                    int i = makeMove();
                    if (model.checkValidMove(i)) {
                        model.setMove(i);
                    }
                }

            } else {

                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("player" + playerNumber + " stopped playing");
    }


    public int makeMove() {
        //min is 0
        //max is 8
        return ThreadLocalRandom.current().nextInt(0, 9 + 0);
    }

    @Override
    public String identifier() {
        return "Random AI";
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    @Override
    public int getPlayerNumber() {
        return playerNumber;
    }
}
