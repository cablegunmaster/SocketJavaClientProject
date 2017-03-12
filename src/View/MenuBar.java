package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by jasper wil.lankhorst on 6-2-2017.
 */
public class MenuBar {

    public MenuBar() {
    }

    public JMenuBar getAndcreateMenuBar() {
        JMenuBar menuBar = new JMenuBar(); //create menu.

        JMenu file = new JMenu("File"); //file Menu.

        JMenuItem connectToItem = new JMenuItem("Connect");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        connectToItem.setToolTipText("Connect to a server.");
        exitMenuItem.setToolTipText("Exit application");

        file.setMnemonic(KeyEvent.VK_F); //onpress F button, open menu.
        file.add(connectToItem);
        file.addSeparator();
        file.add(exitMenuItem);

        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });


        menuBar.add(file); //add to menu.

        return menuBar;
    }
}
