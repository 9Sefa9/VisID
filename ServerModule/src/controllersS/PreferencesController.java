package controllersS;

import controllers.ViewController;
import javafx.fxml.FXML;
import model.Model;

public class PreferencesController {
    private controllersS.ViewController viewController;
    private modelS.Model model;

    @FXML
    public void initialize(){
        System.out.println("INITIALIZE :: "+this.getClass());
    }
    public void setViewController(controllersS.ViewController viewController) {
        this.viewController = viewController;
        setModel(this.viewController.model);
    }
    private void setModel(modelS.Model model){
        this.model = model;

    }
}
