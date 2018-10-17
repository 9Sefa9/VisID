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
    private Parent formFXML;
    private Parent sendFXML;

    @FXML private AnchorPane contentPane;

    public ViewController(Model model){
        this.model = model;
    }

    @FXML
    public void initialize(){}

    //@Button -> Besucher eintragen
    @FXML
    public void visitFormAction(){
        this.model.visitFormAction(this.formFXML,this.contentPane);

    }

    //@Button -> Formula zurücksetzen
    @FXML
    public void visitFormResetAction(){
        this.model.visitFormResetAction(this.formFXML,this.contentPane);
    }

    @FXML
    public void sendFormAction(){
        this.model.sendFormAction(this.sendFXML,this.contentPane);
    }


}
