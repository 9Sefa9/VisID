package model;

import controllers.*;
import external.CheckConnection;
import external.ExceptionLogger;
import external.Text;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Model {
    //aussage darüber ob eine verbindung überhaupt aufgebaut werden kann in 10 sec. takt
    public boolean canConnectToServer;

    //Funktionalität für das "Besucher eintragen" Button im Main Menu
    public void visitForm(ViewController viewController){
        try {
            //Notification Text aktuaisiern
            viewController.notificationText.setText(Text.notificationTextFormular);

            //sorgt dafür, dass daten erhalten bleiben bei fxml scene wechsel
            if(viewController.formParent == null)
                viewController.formParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Form.fxml"));

            viewController.contentPane.getChildren().setAll(viewController.formParent);

        }catch(IOException i){
            i.printStackTrace();
            ExceptionLogger.appendToFile(i);
        }
    }
    //Funktionalität für das "Formular zurücksetzen" Button im Main Menu
    public void visitFormReset(ViewController viewController){
        try {


            if(viewController.formParent != null) {
                viewController.formParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Form.fxml"));
                visitForm(viewController);

                //Notification Text am Ende aktualisieren
                viewController.notificationText.setText(Text.notificationTextResetFormular);
            }



        }catch(IOException i){
            i.printStackTrace();
            ExceptionLogger.appendToFile(i);
        }
    }
    //Funktionalität für das "Formular Senden" Button im Main Menu
    public void sendForm(ViewController viewController,SendController sendController,FormController formController){
        try {

            //Notification Text aktuaisiern
            viewController.notificationText.setText(Text.notificationTextSendFormular);

            //contentpane aktualisieren
            if (viewController.sendParent == null)
                viewController.sendParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Send.fxml"));

            viewController.contentPane.getChildren().setAll(viewController.sendParent);

            //überprüfen ob Formular wenigstens etwas aufgefüllt wurde vor dem eigentlichen connection test
            if(formIsFilled(viewController,formController)){
                sendController.filledText.setStyle("-fx-text-fill: green");
                sendController.filledText.setText(Text.filledOk);

            }else{
                sendController.filledText.setStyle("-fx-text-fill: red");
                sendController.filledText.setText(Text.filledNotOk);
            }

            connectionTest(viewController,sendController);

        }catch(IOException i){
            i.printStackTrace();
            ExceptionLogger.appendToFile(i);
        }
    }

    //Diese Methode testet in 10 sekunden abschnitten über die Verfügbarkeit des Servers.
    public synchronized void connectionTest(ViewController viewController,SendController sendController) {

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
                        canConnectToServer = solution.get();

                        Platform.runLater(() -> {
                        if (canConnectToServer) {
                                sendController.connectedText.setStyle("-fx-text-fill: green");
                                sendController.connectedText.setText(Text.connectedTOHostOk);
                        } else {
                                sendController.connectedText.setStyle("-fx-text-fill: red");
                                sendController.connectedText.setText(Text.connectedToHostNotOk);
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
    //Funktionalität für das "Auf Updates überprüfen" Button im Main
    public void updateProgram(ViewController viewController){
        try {
            //Notification Text aktuaisiern
            viewController.notificationText.setText(Text.notificationTextUpdate);

            if(viewController.updateParent == null)
                viewController.updateParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Update.fxml"));

            viewController.contentPane.getChildren().setAll(viewController.updateParent);
        }catch(IOException i){
            i.printStackTrace();
            ExceptionLogger.appendToFile(i);
        }
    }
    //Funktionalität für das "Historie" Button im Main
    public void visitFormRecents(ViewController viewController){
        try {
            viewController.notificationText.setText(Text.notificationTextRecent);

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
    public ObservableList getCompletedForm(FormController formController){
        try {
            formController.formList.clear();
            formController.formList.addAll(formController.name.getText(), formController.mobil.getText(), formController.email.getText(), formController.firma.getText(), formController.vorgesetzter.getText(),
                    formController.strasse.getText(), formController.plzOrt.getText(), formController.notwendigeArbeitsbereiche.getText(),
                    formController.vonDatum.getValue(), formController.bisDatum.getValue(), formController.kreuz0.isSelected(), formController.kreuz1.isSelected(), formController.kreuz2.isSelected(), formController.kreuz3.isSelected(),
                    formController.kreuz00.isSelected(), formController.kreuz01.isSelected(), formController.kreuz02.isSelected(), formController.kreuz10.isSelected(), formController.kreuz11.isSelected(),
                    formController.kreuz12.isSelected(), formController.kreuz20.isSelected(), formController.kreuz21.isSelected(), formController.kreuz22.isSelected());
        }catch (Exception e){
            e.printStackTrace();
        }
        return formController.formList;
    }
    public void clearCompletedForm(ViewController viewController) {
        try {
            if (viewController.formParent != null)
                viewController.formParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Form.fxml"));

        }catch(IOException i){
            i.printStackTrace();
        }
    }
    public void addFormToRecent(TableView recentTableView, ObservableList formList){
           if(formList!=null)
           // recentTableView.setItems(formList);
           for(int i = 0 ; i<formList.size();i++)
           recentTableView.getItems().add(formList.get(i));
    }

}
