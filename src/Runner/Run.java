package Runner;

import Controller.*;
import Model.*;
import View.*;
import utils.Logger;

import java.lang.management.ManagementFactory;

/**
 * Created by Jasper Lankhorst on 17-11-2016.
 * Class to run the application.
 * Application can send random bullshit to the server, only the server needs to be handling error correction.
 */
public class Run {

    public static void main(String[] args) {
        System.out.println("Starting up Client PID: " + ManagementFactory.getRuntimeMXBean().getName());

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        Run.checkPortNumber(view, model, args);

        // register Message as shutdown hook
        Runtime.getRuntime().addShutdownHook(new ShutdownHandler(model));

        System.out.println("Client is started.");
    }

    private static void checkPortNumber(View view, Model model, String[] args) {
        int portNumber = 80;
        if (args.length > 0) {
            try {
                portNumber = Integer.parseInt(args[0]);
            } catch (Exception parseException) {
                Logger.get().log("No valid portnumber found: returning to basic port 80");
                portNumber = 80;
            }
        }

        //Check if a port number comes from the view.
        if (!view.getPortNumber().equals("")) {
            model.setPortnumber(view.getPortNumber()); //initialize portnumber to model.
        } else {
            model.setPortnumber(portNumber); //initialize portnumber to model.
        }
    }
}