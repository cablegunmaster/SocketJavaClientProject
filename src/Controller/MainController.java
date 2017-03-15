package Controller;

import Model.*;
import Module.TicTacToe.TicTacToe;
import View.*;
import utils.Logger;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jasper wil.lankhorst on 18-11-2016.
 * //TODO split this better and make a format for command:  <arg[0] command> SPACE <arg[1] Human> SPACE <arg [2] ignore || chatmsg >
 */
public class MainController {

    private Model model;
    private View view;
    private MainController mainController;

    public MainController(Model m, View v) {
        this.model = m;
        this.view = v;
        this.mainController = this;

        //build up the listeners, this will help the buttons interact with the rest.
        setListeners();
    }

    private void setListeners() {
        //view . add listener to object.
        view.getMainWindow().getLaunchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playerOne = view.getMainWindow().getPlayerOneList().getModel().getSelectedItem().toString();
                String playerTwo = view.getMainWindow().getPlayerTwoList().getModel().getSelectedItem().toString();
                new TicTacToe(playerOne, playerTwo);
            }
        });

        view.setConnectButton().addActionListener(this.connectListener());
        view.getChatInput().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO add some logic to send this to the server.
                //Refactor to the MainController.
                String input = view.getChatInput().getText();
                if (model.isConnected()) {


                    if (!input.equals("")) {
                        if (input.startsWith("/") && !input.startsWith("/chat")) {
                            model.getPrintWriter().println(input + "\n");
                        } else {
                            model.getPrintWriter().println("/chat " + view.getMainWindow().getUsernameTextField().getText() + " " + input + "\n");
                        }
                        model.getPrintWriter().flush();
                    }

                } else {

                    if (input != null && input.startsWith("/")) {

                        //runModule?
                    } else if (input != null) {
                        addStringToChat("Offline: " + input);
                    }
                    //Logger.get().log("Send chat message and not connected.");
                    //view.displayChatMessageSendNotConnectedError();
                    //Display notification error.
                }
                view.getChatInput().setText("");
            }
        });
    }


    /**
     * Checks if the button is connected or not.
     *
     * @return ActionListener to be applied to a button.
     */
    private ActionListener connectListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Connect and disconnect button handler.
                Logger.get().log("Trying to establish connection..");

                //if text says disconnect, and onClick it will connect.
                if (view.setConnectButton().getText().toUpperCase().equals("DISCONNECT")) {
                    disconnect();
                } else {
                    Socket socket = model.connect();

                    //if succesfull connected change text
                    if (socket != null && model.isConnected()) {
                        view.setConnectButton().setText("Disconnect");
                        Thread thread = model.setListenThread(socket, mainController);
                        Logger.get().log("Succesfully connected");
                        addStringToChat("Succesfully connected:");
                        view.getMainFrame().setTitle("Client module v0.1 - Connected to the server.");

                        //set the label.
                        view.getMainWindow().getConnectionStatusLabel().setForeground(Color.GREEN);
                        view.getMainWindow().getConnectionStatusLabel().setText("Connected");

                        model.getPrintWriter().print("/connect " + view.getMainWindow().getUsernameTextField().getText() + " \n");
                        model.getPrintWriter().flush();
                    } else {
                        view.displayConnectError();
                    }
                    //else do nothing
                }
            }
        };
    }

    public View getView() {
        return view;
    }

    public Model getModel() {
        return model;
    }

    public void disconnect() {
        model.getPrintWriter().println("/disconnect\n");
        model.getPrintWriter().flush();

        model.disconnect();
        view.getMainWindow().getUserListTextArea().setText("");
        view.getMainWindow().getChatTextArea().setText("Disconnected from Server. \n");
        view.getMainFrame().setTitle("Client module v0.1");
        view.setConnectButton().setText("Connect");

        //set the label.
        view.getMainWindow().getConnectionStatusLabel().setForeground(Color.BLACK);
        view.getMainWindow().getConnectionStatusLabel().setText("not connected");
    }

    public synchronized void addStringToChat(String line) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        view.getChatTextArea().append(simpleDateFormat.format(new Date()) + " :" + line + "\r\n");
        //Focus on last line:
        int len = view.getChatTextArea().getDocument().getLength();
        view.getChatTextArea().setCaretPosition(len);
        //TODO write log entry to file based on date.
        view.refresh();
    }
}
