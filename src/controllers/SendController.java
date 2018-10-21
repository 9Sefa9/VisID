package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class SendController{
    @FXML
    private ViewController viewController;

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
    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
    }

    @FXML
    public void initialize(){
        if(this.model.formIsFilled(viewController,viewController.form)){
            this.isFilled.setText("OK");
        }else{
            this.isFilled.setText("NOT OK");
        }
    }


}
