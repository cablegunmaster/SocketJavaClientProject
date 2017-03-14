package Module.TicTacToe.Model;


import java.util.concurrent.ThreadLocalRandom;

import Module.TicTacToe.View.View;

/**
 * Created by jasper wil.lankhorst on 19-12-2016.
 */
public class Model {

    private int board[][] = new int[3][3]; //a board 3x3 filled with squares.
    private int currentPlayer = 1; //1 is Player 1. 2 is ALWAYS the opponent. //0 is unclaimed.
    private boolean gameEnded = false;
    private View view;

    /**
     * Model to initialize the game functions.
     */

    //TODO build end condition for the game.
    //TODO send message to server game has ended.
    //TODO accept a game from a user. /duel <Human> <tictactoe>
    public Model(View view) {
        this.ResetBoard();
        gameEnded = false;
        this.view = view;
    }

    public int getPlayerFirst() {
        //min is 1
        //max is 2
        int randomNum = ThreadLocalRandom.current().nextInt(1, 2 + 1);
        return randomNum;
    }

    public void resetGame() {
        this.ResetBoard();
        gameEnded = false;
        currentPlayer = getPlayerFirst();
    }

    /**
     * Resets the board with only zeros on every square.
     */
    public void ResetBoard() {
        if(view != null) {
            view.resetButtons();
        }
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
            return true;
        }
        return false;
    }

    /**
     * @param i between 0 and 8
     * @return location array. [0] is X [1] is Y in location array.
     */
    public int[] moveToArray(int i) {

        if (!moveValid(i)) {
            return null;
        }

        int location[] = new int[2];
        location[0] = i / 3; //X location.
        location[1] = i % 3; //Y location.

        return location;
    }

    public boolean checkValidMove(int i) {
        int location[] = moveToArray(i);//convert to coordinates
        if (location != null && location.length == 2) {
            //location to be checked.
            int x = location[0];
            int y = location[1];

            //if valid move set the move of current Human.
            if (setMovePossible(x, y)) {
                return true;
            }
        }
        return false;
    }

    public void setMove(int i) {

        int location[] = this.moveToArray(i);//convert to coordinates
        if (location != null && location.length == 2) {

            //location to be checked.
            int x = location[0];
            int y = location[1];

            //if valid move set the move of current Human.
            if (setMovePossible(x, y)) {
                board[x][y] = currentPlayer;
                int winner = checkWin();
                view.setMove(i, currentPlayer);

                if (!gameEnded && winner == 0) {
                    changeCurrentPlayer();
                } else {
                    //send move to other player before ending the game.
                    gameEnded = true;
                }

            } else {
                //TODO print to the view.
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
     * Checks if a Person has won.
     */
    public int checkWin() {
        Boolean winningRow = false;
        //Check if winningrow is winning.
        winningRow = checkWinner(currentPlayer);
        if (winningRow) {
            return currentPlayer;
        }
        return 0;
    }

    public Boolean checkWinner(Integer player) {
        //Horizontal wins.
        if (board[0][0] == player && board[0][1] == player && board[0][2] == player ||
                board[1][0] == player && board[1][1] == player && board[1][2] == player ||
                board[2][0] == player && board[2][1] == player && board[2][2] == player) {
            return true;
        }

        //Vertical win.
        if (board[0][0] == player && board[1][0] == player && board[2][0] == player ||
                board[0][1] == player && board[1][1] == player && board[2][1] == player ||
                board[0][2] == player && board[1][2] == player && board[2][2] == player) {
            return true;
        }

        //Diagonal win.
        if (checkDiagonalWin(player)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if a Human has won diagonal.
     *
     * @return integer 0 if nobody won diagonal 1 if own Human won. 2 if opponent won.
     */
    public Boolean checkDiagonalWin(Integer player) {

        // X - -
        // - X -
        // - - X
        //left above - mid - right below. P1.
        if (board[0][0] == player
                && board[1][1] == player
                && board[2][2] == player) {
            return true;
        }

        // - - X
        // - X -
        // X - -
        if (board[0][2] == player
                && board[1][1] == player
                && board[2][0] == player) {
            return true;
        }

        return false;
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

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public int[][] getBoard() {
        return board;
    }
}
