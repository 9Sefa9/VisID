package externalS;

import com.sun.istack.internal.logging.Logger;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;

public class Transmission implements Runnable{
   private ServerSocket server;
   private Socket client;
   private Logger logger = Logger.getLogger(this.getClass());
    @Override
    public void run() {
        while(true){
            try {
                client = server.accept();
                logger.log(dLevel.INFO,""+client.getInetAddress()+" :: "+client.getLocalAddress()+" :: "+client.getPort());
                new Thread(new InnerClassThread()).start();
            }catch (IOException s){
                s.printStackTrace();
            }
        }
    }

    private class InnerClassThread implements Runnable {
        @Override
        public void run() {

        }
    }
}
