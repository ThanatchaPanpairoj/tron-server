import java.net.*;
import java.io.*;

public class TronMultiServer {
    public static void main(String[] args) throws IOException {
        int portNumber = 4401;
        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) { 
            TronProtocol tp = new TronProtocol();
            
            while (listening) {
                new TronMultiServerThread(serverSocket.accept(), tp).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }
}