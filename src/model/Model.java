package model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import viewController.ViewController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class Model {
    private ViewController viewController;

    //übertrage ViewController objekt zu model um manipulationen durchzuführen
    public void setViewController(ViewController viewController){
        this.viewController = viewController;
    }

    //Funktionalität für das "Besucher eintragen" Button
    public void visitFormAction(){
        try {
            //sorgt dafür, dass daten erhalten bleiben bei fxml scene wechsel
            if(this.viewController.formFXML== null)
                this.viewController.formFXML= FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Form.fxml"));

            this.viewController.contentPane.getChildren().setAll(this.viewController.formFXML);

        }catch(IOException i){
            i.printStackTrace();
            appendToFile(i);
        }
    }
    //Funktionalität für das "Formular zurücksetzen" Button
    public void visitFormResetAction(){
        try {
            if(this.viewController.formFXML != null) {
                this.viewController.formFXML = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Form.fxml"));
                visitFormAction();
            }

        }catch(IOException i){
            i.printStackTrace();
            appendToFile(i);
        }
    }
    public void sendFormAction(){
        try {
            if (this.viewController.sendFXML == null)
                this.viewController.sendFXML = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Send.fxml"));
            this.viewController.contentPane.getChildren().setAll(this.viewController.sendFXML);
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
    public void updateProgramAction(){
        try {
            if (this.viewController.updateFXML == null)
                this.viewController.updateFXML = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Update.fxml"));

            this.viewController.contentPane.getChildren().setAll(this.viewController.updateFXML);
        }catch(IOException i){
            i.printStackTrace();
            appendToFile(i);
        }
    }
}
