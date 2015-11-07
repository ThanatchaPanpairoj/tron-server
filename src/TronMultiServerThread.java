import java.net.*;
import java.io.*;

public class TronMultiServerThread extends Thread {
    private Socket socket = null;
    private TronProtocol tp;
    private User u;

    public TronMultiServerThread(Socket socket, TronProtocol tp) {
        super("TronMultiServerThread");
        this.socket = socket;
        this.tp = tp;
        this.u = new User(0, 0, 0, (int)(Math.random() * 10));
        tp.addUser(u);
    }

    public void run() {
        try (
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    socket.getInputStream()));
        ) {
            String inputLine, outputLine;
            outputLine = tp.processInput(null, u);
            out.println(outputLine);
            
            while((inputLine = in.readLine()) != null) {
                outputLine = tp.processInput(inputLine, u);
                out.println(outputLine);
            }
            socket.close();
        } catch (Exception e) {
            //e.printStackTrace();
            tp.removeUser(u);
        }
    }
}