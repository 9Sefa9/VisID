package viewController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Model;

public class ViewController {

    private Model model;
    public Parent formFXML;
    public Parent sendFXML;
    public Parent updateFXML;

    @FXML
    public AnchorPane contentPane;

    @FXML
    public Label notificationText;

    //Formular definitionen:
    @FXML
    private TextField name,mobil,email,firma,vorgesetzter,strasse,plzOrt,notwendigeArbeitsbereiche;
    @FXML
    private DatePicker vonDatum,bisDatum;

    @FXML
    private ChoiceBox kreuz0,kreuz1,kreuz2,kreuz3;
    @FXML
    private ChoiceBox kreuz00,kreuz01,kreuz02,kreuz10,kreuz11,kreuz12,kreuz20,kreuz21,kreuz22;


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

        this.model.sendFormAction();
    }

    @FXML
    public void updateProgramAction(){
        this.model.updateProgramAction();
    }


}
