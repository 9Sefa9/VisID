package external;

import com.sun.istack.internal.logging.Logger;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.logging.Level;

public class Transmission implements Supplier<Boolean> {
    private Socket client;
    private Form form;
    private Logger logger = Logger.getLogger(this.getClass());

    public Transmission(Form form){
        this.form = form;
    }

    private boolean isFormSended() {
        ObjectOutputStream oos=null;
        try{
            String ip = Inet4Address.getByName(Text.IpAddressSend).getCanonicalHostName();
            InetSocketAddress isa = new InetSocketAddress(ip,Text.portSend);

            client = new Socket();
            client.connect(isa);

            //Datenübertragungfor
            oos = new ObjectOutputStream(this.client.getOutputStream());
            oos.writeObject(this.form);
            oos.flush();

            return true;
        }catch (SocketException s){
            logger.log(Level.FINE,"SocketException isFormSended() :: "+this.getClass());

        }catch (IOException uhe){
            logger.log(Level.FINE,"IOException isFormSended() :: "+this.getClass());
        }
        return false;
    }

    @Override
    public Boolean get() {
        return isFormSended();
    }
}
