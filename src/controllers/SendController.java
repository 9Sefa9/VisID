package controllers;

import external.Text;
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
    public Label sendedText;

    @FXML
    public Label connectedText;

    @FXML
    public Label filledText;

    @FXML
    public Button send;


    public SendController(){

    }

    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
        setModel(this.viewController.model);
    }
    private void setModel(Model model){
        this.model = model;
    }

    @FXML
    public void initialize(){
        System.out.println("INITIALIZE :: "+this.getClass());
    }

    //TODO Ausrufezeichen entfernen.
    @FXML
    public void sendFilledForm(){
        //sende nur , wenn das Formular gefüllt war.
        try {
            if (model.formIsFilled(this.viewController, this.viewController.formController)) {
               //TODO beide ausrufe zeichen entfernen!
                if (!model.canConnectToServer) {

                    //hier findet die Tatsächliche Datenübertragung statt!
                    Transmission transmission = new Transmission(this.model.getCompletedForm(this.viewController.formController));
                    CompletableFuture<Boolean> solution = CompletableFuture.supplyAsync(transmission);
                    this.formIsSent = solution.get();
                    if(!this.formIsSent){
                        //Formular wurde erfolgreich gesendet!
                        this.sendedText.setStyle("-fx-text-fill: green");
                        this.sendedText.setText(Text.formSendOk);
                        //in die Historie einfügen!
                        this.model.addFormToRecent(this.viewController,this.viewController.recentsController);
                        this.model.clearCompletedForm(this.viewController.formController);

                        viewController.sendController.filledText.setStyle("-fx-text-fill: red");
                        viewController.sendController.filledText.setText(Text.filledNotOk);

                    }else{

                        this.sendedText.setStyle("-fx-text-fill: red");
                        this.sendedText.setText(Text.formSendNotOk);
                    }
                }else{
                    this.sendedText.setStyle("-fx-text-fill: red");
                    this.sendedText.setText(Text.formSendNotOk);
                }
            }
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }catch (ExecutionException ee){
            ee.printStackTrace();
        }
    }

}
