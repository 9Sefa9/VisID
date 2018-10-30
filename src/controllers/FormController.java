package controllers;

import external.Form;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Model;

import java.io.IOException;
import java.util.ArrayList;


public class FormController{
    @FXML
    private ViewController viewController;

    private Model model;

    @FXML
    public TextField name;

    @FXML
    public TextField mobil;

    @FXML
    public TextField email;

    @FXML
    public TextField firma;

    @FXML
    public TextField vorgesetzter;

    @FXML
    public TextField strasse;

    @FXML
    public TextField plzOrt;

    @FXML
    public TextField notwendigeArbeitsbereiche;

    @FXML
    public DatePicker vonDatum;

    @FXML
    public DatePicker bisDatum;

    @FXML
    public CheckBox kreuz0;

    @FXML
    public CheckBox kreuz1;

    @FXML
    public CheckBox kreuz2;

    @FXML
    public CheckBox kreuz3;

    @FXML
    public CheckBox kreuz00;

    @FXML
    public CheckBox kreuz01;

    @FXML
    public CheckBox kreuz02;

    @FXML
    public CheckBox kreuz10;

    @FXML
    public CheckBox kreuz11;

    @FXML
    public CheckBox kreuz12;

    @FXML
    public CheckBox kreuz20;

    @FXML
    public CheckBox kreuz21;

    @FXML
    public CheckBox kreuz22;

    //formList wichtig für die Transmission, versenden des momentanen Formulars.
    public ObservableList formList = FXCollections.observableArrayList();
    //Form wichtig für TableView
    public ObservableList<Form> formListTableView;
    public FormController(){

    }
    @FXML
    public void initialize(){
        System.out.println("INITIALIZE :: "+this.getClass());
    }

    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
        setModel(this.viewController.model);
    }
    private void setModel(Model model){
        this.model = model;
        prepareTableView(this.viewController.recentsController);

    }
    public void prepareTableView(RecentsController recentsController){
        this.formListTableView = FXCollections.observableArrayList();

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

        recentsController.recentTableView.setItems(this.formListTableView);
    }

}
