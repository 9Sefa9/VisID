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
        ObjectOutputStream oos;
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
            s.printStackTrace();
        }catch (IOException uhe){
            uhe.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean get() {
        return isFormSended();
    }
}
