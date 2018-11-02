package controllersS;

import externalS.Text;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import modelS.Model;

public class ViewController {

    public Parent recentsParent;
    public controllersS.RecentsController recentsController;
    public Model model;

    @FXML private Label notificationText;

    @FXML private AnchorPane contentPane;

    public ViewController(){
        System.out.println("INITIALIZE :: "+this.getClass());
        this.model = new modelS.Model();
    }
    @FXML
    public void settings(){
            this.notificationText.setText(Text.preferencesText);
    }

    @FXML
    public void receiveForm(){
             this.notificationText.setText(Text.receivedFormularsText);

             this.contentPane.getChildren().setAll(this.recentsParent);
    }
    @FXML
    public void updateProgram(){
        this.notificationText.setText(Text.notificationTextUpdate);
    }
}
