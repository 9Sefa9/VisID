package model;

import controllers.*;
import external.CheckConnection;
import external.ExceptionLogger;
import external.Form;
import external.Text;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.cell.PropertyValueFactory;

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
    public void addFormToRecent(RecentsController recentsController, Form form){
           //TODO!!! sowohl inhalt als auch parameter!
        ObservableList<Form> formData = FXCollections.observableArrayList(form);

        recentsController.nameColumn.setCellValueFactory(new PropertyValueFactory<Form,String>("name"));
        recentsController.mobilColumn.setCellValueFactory(new PropertyValueFactory<Form,String>("mobil"));
        recentsController.emailColumn.setCellValueFactory(new PropertyValueFactory<Form,String>("email"));
        recentsController.firmaColumn.setCellValueFactory(new PropertyValueFactory<Form,String>("firma"));
        recentsController.vorgesetzterColumn.setCellValueFactory(new PropertyValueFactory<Form,String>("vorgesetzter"));
        recentsController.strasseColumn.setCellValueFactory(new PropertyValueFactory<Form,String>("strasse"));
        recentsController.plzOrtColumn.setCellValueFactory(new PropertyValueFactory<Form,String>("plzOrt"));
        recentsController.notwendigeArbeitsbereicheColumn.setCellValueFactory(new PropertyValueFactory<Form,String>("notwendigeArbeitsbereiche"));
        recentsController.vonColumn.setCellValueFactory(new PropertyValueFactory<Form,String>("vonDatum"));
        recentsController.bisColumn.setCellValueFactory(new PropertyValueFactory<Form,String>("bisDatum"));
        recentsController.kreuz0Column.setCellValueFactory(new PropertyValueFactory<Form,String>("kreuz0"));
        recentsController.kreuz1Column.setCellValueFactory(new PropertyValueFactory<Form,String>("kreuz1"));
        recentsController.kreuz2Column.setCellValueFactory(new PropertyValueFactory<Form,String>("kreuz2"));
        recentsController.kreuz3Column.setCellValueFactory(new PropertyValueFactory<Form,String>("kreuz3"));
        recentsController.kreuz00Column.setCellValueFactory(new PropertyValueFactory<Form,String>("kreuz00"));
        recentsController.kreuz01Column.setCellValueFactory(new PropertyValueFactory<Form,String>("kreuz01"));
        recentsController.kreuz02Column.setCellValueFactory(new PropertyValueFactory<Form,String>("kreuz02"));
        recentsController.kreuz10Column.setCellValueFactory(new PropertyValueFactory<Form,String>("kreuz10"));
        recentsController.kreuz11Column.setCellValueFactory(new PropertyValueFactory<Form,String>("kreuz11"));
        recentsController.kreuz12Column.setCellValueFactory(new PropertyValueFactory<Form,String>("kreuz12"));
        recentsController.kreuz20Column.setCellValueFactory(new PropertyValueFactory<Form,String>("kreuz20"));
        recentsController.kreuz21Column.setCellValueFactory(new PropertyValueFactory<Form,String>("kreuz21"));
        recentsController.kreuz22Column.setCellValueFactory(new PropertyValueFactory<Form,String>("kreuz22"));

        recentsController.recentTableView.setItems(formData);
    }
    //diese drei Methoden lauschen auf das Formular und setzen es auf "FormController" und
    public void choiceBoxListeners(FormController formController, Form form){

        formController.kreuz0.selectedProperty().addListener((ob,old,ne) -> {
            formController.kreuz0.selectedProperty().setValue(ne);
            form.setKreuz0(ne.toString());

        });
        formController.kreuz1.selectedProperty().addListener((ob,old,ne) -> {
            formController.kreuz1.selectedProperty().setValue(ne);
            form.setKreuz1(ne.toString());
        });
        formController.kreuz2.selectedProperty().addListener((ob,old,ne) -> {
            formController.kreuz2.selectedProperty().setValue(ne);
            form.setKreuz2(ne.toString());
        });
        formController.kreuz3.selectedProperty().addListener((ob,old,ne) -> {
            formController.kreuz3.selectedProperty().setValue(ne);
            form.setKreuz3(ne.toString());
        });
        formController.kreuz00.selectedProperty().addListener((ob,old,ne) -> {
            formController.kreuz00.selectedProperty().setValue(ne);
            form.setKreuz00(ne.toString());
        });
        formController.kreuz01.selectedProperty().addListener((ob,old,ne) -> {
            formController.kreuz01.selectedProperty().setValue(ne);
            form.setKreuz01(ne.toString());
        });
        formController.kreuz02.selectedProperty().addListener((ob,old,ne) -> {
            formController.kreuz02.selectedProperty().setValue(ne);
            form.setKreuz02(ne.toString());
        });
        formController.kreuz10.selectedProperty().addListener((ob,old,ne) -> {
            formController.kreuz10.selectedProperty().setValue(ne);
            form.setKreuz10(ne.toString());
        });
        formController.kreuz11.selectedProperty().addListener((ob,old,ne) -> {
            formController.kreuz11.selectedProperty().setValue(ne);
            form.setKreuz11(ne.toString());
        });
        formController.kreuz12.selectedProperty().addListener((ob,old,ne) -> {
            formController.kreuz12.selectedProperty().setValue(ne);
            form.setKreuz12(ne.toString());
        });
        formController.kreuz20.selectedProperty().addListener((ob,old,ne) -> {
            formController.kreuz20.selectedProperty().setValue(ne);
            form.setKreuz20(ne.toString());
        });
        formController.kreuz21.selectedProperty().addListener((ob,old,ne) -> {
            formController.kreuz21.selectedProperty().setValue(ne);
            form.setKreuz21(ne.toString());
        });
        formController.kreuz22.selectedProperty().addListener((ob,old,ne) -> {
            formController.kreuz22.selectedProperty().setValue(ne);
            form.setKreuz22(ne.toString());
        });
    }
    public void datePickerListeners(FormController formController,Form form){
        formController.vonDatum.valueProperty().addListener((ob,old,ne) -> {
            formController.vonDatum.valueProperty().setValue(ne);
            form.setVonDatum(ne.toString());
        });
        formController.bisDatum.valueProperty().addListener((ob,old,ne) -> {
            formController.bisDatum.valueProperty().setValue(ne);
            form.setBisDatum(ne.toString());
        });
    }
    public void labelListeners(FormController formController,Form form){
        formController.name.textProperty().addListener((obs,old,ne) -> {
            formController.name.setText(ne);
            form.setName(ne.toString());
        });

        formController.mobil.textProperty().addListener((obs,old,ne) -> {
            formController.mobil.setText(ne);
            form.setMobil(ne.toString());
        });
        formController.email.textProperty().addListener((obs,old,ne) -> {
            formController.email.setText(ne);
            form.setEmail(ne.toString());
        });
        formController.firma.textProperty().addListener((obs,old,ne) -> {
            formController.firma.setText(ne);
            form.setFirma(ne.toString());
        });
        formController.vorgesetzter.textProperty().addListener((obs,old,ne) -> {
            formController.vorgesetzter.setText(ne);
            form.setVorgesetzter(ne.toString());
        });
        formController.strasse.textProperty().addListener((obs,old,ne) -> {
            formController.strasse.setText(ne);
            form.setStrasse(ne.toString());
        });
        formController.plzOrt.textProperty().addListener((obs,old,ne) -> {
            formController.plzOrt.setText(ne);
            form.setPlzOrt(ne.toString());
        });
        formController.notwendigeArbeitsbereiche.textProperty().addListener((obs,old,ne) -> {
            formController.notwendigeArbeitsbereiche.setText(ne);
            form.setNotwendigeArbeitsbereiche(ne.toString());
        });

    }

}
