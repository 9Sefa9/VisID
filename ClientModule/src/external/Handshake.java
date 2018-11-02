package external;

import java.io.IOException;
import java.net.*;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Handshake implements Supplier<Boolean> {

    private Logger log = Logger.getLogger(this.getClass().getName());
    @Override
    public Boolean get() {
        return checkConnection();
    }

    private Boolean checkConnection() {
        Socket socket;
        try {
            String ip = Inet4Address.getByName("localhost").getCanonicalHostName();
            InetSocketAddress isa = new InetSocketAddress(ip,22);

            Socket client = new Socket();
            client.connect(isa);
            return true;
        }catch (SocketException e){
            log.log(Level.INFO,"SocketException checkConnection()");
            e.printStackTrace();
        }catch (IOException i){
            log.log(Level.INFO,"IOException checkConnection()");
            i.printStackTrace();
        }
        return false;
    }
}
