package externalS;

import com.sun.istack.internal.logging.Logger;
import controllersS.ViewController;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;

public class Transmission implements Runnable{
    private ViewController viewController;
    private ServerSocket server;
    private Socket client;
    private Logger logger = Logger.getLogger(this.getClass());

    public Transmission(ViewController viewController){
       this.viewController = viewController;
    }

    @Override
    public void run() {
        try {
         server = new ServerSocket(Text.portReceiveForm);
            while(true){
                   client = server.accept();
                   logger.log(Level.FINE,":: "+client.getLocalSocketAddress()+" :: "+client.getInetAddress().getHostAddress()+" :: "+client.getPort());
                   new Thread(new InnerClassThread(this.viewController,this.client)).start();
             }
        }catch (IOException s){
            s.printStackTrace();
        }
    }

    private class InnerClassThread implements Runnable {
        private Socket client;
        private ViewController viewController;
        public InnerClassThread(ViewController viewController,Socket client){
            this.client = client;
            this.viewController = viewController;
        }
        @Override
        public void run() {
            ObjectInputStream ois;
            try {
                ois = new ObjectInputStream(this.client.getInputStream());
               ArrayList<Object> transmittedList=  (ArrayList<Object>)ois.readObject();
                logger.log(Level.FINE,":: "+client.getLocalSocketAddress()+" :: transmitted a list!");
               this.viewController.model.addToReceived(this.viewController.receivedController.receivedTableView,transmittedList);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
