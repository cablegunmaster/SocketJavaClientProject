package Module.TicTacToe.Model;

import Module.TicTacToe.Model.Player.*;
import Module.TicTacToe.Model.Player.PlayerFactory;

/**
 * Created by jasper wil.lankhorst on 19-12-2016.
 */
public class Model {

    public int board[][] = new int[3][3]; //a board 3x3 filled with squares.
    public int currentPlayer = 1; //1 is Player 1. 2 is ALWAYS the opponent. //0 is unclaimed.
    public boolean gameEnded = false;
    public Player player;

    /**
     * Model to initialize the game functions.
     */

    //TODO build end condition for the game.
    //TODO send message to server game has ended.
    //TODO accept a game from a user. /duel <Human> <tictactoe>
    public Model() {
        this.ResetBoard();
        gameEnded = false;
    }

    public void setPlayer(String playerType) {
        this.player = PlayerFactory.createPlayer(playerType);
    }

    /**
     * Resets the board with only zeros on every square.
     */
    public void ResetBoard() {
        int length = board.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= board[i][j]; j++) {
                board[i][j] = 0;
            }
        }
    }

    /**
     * Check if move made is valid.
     *
     * @param i 0-8 number.
     * @return false if other number, true if between 0-8.
     */
    public boolean moveValid(int i) {

        if (i > 8 || i < 0) {
            return false;
        }
        return true;
    }

    /**
     * @param x coordinate of board
     * @param y coordinate of board
     * @return true if possible , false if occupied.
     */
    public boolean setMovePossible(int x, int y) {
        if (board[x][y] == 0) {
            board[x][y] = currentPlayer;
            return true;
        }
        return false;
    }


    /**
     * @param i between 0 and 8
     * @return location array. [0] is X [1] is Y in location array.
     */
    private int[] moveToArray(int i) {

        if (!moveValid(i)) {
            return null;
        }

        int location[] = new int[2];
        location[0] = i / 3; //X location.
        location[1] = i % 3; //Y location.

        return location;
    }

    public void setMove(int i) {

        int location[] = this.moveToArray(i);//convert to coordinates
        if (location != null && location.length == 2) {

            //location to be checked.
            int x = location[0];
            int y = location[1];

            //if valid move set the move of current Human.
            if (setMovePossible(x, y)) {
                changeCurrentPlayer();
            } else {
                //TODO print this to the view.
                System.out.println("Move is invalid");
            }
        }
    }

    public void changeCurrentPlayer() {
        if (currentPlayer == 1) {
            currentPlayer = 2;
        } else {
            currentPlayer = 1;
        }
    }

    /**
     * Checks if a Human has won.
     */
    public int checkWin() {

        int winner = 0;
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

            }
        }
        return winner;
    }

    /**
     * Checks if a Human has won diagonal.
     *
     * @return integer 0 if nobody won diagonal 1 if own Human won. 2 if opponent won.
     */
    public int checkDiagonalWin() {

        // X - -
        // - X -
        // - - X
        //left above - mid - right below. P1.
        if (board[0][0] == 1
                && board[1][1] == 1
                && board[2][2] == 1) {
            return 1;
        }

        //left below - mid - right below P2
        if (board[0][0] == 2
                && board[1][1] == 2
                && board[2][2] == 2) {
            return 2;
        }

        // - - X
        // - X -
        // X - -
        if (board[0][2] == 2
                && board[1][1] == 2
                && board[2][0] == 2) {
            return 1;
        }

        if (board[0][2] == 1
                && board[1][1] == 1
                && board[2][0] == 1) {
            return 1;
        }
        return 0;
    }

    /**
     * Get the board displayed in a board.
     *
     * @return String with the current board.
     */
    public String toString() {
        System.out.println("Board:");
        String row;
        for (int i = 0; i < board.length; i++) {
            row = "";
            for (int j = 0; j < board[0].length; j++) {
                row += this.numberToToken(board[i][j]);
            }
            System.out.println(row);
        }
        return null;
    }

    /**
     * Checks the board and print out the current 'token'
     *
     * @param i number is 0 || 1 own Human X || 2 other Human O
     * @return String containing a single letter (could be char).
     */
    private String numberToToken(int i) {

        String token = null;
        switch (i) {
            case 0:
                token = ".";
                break;
            case 1:
                token = "X";
                break;
            case 2:
                token = "O";
                break;
            default:
                token = "!";
        }
        return token;
    }
}
