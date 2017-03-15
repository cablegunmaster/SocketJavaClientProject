package Model;

import Controller.MainController;
import utils.Logger;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

/**
 * Created by jasper wil.lankhorst on 18-11-2016.
 */

//All buffers should be in the model.
public class Model {

    private int portNumber = 80; //default portnumber to connect.
    private Socket socket = null; //socket to connect.
    private PrintWriter printWriter = null; //printwriter to write to.
    private BufferedReader bufferedReader = null; //reader to get the information from.
    private Boolean isConnected = false;

    /**
     * Connects a socket to a ServerSocket.
     */
    public Socket connect() {
        
        try {
            socket = new Socket("localhost", portNumber);
            setPrintWriter(new PrintWriter(socket.getOutputStream(), true));
            isConnected = true;
            //Refactor end.

        } catch (ConnectException ex) {
            Logger.get().log("Server not found / Connection refused with server");
            isConnected = false;
        } catch (IOException e) {
            e.printStackTrace();
            Logger.get().log("Error happened:+ ");
            if (!socket.isClosed()) {
                Logger.get().log("Socket not closed");
            }
            isConnected = false;
        }
        return socket;
    }

    public Thread setListenThread(Socket clientSocket, MainController controller) {
        Thread t = new Thread(new ListenThread(clientSocket, controller));
        t.start();
        return t;
    }

    /**
     * Disconnect the socket from the server and closes all the connections.
     */
    public void disconnect() {

        isConnected = false;
        try {
            if (printWriter != null && socket.isConnected()) {
                printWriter.flush();
                printWriter.close();
            }

            if (bufferedReader != null && socket.isConnected()) {
                bufferedReader.close();
            }
            if (socket != null) {
                socket.close();
            }

        } catch (IOException e) {
            Logger.get().log(e.toString());
            e.printStackTrace();
        }
    }

    /**
     * Sets the portnumber for the client to read out.
     *
     * @param portNumber gives the portnumber to connect to.
     */
    public void setPortnumber(int portNumber) {
        this.portNumber = portNumber;
    }

    /**
     * Returns the portnumber for the client to connect to.
     *
     * @return portNumber integer.
     */
    public int getPortnumber() {
        return portNumber;
    }
    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }
    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }
    public synchronized PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }
    public boolean isConnected() {
        return isConnected;
    }
}
