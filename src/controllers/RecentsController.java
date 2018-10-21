package controllers;

import javafx.fxml.FXML;
import model.Model;

public class RecentsController {
    @FXML
    private ViewController viewController;

    private Model model;
    public RecentsController(){

    }
    public RecentsController(Model model){
        this.model = model;
    }

    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
    }
}
