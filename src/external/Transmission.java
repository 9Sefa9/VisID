package external;

import java.io.IOException;
import java.net.*;
import java.util.function.Supplier;

public class Transmission implements Supplier<Boolean> {
    private Socket client;
    public boolean isFormSended() {

        try{
            String ip = Inet4Address.getByName("localhost").getCanonicalHostName();
            InetSocketAddress isa = new InetSocketAddress(ip,22);

            client = new Socket();
            client.connect(isa);
          return false;
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
