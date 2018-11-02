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
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Model {
    //aussage darüber ob eine verbindung überhaupt aufgebaut werden kann in Text.connectionTestTryAgain sekunden takt
    public boolean canConnectToServer;

    //Funktionalität für das "Besucher eintragen" Button im MainClient Menu
    public void visitForm(ViewController viewController) {

        //Notification Text aktuaisiern
        viewController.notificationText.setText(Text.notificationTextFormular);

        //das "Formular wurde erfolgreich gesendet! zurück resetten.
        viewController.sendController.sendedText.setText("");
        viewController.contentPane.getChildren().setAll(viewController.formParent);


    }

    //Funktionalität für das "Formular zurücksetzen" Button im MainClient Menu
    public void visitFormReset(ViewController viewController) {
        try {

            //das "Formular wurde erfolgreich gesendet! zurück resetten.
            viewController.sendController.sendedText.setText("");

            resetLabel(viewController.formController);
            resetDatePicker(viewController.formController);
            resetChoiceBox(viewController.formController);

            //Notification Text am Ende aktualisieren
            viewController.notificationText.setText(Text.notificationTextResetFormular);

            viewController.sendController.filledText.setStyle("-fx-text-fill: red");
            viewController.sendController.filledText.setText(Text.filledNotOk);

        } catch (Exception i) {
            i.printStackTrace();
            ExceptionLogger.appendToFile(i);
        }
    }

    //Funktionalität für das "Formular Senden" Button im MainClient Menu
    public void sendForm(ViewController viewController) {
        try {
            //das "Formular wurde erfolgreich gesendet! zurück resetten.
            viewController.sendController.sendedText.setText("");

            //Notification Text aktuaisiern
            viewController.notificationText.setText(Text.notificationTextSendFormular);


            viewController.contentPane.getChildren().setAll(viewController.sendParent);

            //überprüfen ob Formular wenigstens etwas aufgefüllt wurde vor dem eigentlichen connection test
            if (formIsFilled(viewController, viewController.formController)) {
                viewController.sendController.filledText.setStyle("-fx-text-fill: green");
                viewController.sendController.filledText.setText(Text.filledOk);

            } else {
                viewController.sendController.filledText.setStyle("-fx-text-fill: red");
                viewController.sendController.filledText.setText(Text.filledNotOk);
            }

            connectionTest(viewController, viewController.sendController);

        } catch (Exception i) {
            i.printStackTrace();
            ExceptionLogger.appendToFile(i);
        }
    }

    //Diese Methode testet in Text.connectionTestTryAgain sekunden abschnitten über die Verfügbarkeit des Servers.
    public synchronized void connectionTest(ViewController viewController, SendController sendController) {

        new Thread(new Runnable() {
            @Override

            public synchronized void run() {
                CheckConnection cc;
                CompletableFuture<Boolean> solution;

                try {
                    while (true) {
                        cc = new CheckConnection();
                        solution = CompletableFuture.supplyAsync(cc);

                        //Ergebnis in Model abspeichern für weitere Verwendungszwecke
                        canConnectToServer = solution.get();

                        Platform.runLater(() -> {
                            //falls verbindung aufgebaut werden konnte : notifye durch OK oder NOT OK
                            if (canConnectToServer) {
                                sendController.connectedText.setStyle("-fx-text-fill: green");
                                sendController.connectedText.setText(Text.connectedTOHostOk);
                            } else {
                                sendController.connectedText.setStyle("-fx-text-fill: red");
                                sendController.connectedText.setText(Text.connectedToHostNotOk);
                            }
                        });
                        Thread.sleep(Text.connectionTestTryAgain);
                    }
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                } catch (ExecutionException ee) {
                    ee.printStackTrace();
                }
            }

        }).start();
    }

    //Funktionalität für das "Auf Updates überprüfen" Button im MainClient
    //TODO wird zuletzt gemacht.
    public void updateProgram(ViewController viewController) {
        try {
            //das "Formular wurde erfolgreich gesendet! zurück resetten.
            viewController.sendController.sendedText.setText("");

            //Notification Text aktuaisiern
            viewController.notificationText.setText(Text.notificationTextUpdate);

            if (viewController.updateParent == null)
                viewController.updateParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Update.fxml"));

            viewController.contentPane.getChildren().setAll(viewController.updateParent);
        } catch (IOException i) {
            i.printStackTrace();
            ExceptionLogger.appendToFile(i);
        }
    }

    //Funktionalität für das "Historie" Button im MainClient
    public void visitFormRecents(ViewController viewController) {
        try {
            //das "Formular wurde erfolgreich gesendet! zurück resetten.
            viewController.sendController.sendedText.setText("");
            
            viewController.notificationText.setText(Text.notificationTextRecent);

            //if (viewController.recentsParent == null)
            //    viewController.recentsParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Recents.fxml"));

            viewController.contentPane.getChildren().setAll(viewController.recentsParent);
        } catch (Exception e) {
            e.printStackTrace();
            ExceptionLogger.appendToFile(e);
        }
    }
    //gesteuert von SendCOntroller aus. Vor dem eigentlichen senden muss überprüft werden ob Formular gefüllt.
    public boolean formIsFilled(ViewController viewController, FormController formController) {
        // formular gilt as gefüllt, wenn der Name und oder Mobil eingetragen ist.
        if (viewController.formParent != null) {

            return (!formController.name.getText().trim().isEmpty()) && (!formController.mobil.getText().trim().isEmpty());
        }
        return false;
    }
    //wird hauptsächlich für das Transmitten verwendet. Zu finden unter SendController
    public ObservableList getCompletedForm(FormController formController) {
        try {
            formController.formList.clear();
            formController.formList.addAll(formController.name.getText(), formController.mobil.getText(), formController.email.getText(), formController.firma.getText(), formController.vorgesetzter.getText(),
                    formController.strasse.getText(), formController.plzOrt.getText(), formController.notwendigeArbeitsbereiche.getText(),
                    formController.vonDatum.getValue(), formController.bisDatum.getValue(), formController.kreuz0.isSelected(), formController.kreuz1.isSelected(), formController.kreuz2.isSelected(), formController.kreuz3.isSelected(),
                    formController.kreuz00.isSelected(), formController.kreuz01.isSelected(), formController.kreuz02.isSelected(), formController.kreuz10.isSelected(), formController.kreuz11.isSelected(),
                    formController.kreuz12.isSelected(), formController.kreuz20.isSelected(), formController.kreuz21.isSelected(), formController.kreuz22.isSelected());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formController.formList;
    }
    //In dem moment wo was gesendet wurde, setze formular zurück.
    public void clearCompletedForm(FormController formController) {
        resetLabel(formController);
        resetDatePicker(formController);
        resetChoiceBox(formController);
    }
    //Eigentlicher TableView Process. Zu finden in FormController aber aufgerufen wird es in SendController
    public void addFormToRecent(ViewController viewController, RecentsController recentsController) {

        Form form = getNewForm(viewController);
        recentsController.recentTableView.getItems().add(form);

    }
    public void prepareTableView(ViewController viewController,RecentsController recentsController){
        viewController.formController.formListTableView = FXCollections.observableArrayList();

        recentsController.buttonColumn.setCellValueFactory(new PropertyValueFactory<Form, Button>("button"));
        recentsController.nameColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("name"));
        recentsController.mobilColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("mobil"));
        recentsController.emailColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("email"));
        recentsController.firmaColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("firma"));
        recentsController.vorgesetzterColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("vorgesetzter"));
        recentsController.strasseColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("strasse"));
        recentsController.plzOrtColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("plzOrt"));
        recentsController.notwendigeArbeitsbereicheColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("notwendigeArbeitsbereiche"));
        recentsController.vonColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("vonDatum"));
        recentsController.bisColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("bisDatum"));
        recentsController.kreuz0Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz0"));
        recentsController.kreuz1Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz1"));
        recentsController.kreuz2Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz2"));
        recentsController.kreuz3Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz3"));
        recentsController.kreuz00Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz00"));
        recentsController.kreuz01Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz01"));
        recentsController.kreuz02Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz02"));
        recentsController.kreuz10Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz10"));
        recentsController.kreuz11Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz11"));
        recentsController.kreuz12Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz12"));
        recentsController.kreuz20Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz20"));
        recentsController.kreuz21Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz21"));
        recentsController.kreuz22Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz22"));

        recentsController.recentTableView.setItems(viewController.formController.formListTableView);
    }
    //diese drei Reset Methoden reset einfach nur das Formular für weitere verwendugszwecke.
    private void resetLabel(FormController formController) {
        formController.name.setText("");
        formController.mobil.setText("");
        formController.email.setText("");
        formController.firma.setText("");
        formController.vorgesetzter.setText("");
        formController.strasse.setText("");
        formController.plzOrt.setText("");
        formController.notwendigeArbeitsbereiche.setText("");
    }
    private void resetDatePicker(FormController formController) {

        formController.vonDatum.valueProperty().setValue(null);
        formController.bisDatum.valueProperty().setValue(null);

    }
    private void resetChoiceBox(FormController formController) {

        formController.kreuz0.selectedProperty().setValue(null);
        formController.kreuz1.selectedProperty().setValue(null);
        formController.kreuz2.selectedProperty().setValue(null);
        formController.kreuz3.selectedProperty().setValue(null);
        formController.kreuz00.selectedProperty().setValue(null);
        formController.kreuz01.selectedProperty().setValue(null);
        formController.kreuz02.selectedProperty().setValue(null);
        formController.kreuz10.selectedProperty().setValue(null);
        formController.kreuz11.selectedProperty().setValue(null);
        formController.kreuz12.selectedProperty().setValue(null);
        formController.kreuz20.selectedProperty().setValue(null);
        formController.kreuz21.selectedProperty().setValue(null);
        formController.kreuz22.selectedProperty().setValue(null);

    }

    //Brauchen wir für die TableView Property um an die jeweilige Column speichern zu können
    private Form getNewForm(ViewController viewController) {

        Form form = new Form();
        form.getButton().setOnAction(e->{
            //erst wird Formular geleert.
            clearCompletedForm(viewController.formController);

            //anschließend werden die werte gesetzt, damit das Formular neu bearbeitet werden kann.
            viewController.formController.name.setText(form.getName());
            viewController.formController.mobil.setText(form.getMobil());
            viewController.formController.email.setText(form.getEmail());
            viewController.formController.firma.setText(form.getFirma());
            viewController.formController.vorgesetzter.setText(form.getVorgesetzter());
            viewController.formController.strasse.setText(form.getStrasse());
            viewController.formController.plzOrt.setText(form.getPlzOrt());
            viewController.formController.notwendigeArbeitsbereiche.setText(form.getNotwendigeArbeitsbereiche());




            try {
                viewController.formController.vonDatum.valueProperty().set(LocalDate.parse(form.getVonDatum(), DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            }catch(Exception a){
                System.err.println("getVonDatum Text = \"\" Es wurde kein Datum übernommen!");
                //a.printStackTrace();
            }
            try {
                viewController.formController.bisDatum.valueProperty().set(LocalDate.parse(form.getBisDatum(), DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            }catch (Exception f){
                System.err.println("getBisDatum Text = \"\" Es wurde kein Datum übernommen!");
            }
            viewController.formController.kreuz0.selectedProperty().setValue(form.getKreuz0().equals("true"));
            viewController.formController.kreuz1.selectedProperty().setValue(form.getKreuz1().equals("true"));
            viewController.formController.kreuz2.selectedProperty().setValue(form.getKreuz2().equals("true"));
            viewController.formController.kreuz3.selectedProperty().setValue(form.getKreuz3().equals("true"));
            viewController.formController.kreuz00.selectedProperty().setValue(form.getKreuz00().equals("true"));
            viewController.formController.kreuz01.selectedProperty().setValue(form.getKreuz01().equals("true"));
            viewController.formController.kreuz02.selectedProperty().setValue(form.getKreuz02().equals("true"));
            viewController.formController.kreuz10.selectedProperty().setValue(form.getKreuz10().equals("true"));
            viewController.formController.kreuz11.selectedProperty().setValue(form.getKreuz11().equals("true"));
            viewController.formController.kreuz12.selectedProperty().setValue(form.getKreuz12().equals("true"));
            viewController.formController.kreuz20.selectedProperty().setValue(form.getKreuz20().equals("true"));
            viewController.formController.kreuz21.selectedProperty().setValue(form.getKreuz21().equals("true"));
            viewController.formController.kreuz22.selectedProperty().setValue(form.getKreuz22().equals("true"));

            Platform.runLater(()->{viewController.notificationText.setText("Formular wurde übernommen!");});

        });
        form.setName(viewController.formController.name.getText());
        form.setMobil(viewController.formController.mobil.getText());
        form.setEmail(viewController.formController.email.getText());
        form.setFirma(viewController.formController.firma.getText());
        form.setVorgesetzter(viewController.formController.vorgesetzter.getText());
        form.setStrasse(viewController.formController.strasse.getText());
        form.setPlzOrt(viewController.formController.plzOrt.getText());
        form.setNotwendigeArbeitsbereiche(viewController.formController.notwendigeArbeitsbereiche.getText());


        try {
            form.setVonDatum(viewController.formController.vonDatum.valueProperty().getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "");
        }catch (NullPointerException e){
            //für den fall, das kein Datum eingegeben wurde. auf andere weise schmeißt der Exception.
            form.setVonDatum("");
        }
        try{
            form.setBisDatum(viewController.formController.bisDatum.valueProperty().getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "");
        }catch (NullPointerException e) {
            //für den fall, das kein Datum eingegeben wurde. auf andere weise schmeißt der Exception.
            form.setBisDatum("");
        }
        form.setKreuz0(viewController.formController.kreuz0.selectedProperty().get()+"");
        form.setKreuz1(viewController.formController.kreuz1.selectedProperty().get()+"");
        form.setKreuz2(viewController.formController.kreuz2.selectedProperty().get()+"");
        form.setKreuz3(viewController.formController.kreuz3.selectedProperty().get()+"");
        form.setKreuz00(viewController.formController.kreuz00.selectedProperty().get()+"");
        form.setKreuz01(viewController.formController.kreuz01.selectedProperty().get()+"");
        form.setKreuz02(viewController.formController.kreuz02.selectedProperty().get()+"");
        form.setKreuz10(viewController.formController.kreuz10.selectedProperty().get()+"");
        form.setKreuz11(viewController.formController.kreuz11.selectedProperty().get()+"");
        form.setKreuz12(viewController.formController.kreuz12.selectedProperty().get()+"");
        form.setKreuz20(viewController.formController.kreuz20.selectedProperty().get()+"");
        form.setKreuz21(viewController.formController.kreuz21.selectedProperty().get()+"");
        form.setKreuz22(viewController.formController.kreuz22.selectedProperty().get()+"");

        return form;
    }


}

