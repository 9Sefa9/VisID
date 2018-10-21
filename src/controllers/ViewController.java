package controllers;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.Model;

import javax.swing.text.View;


public class ViewController {
    private Model model;

    @FXML public FormController form;

    @FXML public SendController send;

    @FXML public UpdateController update;

    @FXML public RecentsController recents;

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
    public void initialize(){
        this.model = new Model();
    }
    public ViewController(){
        //TODO
        // form.setViewController(this);
      //  recents.setViewController(this);
       // send.setViewController(this);
       // update.setViewController(this);
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
        this.model.sendForm(this,this.send,this.form);
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
