package controllers;

import javafx.fxml.FXML;
import model.Model;

public class RecentsController {
    @FXML
    private ViewController viewController;

    private Model model;
    public RecentsController(){ }

    @FXML
    public void initialize(){
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

