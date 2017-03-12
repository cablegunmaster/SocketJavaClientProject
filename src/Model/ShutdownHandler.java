package Model;

/**
 * Created by jasper wil.lankhorst on 11-3-2017.
 */
// a class that extends thread that is to be called when program is exiting
public class ShutdownHandler extends Thread {

    Model model;
    public ShutdownHandler(Model model) {
        this.model = model;
    }

    public void run() {
        if(model != null && model.getPrintWriter() != null) {
            model.getPrintWriter().println("/disconnect\n");
            model.getPrintWriter().flush();
            System.out.println("Disconnected Succesfully.");
        }
    }
}

