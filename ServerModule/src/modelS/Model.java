package modelS;

import controllersS.ReceivedController;
import controllersS.ViewController;
import external.Form;
import externalS.Text;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Model {

    public void prepareTableView(ReceivedController receivedController){
        receivedController.formListTableView = FXCollections.observableArrayList();

        receivedController.buttonColumn.setCellValueFactory(new PropertyValueFactory<Form, Button>("button"));
        receivedController.nameColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("name"));
        receivedController.mobilColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("mobil"));
        receivedController.emailColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("email"));
        receivedController.firmaColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("firma"));
        receivedController.vorgesetzterColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("vorgesetzter"));
        receivedController.strasseColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("strasse"));
        receivedController.plzOrtColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("plzOrt"));
        receivedController.notwendigeArbeitsbereicheColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("notwendigeArbeitsbereiche"));
        receivedController.vonColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("vonDatum"));
        receivedController.bisColumn.setCellValueFactory(new PropertyValueFactory<Form, String>("bisDatum"));
        receivedController.kreuz0Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz0"));
        receivedController.kreuz1Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz1"));
        receivedController.kreuz2Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz2"));
        receivedController.kreuz3Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz3"));
        receivedController.kreuz00Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz00"));
        receivedController.kreuz01Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz01"));
        receivedController.kreuz02Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz02"));
        receivedController.kreuz10Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz10"));
        receivedController.kreuz11Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz11"));
        receivedController.kreuz12Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz12"));
        receivedController.kreuz20Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz20"));
        receivedController.kreuz21Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz21"));
        receivedController.kreuz22Column.setCellValueFactory(new PropertyValueFactory<Form, String>("kreuz22"));

        receivedController.receivedTableView.setItems(receivedController.formListTableView);
    }

    public void receiveFormAction(ViewController viewController) {

        fitSizeFromTo(viewController.contentPane,viewController.recentsParent);

        viewController.notificationText.setText(Text.receivedFormularsText);

        viewController.contentPane.getChildren().setAll(viewController.recentsParent);

    }

    public void settingsAction(ViewController viewController) {
        //fitSizeFromTo(viewController.contentPane,viewController.recentsParent);

        viewController.notificationText.setText(Text.preferencesText);
    }

    public void updateProgramAction(ViewController viewController) {
      //  fitSizeFromTo(viewController.contentPane,viewController.recentsParent);

        viewController.notificationText.setText(Text.notificationTextUpdate);
    }

    public void addToReceived(TableView receivedTableView, ArrayList<Object> transmittedList) {
        synchronized (receivedTableView.getItems()){

            externalS.Form form = new externalS.Form();
            form.setName((String)transmittedList.get(0));
            form.setMobil((String)transmittedList.get(1));
            form.setEmail((String)transmittedList.get(2));
            form.setFirma((String)transmittedList.get(3));
            form.setVorgesetzter((String)transmittedList.get(4));
            form.setStrasse((String)transmittedList.get(5));
            form.setPlzOrt((String)transmittedList.get(6));
            form.setNotwendigeArbeitsbereiche((String)transmittedList.get(7));

            //Die folgenden zwei try catches sollen das Datum auf die gewohnte art umparsen.
            try {
                SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");
                Date dateValue = input.parse((String)transmittedList.get(8));

                SimpleDateFormat output = new SimpleDateFormat("dd.MM.yyyy");
                form.setVonDatum(output.format(dateValue));

            } catch (ParseException e) {
              //  e.printStackTrace();
                form.setVonDatum("");
            }

            try {

                SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");
                Date dateValue = input.parse((String)transmittedList.get(9));

                SimpleDateFormat output = new SimpleDateFormat("dd.MM.yyyy");
                form.setBisDatum(output.format(dateValue));

            } catch (ParseException e) {
               // e.printStackTrace();
                form.setBisDatum("");
            }

            form.setKreuz0((String)transmittedList.get(10));
            form.setKreuz1((String)transmittedList.get(11));
            form.setKreuz2((String)transmittedList.get(12));
            form.setKreuz3((String)transmittedList.get(13));
            form.setKreuz00((String)transmittedList.get(14));
            form.setKreuz01((String)transmittedList.get(15));
            form.setKreuz02((String)transmittedList.get(16));
            form.setKreuz10((String)transmittedList.get(17));
            form.setKreuz11((String)transmittedList.get(18));
            form.setKreuz12((String)transmittedList.get(19));
            form.setKreuz20((String)transmittedList.get(20));
            form.setKreuz21((String)transmittedList.get(21));
            form.setKreuz22((String)transmittedList.get(22));

            receivedTableView.getItems().add(form);
        }

    }
    public void fitSizeFromTo(AnchorPane from, Parent to){
        from.setRightAnchor(to, .0);
        from.setTopAnchor(to, .0);
        from.setLeftAnchor(to, .0);
        from.setBottomAnchor(to, .0);
    }
}
