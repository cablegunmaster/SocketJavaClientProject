package Module.TicTacToe.Player;

import Module.TicTacToe.Model.Board;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;


/**
 * Created by jasper wil.lankhorst on 12-3-2017.
 * MiniMax AI for checking the best move.
 */
public class PerfectAI extends Player {

    //https://www.tutorialspoint.com/java/java_multithreading.htm
    //http://neverstopbuilding.com/minimax
    //http://www.codebytes.in/2014/08/minimax-algorithm-tic-tac-toe-ai-in.html
    //Minimax AI.

    Board model;
    int playerNumber;

    @Override
    public int move() {
        return makeMove();
    }

    public PerfectAI(Board model, int playerNumber) {
        this.model = model;
        this.playerNumber = playerNumber;
    }

    public void run() {
        while (!model.isGameEnded()) {
            if (model.getCurrentPlayer() == playerNumber) {

                try {
                    sleep(100);
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
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
//        System.out.println("Score: "+ score(model) + " playernumber"+ getPlayerNumber());

    }


    public int makeMove() {
        //min is 0
        //max is 8
        return ThreadLocalRandom.current().nextInt(0, 9 + 0);
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

    /**
     * To see the score.
     *
     * @param m Board stands for the game mechanics.
     * @return
     */
    public int score(Board m) {
        if (playerNumber == m.getCurrentPlayer() && m.isGameEnded()) {
            return 10;
        } else if (playerNumber != m.getCurrentPlayer() && m.isGameEnded()) {
            return -10;
        } else {
            return 0;
        }
    }
    
}
