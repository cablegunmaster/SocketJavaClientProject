package Module.TicTacToe.View;

import javax.swing.*;

/**
 * Created by jasper wil.lankhorst on 25-2-2017.
 */
public class View {

    public JButton moveButton[];

    public View() {
        this.UI();
    }


    //Middle part.
    public void UI(){

        JPanel panel = new JPanel();
        for(int i = 0; i< 8 ;i++){
            moveButton[i] = new JButton(i + "");
        }
    }
}
