package Module.TicTacToe.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jasper wil.lankhorst on 25-2-2017.
 */
public class View {

    public JFrame mainFrame = null;
    public JButton moveButton[] = new JButton[9];
    public String[] players = {"Human", "Random", "Perfect"};

    public View() {
        this.UI();
    }



    //Middle part.
    public void UI(){

        mainFrame = new JFrame("TicTacToe module v0.1");
        mainFrame.setResizable(false);
        mainFrame.setSize(1024, 768);

        JPanel mainPanel = createBoard();
        mainFrame.add(mainPanel, BorderLayout.CENTER);
        mainFrame.add(new JLabel("Copyright Cablegunmaster 2017"), BorderLayout.PAGE_END);

        //addListeners(mainFrame);
        mainFrame.doLayout();
        mainFrame.validate();
        mainFrame.setVisible(true);
        JPanel panel = new JPanel();
    }

    public void refresh() {
        mainFrame.doLayout();
        mainFrame.revalidate();
    }

    public JPanel createBoard(){
        JPanel board = new JPanel();
        board.setLayout(new GridLayout(3,3));
        for(int i = 0; i<= 8 ;i++){
            moveButton[i] = new JButton("-");
            moveButton[i].setFont(new Font("Arial", Font.PLAIN, 96));
            board.add(moveButton[i]);
        }
        return board;
    }


    public void setMove(int move, int player){
        JButton button = moveButton[move] ;
        if(player == 1){
            button.setText("X");
        }else{
            button.setText("O");
        }
    }

    public void resetButtons(){
        for(int i = 0; i<= 8 ;i++){
            moveButton[i] = new JButton("-");
        }
    }
}
