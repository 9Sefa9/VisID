package modelS;

import controllersS.ReceivedController;
import controllersS.ViewController;
import external.Form;
import externalS.Text;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;

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

        receivedController.recentTableView.setItems(receivedController.formListTableView);
    }

    public void receiveFormAction(ViewController viewController) {

        viewController.notificationText.setText(Text.receivedFormularsText);

        viewController.contentPane.getChildren().setAll(viewController.recentsParent);

    }

    public void settingsAction(ViewController viewController) {
        viewController.notificationText.setText(Text.preferencesText);
    }

    public void updateProgramAction(ViewController viewController) {
        viewController.notificationText.setText(Text.notificationTextUpdate);
    }
}
