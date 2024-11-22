package utils;

import java.io.IOException;
import java.net.ServerSocket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utilities {
    public boolean checkIfAppiumServerIsRunning(int port){
        boolean isAppiumServerRunning = false;
        ServerSocket socket;

        try{
            socket = new ServerSocket(port);
            socket.close();
        }
        catch (IOException ex){
            isAppiumServerRunning = true;
            System.out.println("Appium server running = true.");
        }
        finally {
            socket = null;
        }
        return isAppiumServerRunning;
    }

    public Logger log(){
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
    }
}
