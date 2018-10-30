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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Model {
    //aussage darüber ob eine verbindung überhaupt aufgebaut werden kann in 10 sec. takt
    public boolean canConnectToServer;

    //Funktionalität für das "Besucher eintragen" Button im Main Menu
    public void visitForm(ViewController viewController) {

        //Notification Text aktuaisiern
        viewController.notificationText.setText(Text.notificationTextFormular);

        viewController.contentPane.getChildren().setAll(viewController.formParent);


    }

    //Funktionalität für das "Formular zurücksetzen" Button im Main Menu
    public void visitFormReset(ViewController viewController) {
        try {


            if (viewController.formParent != null) {
                viewController.formParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Form.fxml"));
                visitForm(viewController);

                //Notification Text am Ende aktualisieren
                viewController.notificationText.setText(Text.notificationTextResetFormular);
            }

        } catch (IOException i) {
            i.printStackTrace();
            ExceptionLogger.appendToFile(i);
        }
    }

    //Funktionalität für das "Formular Senden" Button im Main Menu
    public void sendForm(ViewController viewController, SendController sendController, FormController formController) {
        try {

            //Notification Text aktuaisiern
            viewController.notificationText.setText(Text.notificationTextSendFormular);

            //contentpane aktualisieren
            if (viewController.sendParent == null)
                viewController.sendParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Send.fxml"));

            viewController.contentPane.getChildren().setAll(viewController.sendParent);

            //überprüfen ob Formular wenigstens etwas aufgefüllt wurde vor dem eigentlichen connection test
            if (formIsFilled(viewController, formController)) {
                sendController.filledText.setStyle("-fx-text-fill: green");
                sendController.filledText.setText(Text.filledOk);

            } else {
                sendController.filledText.setStyle("-fx-text-fill: red");
                sendController.filledText.setText(Text.filledNotOk);
            }

            connectionTest(viewController, sendController);

        } catch (IOException i) {
            i.printStackTrace();
            ExceptionLogger.appendToFile(i);
        }
    }

    //Diese Methode testet in 10 sekunden abschnitten über die Verfügbarkeit des Servers.
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
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                } catch (ExecutionException ee) {
                    ee.printStackTrace();
                }
            }

        }).start();
    }

    //Funktionalität für das "Auf Updates überprüfen" Button im Main
    public void updateProgram(ViewController viewController) {
        try {
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

    //Funktionalität für das "Historie" Button im Main
    public void visitFormRecents(ViewController viewController) {
        try {
            viewController.notificationText.setText(Text.notificationTextRecent);

            if (viewController.recentsParent == null)
                viewController.recentsParent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Recents.fxml"));

            viewController.contentPane.getChildren().setAll(viewController.recentsParent);
        } catch (IOException e) {
            e.printStackTrace();
            ExceptionLogger.appendToFile(e);
        }
    }

    public boolean formIsFilled(ViewController viewController, FormController formController) {
        // formular gilt as gefüllt, wenn der Name und oder Mobil eingetragen ist.
        if (viewController.formParent != null) {

            if ((!formController.name.getText().trim().isEmpty()) && (!formController.mobil.getText().trim().isEmpty())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

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

    public void clearCompletedForm(FormController formController) {
        resetLabel(formController);
        resetDatePicker(formController);
        resetChoiceBox(formController);
    }

    public void addFormToRecent(FormController formController, RecentsController recentsController) {

        Form form = getNewForm(formController);
        recentsController.recentTableView.getItems().add(form);

    }

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

    private Form getNewForm(FormController formController) {

        //TODO die Listener überschrieben auch das neuere ! das muss gexit werden.
        Form form = new Form();
        System.out.println("method getNewForm NAME : " + formController.name.getText());
        form.setName(formController.name.getText());
        form.setMobil(formController.mobil.getText());
        form.setEmail(formController.email.getText());
        form.setFirma(formController.firma.getText());
        form.setVorgesetzter(formController.vorgesetzter.getText());
        form.setStrasse(formController.strasse.getText());
        form.setPlzOrt(formController.plzOrt.getText());
        form.setNotwendigeArbeitsbereiche(formController.notwendigeArbeitsbereiche.getText());
        form.setVonDatum(formController.vonDatum.valueProperty().getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy / dd-MMM-yyyy")) + "");
        form.setBisDatum(formController.bisDatum.valueProperty().getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy / dd-MMM-yyyy")) + "");
        form.setKreuz0(formController.kreuz0.selectedProperty().get()+"");
        form.setKreuz1(formController.kreuz1.selectedProperty().get()+"");
        form.setKreuz2(formController.kreuz2.selectedProperty().get()+"");
        form.setKreuz3(formController.kreuz3.selectedProperty().get()+"");
        form.setKreuz00(formController.kreuz00.selectedProperty().get()+"");
        form.setKreuz01(formController.kreuz01.selectedProperty().get()+"");
        form.setKreuz02(formController.kreuz02.selectedProperty().get()+"");
        form.setKreuz10(formController.kreuz10.selectedProperty().get()+"");
        form.setKreuz11(formController.kreuz11.selectedProperty().get()+"");
        form.setKreuz12(formController.kreuz12.selectedProperty().get()+"");
        form.setKreuz20(formController.kreuz20.selectedProperty().get()+"");
        form.setKreuz21(formController.kreuz21.selectedProperty().get()+"");
        form.setKreuz22(formController.kreuz22.selectedProperty().get()+"");

        return form;
    }

}

