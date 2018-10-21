package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Model;

public class SendController {
    private Model model;

    @FXML
    public Label isConnected;

    @FXML
    public Label isFilled;

    @FXML
    public Button send;

    public SendController(Model model){
        this.model = model;
    }
    @FXML
    public void initialize(){

    }
    public void setIsFilled(String text){
        this.send.setText(text);
    }
}
