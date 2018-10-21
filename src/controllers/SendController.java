package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class SendController implements Initializable {
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
        System.out.println("test");
    }
    public void setIsFilled(String text){
        this.send.setText(text);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
