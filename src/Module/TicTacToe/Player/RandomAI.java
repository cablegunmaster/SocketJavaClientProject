package Module.TicTacToe.Player;

import Module.TicTacToe.Model.Model;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;

/**
 * Created by jasper wil.lankhorst on 12-3-2017.
 */
public class RandomAI extends Player {

    Model model;
    int playerNumber;
    private Thread t;

    @Override
    public int move() {
        return makeMove();
    }

    public RandomAI(Model model, int playerNumber) {
        this.playerNumber = playerNumber;
        this.model = model;
    }

    public void run() {

        while (!model.isGameEnded()) {
            if (model.getCurrentPlayer() == playerNumber) {

                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int i = makeMove();
                if (model.checkValidMove(i)) {
                    model.setMove(i);
                }

            } else {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void start() {
        System.out.println("Starting: " + identifier());
        if (t == null) {
            t = new Thread(this, identifier());
            t.start();
        }
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
