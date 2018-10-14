package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

   // @FXML
  //  private Button createVisitButton;

      @FXML
      public Pane contentPane;

    @FXML
    public void initialize(){

    }
    @FXML
    public void createVisitButtonAction(ActionEvent event){
        try {

            Parent form = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Form.fxml"));
            contentPane.getChildren().setAll(form);
        }catch(IOException i){
            i.printStackTrace();
        }

    }
}
