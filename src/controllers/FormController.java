package controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
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
    public ObservableList formList = FXCollections.observableArrayList();

    public FormController(){
    }
    public FormController(Model model){
        this.model = model;

    }

    @FXML
    public void initialize(){
        System.out.println("INITIALIZE :: "+this.getClass());

        labelListeners();
        datePickerListeners();
        choiceBoxListeners();

    }
    //bei kleinster veränderung werden die unten aufgeführten Listener aufgerufen
    private void choiceBoxListeners(){

        this.kreuz0.selectedProperty().addListener((ob,old,ne) -> {
           this.kreuz0.selectedProperty().setValue(ne);
        });
        this.kreuz1.selectedProperty().addListener((ob,old,ne) -> {
            this.kreuz1.selectedProperty().setValue(ne);
        });
        this.kreuz2.selectedProperty().addListener((ob,old,ne) -> {
            this.kreuz2.selectedProperty().setValue(ne);
        });
        this.kreuz3.selectedProperty().addListener((ob,old,ne) -> {
            this.kreuz3.selectedProperty().setValue(ne);
        });
        this.kreuz00.selectedProperty().addListener((ob,old,ne) -> {
            this.kreuz00.selectedProperty().setValue(ne);
        });
        this.kreuz01.selectedProperty().addListener((ob,old,ne) -> {
            this.kreuz01.selectedProperty().setValue(ne);
        });
        this.kreuz02.selectedProperty().addListener((ob,old,ne) -> {
            this.kreuz02.selectedProperty().setValue(ne);
        });
        this.kreuz10.selectedProperty().addListener((ob,old,ne) -> {
            this.kreuz10.selectedProperty().setValue(ne);
        });
        this.kreuz11.selectedProperty().addListener((ob,old,ne) -> {
            this.kreuz11.selectedProperty().setValue(ne);
        });
        this.kreuz12.selectedProperty().addListener((ob,old,ne) -> {
            this.kreuz12.selectedProperty().setValue(ne);
        });
        this.kreuz20.selectedProperty().addListener((ob,old,ne) -> {
            this.kreuz20.selectedProperty().setValue(ne);
        });
        this.kreuz21.selectedProperty().addListener((ob,old,ne) -> {
            this.kreuz21.selectedProperty().setValue(ne);
        });
        this.kreuz22.selectedProperty().addListener((ob,old,ne) -> {
            this.kreuz22.selectedProperty().setValue(ne);
        });
    }
    private void datePickerListeners(){
        this.vonDatum.valueProperty().addListener((ob,old,ne) -> {
            this.vonDatum.valueProperty().setValue(ne);
        });
        this.bisDatum.valueProperty().addListener((ob,old,ne) -> {
            this.bisDatum.valueProperty().setValue(ne);
        });
    }
    private void labelListeners(){
        this.name.textProperty().addListener((obs,old,ne) -> {
           this.name.setText(ne);
        });

        this.mobil.textProperty().addListener((obs,old,ne) -> {
            this.mobil.setText(ne);
        });
        this.email.textProperty().addListener((obs,old,ne) -> {
            this.email.setText(ne);
        });
        this.firma.textProperty().addListener((obs,old,ne) -> {
            this.firma.setText(ne);
        });
        this.vorgesetzter.textProperty().addListener((obs,old,ne) -> {
            this.vorgesetzter.setText(ne);
        });
        this.strasse.textProperty().addListener((obs,old,ne) -> {
            this.strasse.setText(ne);
        });
        this.plzOrt.textProperty().addListener((obs,old,ne) -> {
            this.plzOrt.setText(ne);
        });
        this.notwendigeArbeitsbereiche.textProperty().addListener((obs,old,ne) -> {
            this.notwendigeArbeitsbereiche.setText(ne);
        });

    }
    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
    }




}
