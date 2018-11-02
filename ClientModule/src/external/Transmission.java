package external;

import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.function.Supplier;

public class Transmission implements Supplier<Boolean> {
    private Socket client;
    private ObservableList formList;

    public Transmission(ObservableList formList){
        this.formList=formList;
    }

    private boolean isFormSended() {
        ObjectOutputStream oos=null;
        try{
            String ip = Inet4Address.getByName(Text.IpAddressSend).getCanonicalHostName();
            InetSocketAddress isa = new InetSocketAddress(ip,Text.portSend);

            client = new Socket();
            client.connect(isa);

            //Datenübertragung
            oos = new ObjectOutputStream(this.client.getOutputStream());
            oos.writeObject(this.formList);
            oos.close();
            return true;
        }catch (SocketException s){
            System.err.println("SocketException isFormSended() :: "+this.getClass());
        }catch (IOException uhe){
            System.err.println("IOException isFormSended() :: "+this.getClass());
        }finally{
            try {
                if (oos != null)
                    oos.close();
            }catch (IOException i){
                i.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Boolean get() {
        return isFormSended();
    }
}
