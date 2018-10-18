package viewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import model.Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class ViewController {

    private Model model;
    public Parent formFXML;
    public Parent sendFXML;

    @FXML
    public AnchorPane contentPane;

    public ViewController(Model model){
        this.model = model;
        model.setViewController(this);
    }

    @FXML
    public void initialize(){}

    //@Button -> Besucher eintragen
    @FXML
    public void visitFormAction(){
        this.model.visitFormAction();
    }

    //@Button -> Formula zurücksetzen
    @FXML
    public void visitFormResetAction(){
        this.model.visitFormResetAction();
    }

    @FXML
    public void sendFormAction(){

        this.model.sendFormAction(this.sendFXML,this.contentPane);
    }


}
