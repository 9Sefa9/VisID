package controllers;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.xml.internal.ws.util.CompletedFuture;
import external.Transmission;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Model;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SendController{
    //aussage darüber, ob formular gesendet wurde
    private boolean formIsSent;

    @FXML
    private ViewController viewController;

    private Model model;

    @FXML
    public Label connectedText;

    @FXML
    public Label filledText;

    @FXML
    public Button send;


    public SendController(){

    }
    public SendController(Model model){
        this.model = model;
    }
    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
    }

    @FXML
    public void initialize(){
        System.out.println("INITIALIZE :: "+this.getClass());
    }

    @FXML
    public void sendFilledForm(){
        //sende nur , wenn das Formular gefüllt war.

        try {
            if (model.formIsFilled(this.viewController, this.viewController.form)) {
                if (model.canConnectToServer) {
                    Transmission transmission = new Transmission();
                    CompletableFuture<Boolean> solution = CompletableFuture.supplyAsync(transmission);
                    this.formIsSent = solution.get();
                    if(this.formIsSent){
                        //Forumlar wurde erfolgreich gesendet!
                    }
                }
            }
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }catch (ExecutionException ee){
            ee.printStackTrace();
        }
    }

}
