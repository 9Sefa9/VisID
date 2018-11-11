package controllersS;


import externalS.Handshake;
import externalS.Transmission;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import modelS.Model;

public class ViewController {

    public Parent receivedParent;
    public Parent preferencesParent;

    public ReceivedController receivedController;
    public PreferencesController preferencesController;

    public Model model;

    @FXML public Label notificationText;

    @FXML public AnchorPane contentPane;

    @FXML
    public void initialize(){
        //Thread starten zum empfangen von Formularen im Hintergrund
        Thread transmission = new Thread(new Transmission(this));
        transmission.start();

        //Thread , welches die Verfügbarkeit des Servers an die Clients sendet
        Thread handshake = new Thread(new Handshake());
        handshake.start();
    }
    public ViewController(){
        System.out.println("INITIALIZE :: "+this.getClass());
        this.model = new modelS.Model();
    }
    @FXML
    public void receiveForm(){
        this.model.receiveFormAction(this);

    }
    @FXML
    public void updateProgram(){
        this.model.updateProgramAction(this);
    }

    @FXML
    public void preferences(){
        this.model.settingsAction(this);
    }

}
