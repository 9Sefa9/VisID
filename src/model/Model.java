package model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class Model {
    public Model(){

    }
    //Funktionalität für das "Besucher eintragen" Button
    public void visitFormAction(Parent formFXML, AnchorPane contentPane){
        try {
            //sorgt dafür, dass daten erhalten bleiben bei fxml scene wechsel
            if(formFXML== null)
                formFXML= FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Form.fxml"));

            contentPane.getChildren().setAll(formFXML);

        }catch(IOException i){
            i.printStackTrace();
            appendToFile(i);
        }
    }
    public void visitFormResetAction(Parent formFXML, AnchorPane contentPane){
        try {
            if(formFXML != null) {
                formFXML = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Form.fxml"));
                visitFormAction(formFXML, contentPane);
            }

        }catch(IOException i){
            i.printStackTrace();
            appendToFile(i);
        }
    }
    public void sendFormAction(Parent sendFXML,AnchorPane contentPane){
        try {
            if (sendFXML == null)
                sendFXML = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Send.fxml"));
            contentPane.getChildren().setAll(sendFXML);
        }catch(IOException i){
            i.printStackTrace();
            appendToFile(i);
        }
    }

    //speichert exceptions in ein File. Nützlich für den Entwickler
    public synchronized void appendToFile(Exception e) {
        try {
            FileWriter fstream = new FileWriter("Exceptions.txt", true);
            BufferedWriter out = new BufferedWriter(fstream);
            PrintWriter pWriter = new PrintWriter(out, true);
            pWriter.write("\n occured:"+LocalDate.now() +" printStackTrace ::");
            e.printStackTrace(pWriter);

        }
        catch (Exception ie) {
            throw new RuntimeException("Could not write Exception to file", ie);
        }
    }
}
