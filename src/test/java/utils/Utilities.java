package utils;

import java.io.IOException;
import java.net.ServerSocket;

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
}
