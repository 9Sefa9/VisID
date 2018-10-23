package controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Model;

import java.util.ArrayList;

//TODO momentanes problem: die indizes beim arraylist werden nicht ordentlich in einer reiehenfolge gesettet. Den Grund weis ich(mehr oder weniger).
//TODO eventuell zu einem einfachen Verfahren umsteigen !?
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


            formList.addAll(this.name.getText(), this.mobil.getText(), this.email.getText(), this.firma.getText(), this.vorgesetzter.getText(),
                    this.strasse.getText(), this.plzOrt.getText(), this.notwendigeArbeitsbereiche.getText(),
                    this.vonDatum.getValue(), this.bisDatum.getValue(), this.kreuz0.isSelected(), this.kreuz1.isSelected(), this.kreuz2.isSelected(), this.kreuz3.isSelected(),
                    this.kreuz00.isSelected(), this.kreuz01.isSelected(), this.kreuz02.isSelected(), this.kreuz10.isSelected(), this.kreuz11.isSelected(),
                    this.kreuz12.isSelected(), this.kreuz20.isSelected(), this.kreuz21.isSelected(), this.kreuz22.isSelected());

        labelListeners();
        datePickerListeners();
        choiceBoxListeners();

    }
    private void choiceBoxListeners(){

        this.kreuz0.selectedProperty().addListener((ob,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.kreuz1.selectedProperty().addListener((ob,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.kreuz2.selectedProperty().addListener((ob,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.kreuz3.selectedProperty().addListener((ob,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.kreuz00.selectedProperty().addListener((ob,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.kreuz01.selectedProperty().addListener((ob,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.kreuz02.selectedProperty().addListener((ob,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.kreuz10.selectedProperty().addListener((ob,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.kreuz11.selectedProperty().addListener((ob,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.kreuz12.selectedProperty().addListener((ob,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.kreuz20.selectedProperty().addListener((ob,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.kreuz21.selectedProperty().addListener((ob,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.kreuz22.selectedProperty().addListener((ob,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
    }
    private void datePickerListeners(){
        this.vonDatum.valueProperty().addListener((ob,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.bisDatum.valueProperty().addListener((ob,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
    }
    //bei kleinster textuelle veränderung werden die unten aufgeführten Listener aufgerufen
    private void labelListeners(){
        this.name.textProperty().addListener((obs,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });

        this.mobil.textProperty().addListener((obs,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.email.textProperty().addListener((obs,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.firma.textProperty().addListener((obs,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.vorgesetzter.textProperty().addListener((obs,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.strasse.textProperty().addListener((obs,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.plzOrt.textProperty().addListener((obs,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });
        this.notwendigeArbeitsbereiche.textProperty().addListener((obs,old,ne) -> {
            this.formList.set(this.formList.indexOf(old),ne);
        });

    }
    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
    }

}
