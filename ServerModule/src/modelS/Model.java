package modelS;

import external.Form;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;

public class Model {

    public void prepareTableView(controllersS.RecentsController recentsController){
        recentsController.formListTableView = FXCollections.observableArrayList();

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

        recentsController.recentTableView.setItems(recentsController.formListTableView);
    }
}
