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

    @FXML
    public void initialize() {
        System.out.println("INITIALIZE :: "+this.getClass());
    }

    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
        setModel(this.viewController.model);
    }
    private void setModel(Model model){
        this.model = model;
    }
}
