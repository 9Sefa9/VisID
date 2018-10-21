package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateController implements Initializable {
    @FXML
    private ViewController viewController;

    private Model model;

    public UpdateController(){

    }
    public UpdateController(Model model){
        this.model = model;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
    }
}
