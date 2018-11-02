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
    //TODO: Eventuell unwichtig.
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

    }


}
