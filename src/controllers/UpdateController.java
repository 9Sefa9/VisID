package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateController {
    @FXML
    private ViewController viewController;

    private Model model;

    public UpdateController(){

    }
    public UpdateController(Model model){
        this.model = model;
    }

    @FXML
    public void initialize() {
        System.out.println("INITIALIZE :: "+this.getClass());
    }

    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
    }
}
