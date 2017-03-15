package View;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by jasper wil.lankhorst on 25-2-2017.
 */
public class MainWindow {

    private JButton sendChatButton;
    private JTextField chatInputField;
    private JTextArea chatTextArea;
    private JTextArea userListTextArea;
    private JPanel chatPanel;
    private JPanel menuPanel;
    private JLabel userLabel;
    private JTabbedPane tabbedPane1;
    private JPanel modules;
    private JPanel server;
    private JTextField serverTextField;
    private JTextField usernameTextField;
    private JButton connectButton;
    private JPanel mainPanel;
    private JLabel chatLabel;
    private JScrollPane ChatScrollable;
    private JLabel connectionStatusLabel;
    private JButton launchButton;
    private JLabel PlayerLabel;
    private JComboBox<String> moduleList;
    private JComboBox<String> playerOneList;
    private JComboBox<String> playerTwoList;

    public MainWindow() {

    }

    public JButton setConnectButton() {
        return connectButton;
    }

    public JTextField getChatInputField() {
        return chatInputField;
    }


    public JTextArea getUserListTextArea() {
        return userListTextArea;
    }

    public JTextArea getChatTextArea() {
        return chatTextArea;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextField getServerTextField() {
        return serverTextField;
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public JLabel getConnectionStatusLabel() {
        return connectionStatusLabel;
    }

    private void createUIComponents() {
        String[] modules = {"TicTacToe", "???"};
        moduleList = new JComboBox<>(modules);

        String[] players = {"Human", "Random", "Perfect"};
        playerOneList = new JComboBox<>(players);
        playerTwoList = new JComboBox<>(players);
        // TODO: place custom component creation code here
    }

    public JButton getLaunchButton() {
        return launchButton;
    }

    public JComboBox<String> getPlayerOneList() {
        return playerOneList;
    }

    public JComboBox<String> getPlayerTwoList() {
        return playerTwoList;
    }
}
