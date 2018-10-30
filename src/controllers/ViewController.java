package controllers;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.Model;


public class ViewController {
    public Model model;

    //die jeweiligen Contorller von den FXMLs
    @FXML public FormController formController;

    @FXML public SendController sendController;

    @FXML public UpdateController updateController;

    @FXML public RecentsController recentsController;

    //Parents : zum öffnen bzw einsetzen von FXMl dokumenten in bestimmten Panes
    public Parent formParent;
    public Parent sendParent;
    public Parent updateParent;
    public Parent recentsParent;

    @FXML
    public AnchorPane contentPane;

    @FXML
    public Label notificationText;

    @FXML
    public void initialize(){
        System.out.println("INITIALIZE :: "+this.getClass());
        this.model = new Model();
    }
    public ViewController(){
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
        this.model.sendForm(this);
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
