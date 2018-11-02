package controllersS;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import modelS.Model;

public class ViewController {

    public Parent formParent;
    public FormController formController;
    public Model model;

    public ViewController(){
        System.out.println("INITIALIZE :: "+this.getClass());
        this.model = new modelS.Model();
    }
    @FXML
    public void settings(){

    }
    @FXML
    public void receiveForm(){

    }
    @FXML
    public void updateProgram(){

    }
}
