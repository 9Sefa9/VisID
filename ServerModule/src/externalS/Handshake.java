package externalS;

import java.io.IOException;
import java.net.*;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Handshake implements Runnable {

    @Override
    public void run() {
        ServerSocket server;
        Socket client;
        try {
            Logger log = Logger.getLogger(this.getClass().getName());
            log.log(Level.INFO,"Handshake started!");

            server = new ServerSocket(22);
            while(true) {
                client = server.accept();
                //Mache gar nichts. Da der Client sowieso nur feststellen muss ob es sich "überhaupt" zum Server verbinden kann.
            }

        }catch (SocketException e){
            System.err.println("SocketException checkConnection() :: "+this.getClass());
        }catch (IOException i){
            System.err.println("IOException checkConnection() :: "+this.getClass());
            i.printStackTrace();
        }

    }
}
