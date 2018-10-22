package model;

import controllers.*;
import external.CheckConnection;
import external.ExceptionLogger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Model {
    private boolean isConnectedToServer;
    //Funktionalität für das "Besucher eintragen" Button
    public void visitForm(ViewController viewController){
        try {
            //Notification Text aktuaisiern
            viewController.notificationText.setText("Formular erstellen");

            //sorgt dafür, dass daten erhalten bleiben bei fxml scene wechsel
            if(viewController.formParent == null)
                viewController.formParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Form.fxml"));

            viewController.contentPane.getChildren().setAll(viewController.formParent);

        }catch(IOException i){
            i.printStackTrace();
            ExceptionLogger.appendToFile(i);
        }
    }
    //Funktionalität für das "Formular zurücksetzen" Button
    public void visitFormReset(ViewController viewController){
        try {


            if(viewController.formParent != null) {
                viewController.formParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Form.fxml"));
                visitForm(viewController);

                //Notification Text am Ende aktualisieren
                viewController.notificationText.setText("Formular wurde zurückgesetzt!");
            }



        }catch(IOException i){
            i.printStackTrace();
            ExceptionLogger.appendToFile(i);
        }
    }
    public void sendForm(ViewController viewController,SendController sendController,FormController formController){
        try {
            //Notification Text aktuaisiern
            viewController.notificationText.setText("Formular senden");

            //contentpane aktualisieren
            if (viewController.sendParent == null)
                viewController.sendParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Send.fxml"));

            viewController.contentPane.getChildren().setAll(viewController.sendParent);

            //überprüfen ob Formular wenigstens etwas aufgefüllt wurde vor dem eigentlichen connection test
            if(formIsFilled(viewController,formController)){
                sendController.filledText.setStyle("-fx-text-fill: green");
                sendController.filledText.setText("OK!");

            }else{
                sendController.filledText.setStyle("-fx-text-fill: red");
                sendController.filledText.setText("NOT OK!");
            }

            connectionTest(viewController,sendController);

        }catch(IOException i){
            i.printStackTrace();
            ExceptionLogger.appendToFile(i);
        }
    }

    //Diese Methode testet in 10 sekunden abschnitten über die Verfügbarkeit des Servers.
    private void connectionTest(ViewController viewController,SendController sendController) {

        new Thread(new Runnable(){
            @Override

            public synchronized void run(){
                CheckConnection cc;
                CompletableFuture<Boolean> solution;

                try
                {
                    while(true) {
                        cc = new CheckConnection();
                        solution = CompletableFuture.supplyAsync(cc);

                        //Ergebnis in Model abspeichern für weitere Verwendungszwecke
                        isConnectedToServer = solution.get();

                        Platform.runLater(() -> {
                        if (isConnectedToServer) {
                                sendController.connectedText.setStyle("-fx-text-fill: green");
                                sendController.connectedText.setText("OK!");
                        } else {
                                sendController.connectedText.setStyle("-fx-text-fill: red");
                                sendController.connectedText.setText("NOT OK!");
                        }
                        });
                        Thread.sleep(10000);
                    }
                } catch(InterruptedException ie) {
                     ie.printStackTrace();
                }
                  catch(ExecutionException ee) {
                        ee.printStackTrace();
                }
            }

        }).start();
    }

    public void updateProgram(ViewController viewController){
        try {
            //Notification Text aktuaisiern
            viewController.notificationText.setText("Updates");

            if(viewController.updateParent == null)
                viewController.updateParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Update.fxml"));

            viewController.contentPane.getChildren().setAll(viewController.updateParent);
        }catch(IOException i){
            i.printStackTrace();
            ExceptionLogger.appendToFile(i);
        }
    }
    public void visitFormRecents(ViewController viewController){
        try {
            viewController.notificationText.setText("Verlauf");

            if (viewController.recentsParent == null)
                viewController.recentsParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Recents.fxml"));

            viewController.contentPane.getChildren().setAll(viewController.recentsParent);
        }catch (IOException e){
            e.printStackTrace();
            ExceptionLogger.appendToFile(e);
        }
    }
    public boolean formIsFilled(ViewController viewController,FormController formController){
       // formular gilt as gefüllt, wenn der Name und oder Mobil eingetragen ist.
        if(viewController.formParent != null) {

            if ((!formController.name.getText().trim().isEmpty()) && (!formController.mobil.getText().trim().isEmpty())) {
                return true;
            } else {
               return false;
           }
        }
        return false;
    }


}
