package Module.TicTacToe.Player;

import Module.TicTacToe.Model.Board;
import Module.TicTacToe.Model.Point;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;


/**
 * Created by jasper wil.lankhorst on 12-3-2017.
 * MiniMax AI for checking the best move.
 */
public class PerfectAI extends Player {

    //https://www.tutorialspoint.com/java/java_multithreading.htm
    //http://neverstopbuilding.com/minimax
    //http://www.codebytes.in/2014/08/minimax-algorithm-tic-tac-toe-ai-in.html
    //Checked on 28-03-2017
    //Minimax AI.

    private Board model;
    private int playerNumber;
    List<Point> availablePoints;
    Point computersMove;

    public PerfectAI(Board model, int playerNumber) {
        this.model = model;
        this.playerNumber = playerNumber;
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

                    System.out.println("Calculting move");
                    if (!model.isGameEnded()) {

                        int pos = minimaxv2(0, playerNumber);
                        int i = (computersMove.x * 3) + computersMove.y; //coordinates to int

                        if (model.checkValidMove(i)) {
                            model.setMove(computersMove.x, computersMove.y);
                        }
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

    @Override
    public int move() {
        return 0;
    }

    @Override
    public int getPlayerNumber() {
        return playerNumber;
    }

    @Override
    public String identifier() {
        return "Perfect AI";
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }


    public List<Point> getAvailableStates() {
        availablePoints = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (model.getBoard()[i][j] == 0) {
                    availablePoints.add(new Point(i, j));
                }
            }
        }
        return availablePoints;
    }

    public void placeAMove(Point point, int player) {
        model.getBoard()[point.x][point.y] = player;   //player = 1 for X, 2 for O
    }

    /**
     * @param depth
     * @param turn
     * @return
     */
    public int minimaxv2(int depth, int turn) {

        int otherPlayer;
        if (playerNumber == 1) {
            otherPlayer = 2;
        } else {
            otherPlayer = 1;
        }

        if (model.checkWinner(playerNumber)) return +1;
        if (model.checkWinner(otherPlayer)) return -1;

        List<Point> pointsAvailable = getAvailableStates();
        if (pointsAvailable.isEmpty()) return 0;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < pointsAvailable.size(); ++i) {
            Point point = pointsAvailable.get(i);

            //p;layer who needs to win.
            if (turn == playerNumber) {
                placeAMove(point, playerNumber);
                int currentScore = minimaxv2(depth + 1, otherPlayer);
                max = Math.max(currentScore, max);

                if (depth == 0) System.out.println("Score for position " + (i + 1) + " = " + currentScore);
                if (currentScore >= 0) {
                    if (depth == 0) computersMove = point;
                }
                if (currentScore == 1) {
                    model.getBoard()[point.x][point.y] = 0;
                    break;
                }
                if (i == pointsAvailable.size() - 1 && max < 0) {
                    if (depth == 0) computersMove = point;
                }
            } else if (turn == otherPlayer) {
                placeAMove(point, otherPlayer);
                int currentScore = minimaxv2(depth + 1, playerNumber);
                min = Math.min(currentScore, min);
                if (min == -1) {
                    model.getBoard()[point.x][point.y] = 0;
                    break;
                }
            }
            model.getBoard()[point.x][point.y] = 0; //Reset this point
        }
        return turn == playerNumber ? max : min;
    }

}
