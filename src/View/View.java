package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jasper wil.lankhorst on 25-2-2017.
 * Idea of this class is to test the View.
 */
public class View {

    JFrame mainFrame = null;
    MainWindow mainWindow;

    public static void main(String args[]) {
        new View();
    }

    public View() {
        mainFrame = new JFrame("Client module v0.1");
        mainFrame.setResizable(false);
        mainFrame.setSize(1024, 768);

        MenuBar bar = new MenuBar();
        mainFrame.add(bar.getAndcreateMenuBar(), BorderLayout.NORTH);

        mainWindow = new MainWindow();
        JPanel mainPanel = mainWindow.getMainPanel();
        mainFrame.add(mainPanel, BorderLayout.CENTER);

        mainFrame.add(new JLabel("Copyright Cablegunmaster : " + getYear()), BorderLayout.PAGE_END);

        addListeners(mainFrame);
        mainFrame.validate();
        mainFrame.setVisible(true);
    }

    public void addListeners(JFrame mainFrame) {

        //Automatic closer function.
        JFrame.setDefaultLookAndFeelDecorated(true);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    private String getYear() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String year = simpleDateFormat.format(new Date());
        return year;
    }

    /**
     * Option to display the error if not connected.
     * Mainframe is always set.
     */
    public void displayConnectError() {
        //custom title, error icon
        JOptionPane.showMessageDialog(mainFrame,
                "Server is not found.",
                "Connection error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void displayChatMessageSendNotConnectedError() {
        JOptionPane.showMessageDialog(mainFrame,
                "Message not send, maybe you are not connected?",
                "Connection error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void refresh() {
        mainFrame.doLayout();
        mainFrame.revalidate();
    }

    public JTextArea getChatTextArea() {
        return mainWindow.getChatTextArea();
    }

    public JTextField getChatInput() {
        return mainWindow.getChatInputField();
    }

    public JButton setConnectButton() {
        return mainWindow.setConnectButton();
    }

    public Integer getPortNumber() {
        String[] serverAndPort = mainWindow.getServerTextField().getText().split(":");
        if (serverAndPort[1] != null) {
            String port = serverAndPort[1];
            return Integer.parseInt(port);
        }
        return null;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }
}
