package Model;

import Controller.MainController;
import View.View;
import utils.Logger;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jasper wil.lankhorst on 8-2-2017.
 */
public class ListenThread implements Runnable {

    Model model;
    View view;
    MainController controller;
    Socket clientSocket;

    public ListenThread(Socket clientSocket, MainController controller) {
        this.controller = controller;
        this.model = controller.getModel();
        this.view = controller.getView();
        this.clientSocket = clientSocket;
    }

    public void run() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Logger.get().log("Listen send Thread started succesfully ");

            while (model.isConnected()) {
                String inputString;
                //Listen to the bufferedReader.
                while ((inputString = bufferedReader.readLine()) != null && model.isConnected()) {

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                    if (inputString.startsWith("/userlist")) {
                        setUsers(inputString);
                    }

                    controller.addStringToChat(inputString);
                    if (inputString.equals("disconnected")) {
                        Logger.get().log("Logger received disconnected...");
                        controller.disconnect();
                        break;
                    }
                }
            }

        } catch (SocketException e) {
            Logger.get().log("Disconnected from Server");
            controller.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
            Logger.get().log("Error happened:+ ");
            controller.disconnect();
        }

        Logger.get().log("Listenthread disconnected");
    }

    public void setUsers(String users) {
        JTextArea userlist = view.getMainWindow().getUserListTextArea();
        userlist.setText("");

        if (users != null && !users.isEmpty()) {

            String[] usernames = users.split(" ");
            ArrayList<String> namesList = new ArrayList<>(Arrays.asList(usernames));
            if (namesList.contains("/userlist")) {
                namesList.remove("/userlist");
            }

            if (namesList.size() > 0) {
                for (int i = 0; i < namesList.size(); i++) {
                    userlist.append(namesList.get(i) + "\n");
                }
            }
        }
    }


}
