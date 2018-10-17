package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Controller {

    private Parent formFXML;

    @FXML public AnchorPane contentPane;

    @FXML
    public void initialize(){}

    //@Button -> Besucher eintragen
    @FXML
    public void visitFormAction(){
        try {
            //sorgt dafür, dass daten erhalten bleiben bei fxml scene wechsel
            if(formFXML== null)
                this.formFXML= FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Form.fxml"));

            this.contentPane.getChildren().setAll(formFXML);
        }catch(IOException i){
            i.printStackTrace();
        }

    }

    //@Button -> Formula zurücksetzen
    @FXML
    public void visitFormResetAction(){
        try {
            this.formFXML = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Form.fxml"));
            visitFormAction();
           // if(test == null)
             //  test = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Test.fxml"));
            //this.content.getChildren().setAll(test);
        }catch(IOException i){
            i.printStackTrace();
        }
    }

    @FXML
    public void sendFormAction(){

    }
}
