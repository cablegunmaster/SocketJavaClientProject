package tests;

import Module.TicTacToe.View.View;
import Module.TicTacToe.Model.Board;

/**
 * Created by jasper wil.lankhorst on 19-12-2016.
 */
public class testBoard {

    public String Board[][] = new String[3][3];

    public static void main(String[] args) {
        new testBoard();
    }

    public testBoard() {

        //System.out.println("M:-1 " + this.moveToArray(-1) );
        for (int i = 0; i < 11; i++) {
            System.out.println("M:" + i + " " + this.moveToArray(i));
        }

        View v = new View();
        v.mainFrame.setVisible(false);

       /* Board m = new Board(v);
        m.setMove(2);
        m.toString();
        m.setMove(4); //other player
        m.toString();
        m.setMove(6);
        m.toString();
        m.setMove(0);
        m.toString();
        m.setMove(8);
        m.toString();
        m.setMove(7);
        m.toString();
        m.setMove(5);
        m.toString();*
        int i = m.checkWin();
        System.out.println("won:" + i);*/
    }

    public boolean moveValid(int i) {
        if (i > 8 || i < 0) {
            return false;
        }
        return true;
    }

    /**
     * @param i between 1 and 9
     * @return X & Y String
     */
    public String moveToArray(int i) {

        if (!moveValid(i)) {
            return null;
        }

        String boardX = i / 3 + "";
        String boardY = i % 3 + "";

        return boardX + " " + boardY;
    }
}
