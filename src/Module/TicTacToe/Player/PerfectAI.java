package Module.TicTacToe.Player;

import Module.TicTacToe.Model.Model;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;

/**
 * Created by jasper wil.lankhorst on 12-3-2017.
 */
public class PerfectAI extends Player {

    //https://www.tutorialspoint.com/java/java_multithreading.htm
    //http://neverstopbuilding.com/minimax
    //Minimax AI.

    Model model;
    int playerNumber;

    @Override
    public int move() {
        return makeMove();
    }

    public PerfectAI(Model model, int playerNumber) {
        this.model = model;
        this.playerNumber = playerNumber;
    }

    public void run() {

        while (!model.isGameEnded()) {
            if (model.getCurrentPlayer() == playerNumber) {
                int i = makeMove();
                if (model.checkValidMove(i)) {
                    model.setMove(i);
                }
            } else {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }
        }
    }


    public int makeMove() {
        //min is 0
        //max is 8
        return ThreadLocalRandom.current().nextInt(0, 8 + 0);
    }


    @Override
    public String identifier() {
        return "Perfect AI";
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    @Override
    public int getPlayerNumber() {
        return playerNumber;
    }
}
