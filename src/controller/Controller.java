package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;

public class Controller {

    private Parent formFXML;
    private Parent sendFXML;

    @FXML public AnchorPane contentPane;

    @FXML
    public void initialize(){}

    //@Button -> Besucher eintragen
    @FXML
    public void visitFormAction(){
        try {
            //sorgt dafür, dass daten erhalten bleiben bei fxml scene wechsel
            if(formFXML== null)
                this.formFXML= FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Form.fxml"));

            this.contentPane.getChildren().setAll(formFXML);

        }catch(IOException i){
            i.printStackTrace();
            appendToFile(i);
        }

    }

    //@Button -> Formula zurücksetzen
    @FXML
    public void visitFormResetAction(){
        try {
            this.formFXML = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Form.fxml"));
            visitFormAction();

        }catch(IOException i){
            i.printStackTrace();
            appendToFile(i);
        }
    }

    @FXML
    public void sendFormAction(){
        try {
            if (sendFXML == null)
                this.sendFXML = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Send.fxml"));
                this.contentPane.getChildren().setAll(sendFXML);
        }catch(IOException i){
            i.printStackTrace();
            appendToFile(i);
        }
        }

    //speichert exceptions in ein File. Nützlich für den Entwickler
    public static void appendToFile(Exception e) {
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
