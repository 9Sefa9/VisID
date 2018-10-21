package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Model;

public class FormController {

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
    public ChoiceBox kreuzZero;

    @FXML
    public ChoiceBox kreuzOne;

    @FXML
    public ChoiceBox kreuzTwo;

    @FXML
    public ChoiceBox kreuzThree;

    @FXML
    public ChoiceBox kreuzZeroZero;
    @FXML
    public ChoiceBox kreuzZeroOne;
    @FXML
    public ChoiceBox kreuzZeroTwo;
    @FXML
    public ChoiceBox kreuzOneZero;
    @FXML
    public ChoiceBox kreuzOneOne;
    @FXML
    public ChoiceBox kreuzOneTwo;
    @FXML
    public ChoiceBox kreuzTwoZero;
    @FXML
    public ChoiceBox kreuzTwoOne;
    @FXML
    public ChoiceBox kreuzTwoTwo;

    public FormController(Model model){
        this.model = model;
    }
}
