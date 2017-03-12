package utils;

import java.util.Date;

/**
 * Created by jasper wil.lankhorst on 8-2-2017.
 */
public class Logger {

    private static Logger _instance = new Logger();
    private Boolean DEBUGMODE = true;

    public static Logger get(){
        return _instance;
    }

    private Logger(){}

    public void log(String logString){
        if(DEBUGMODE) {
            System.err.println(new Date().toString()+" "+ logString);
        }else{
            //TODO SEND TO A FILE?
        }
    }
}
