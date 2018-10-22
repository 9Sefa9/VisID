package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Model;

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
    public FormController(){

    }
    public FormController(Model model){
        this.model = model;
    }

    @FXML
    public void initialize(){System.out.println("INITIALIZE :: "+this.getClass());}

    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
    }
}
