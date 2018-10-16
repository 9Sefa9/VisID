package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Controller {

    private Parent form;
    private Parent test;

    @FXML public AnchorPane content;

    @FXML
    public void initialize()throws IOException{}
    //füge Form.fxml zu mid-main-pane hinzu
    @FXML
    public void visitButtonAction(){
        try {
            //sorgt dafür, dass daten erhalten bleiben bei fxml scene wechsel
            if(form == null)
              form = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Form.fxml"));

            this.content.getChildren().setAll(form);
        }catch(IOException i){
            i.printStackTrace();
        }

    }
    @FXML
    public void test(){
        try {
            if(test == null)
               test = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Test.fxml"));
            this.content.getChildren().setAll(test);
        }catch(IOException i){
            i.printStackTrace();
        }

    }
}
