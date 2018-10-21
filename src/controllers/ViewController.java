package controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.Model;

import java.io.IOException;

public class ViewController {

    private FormController formController;
    private SendController sendController;
    private UpdateController updateController;
    private RecentsController recentsController;

    private Model model;

    //wichtig um andere FXML öffnen zu können
    public Parent formFXML;
    public Parent sendFXML;
    public Parent updateFXML;
    public Parent recentsFXML;

    @FXML
    public AnchorPane contentPane;

    @FXML
    public Label notificationText;

    @FXML
    public TextField test;
    
    public ViewController(Model model){
        this.model = model;

    }


    public void setAllControllers(FormController formController, RecentsController recentsController, SendController sendController, UpdateController updateController){
        this.formController = formController;
        this.sendController = sendController;
        this.updateController = updateController;
        this.recentsController = recentsController;
    }

    //@Button -> Besucher eintragen
    @FXML
    public void visitFormAction(){
        this.model.visitForm(this);
    }

    //@Button -> Formula zurücksetzen
    @FXML
    public void visitFormResetAction(){
        this.model.visitFormReset(this);
    }

    @FXML
    public void sendFormAction(){
        this.model.sendForm(this,this.sendController,this.formController);
    }

    @FXML
    public void updateAction(){
        this.model.updateProgram(this);
    }

    @FXML
    public void visitFormRecentsAction(){
        this.model.visitFormRecents(this);
    }

}
