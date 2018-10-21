package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Model;

public class SendController {
    private Model model;

    @FXML
    public Label connectionOK;

    @FXML
    public Label formFilled;

    @FXML
    public Button send;
    public SendController(Model model){
        this.model = model;
    }
    @FXML
    public void initialize(){

    }
}
