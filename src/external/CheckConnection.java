package external;

import java.io.IOException;
import java.net.*;
import java.util.function.Supplier;

public class CheckConnection implements Supplier<Boolean> {


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
            System.err.println("SocketException checkConnection() :: "+this.getClass());
        }catch (IOException i){
            System.err.println("IOException checkConnection() :: "+this.getClass());
            i.printStackTrace();
        }
        return false;
    }
}
