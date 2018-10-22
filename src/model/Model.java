package model;

import controllers.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class Model {

    //Funktionalität für das "Besucher eintragen" Button
    public void visitForm(ViewController viewController){
        try {
            //Notification Text aktuaisiern
            viewController.notificationText.setText("Formular erstellen");

            //sorgt dafür, dass daten erhalten bleiben bei fxml scene wechsel
            if(viewController.formFXML== null)
                viewController.formFXML= FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Form.fxml"));

            viewController.contentPane.getChildren().setAll(viewController.formFXML);

        }catch(IOException i){
            i.printStackTrace();
            appendToFile(i);
        }
    }
    //Funktionalität für das "Formular zurücksetzen" Button
    public void visitFormReset(ViewController viewController){
        try {


            if(viewController.formFXML != null) {
                viewController.formFXML = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Form.fxml"));
                visitForm(viewController);

                //Notification Text am Ende aktualisieren
                viewController.notificationText.setText("Formular wurde zurückgesetzt!");
            }



        }catch(IOException i){
            i.printStackTrace();
            appendToFile(i);
        }
    }
    public void sendForm(ViewController viewController,SendController sendController,FormController formController){
        try {

            //Notification Text aktuaisiern
            viewController.notificationText.setText("Formular senden");

            if (viewController.sendFXML == null)
                viewController.sendFXML = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Send.fxml"));

            viewController.contentPane.getChildren().setAll(viewController.sendFXML);

            if(formIsFilled(viewController,formController)){
                sendController.isFilled.setText("OK");
            }else{
                sendController.isFilled.setText("NOT OK");
            }

        }catch(IOException i){
            i.printStackTrace();
            appendToFile(i);
        }
    }
    public void updateProgram(ViewController viewController){
        try {
            //Notification Text aktuaisiern
            viewController.notificationText.setText("Updates");

            if(viewController.updateFXML == null)
                viewController.updateFXML = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Update.fxml"));

            viewController.contentPane.getChildren().setAll(viewController.updateFXML);
        }catch(IOException i){
            i.printStackTrace();
            appendToFile(i);
        }
    }
    public void visitFormRecents(ViewController viewController){
        try {
            viewController.notificationText.setText("Verlauf");

            if (viewController.recentsFXML == null)
                viewController.recentsFXML = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Recents.fxml"));

            viewController.contentPane.getChildren().setAll(viewController.recentsFXML);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public boolean formIsFilled(ViewController viewController,FormController formController){
       // formular gilt as gefüllt, wenn der Name und oder Mobil eingetragen ist.
        if(viewController.formFXML != null) {

            if ((!formController.name.getText().trim().isEmpty()) && (!formController.mobil.getText().trim().isEmpty())) {
                return true;
            } else {
               return false;
           }
        }
        return false;
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
