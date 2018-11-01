package external;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;

public class ExceptionLogger {

    //speichert exceptions in ein File. Nützlich für den Entwickler
    public static synchronized void appendToFile(Exception e) {
        try {
            FileWriter fstream = new FileWriter("Exceptions.txt", true);
            BufferedWriter out = new BufferedWriter(fstream);
            PrintWriter pWriter = new PrintWriter(out, true);
            pWriter.write("\n occured:"+ LocalDate.now() +" printStackTrace ::");
            e.printStackTrace(pWriter);

        }
        catch (Exception ie) {
            throw new RuntimeException("Could not write Exception to file", ie);
        }
    }
}
