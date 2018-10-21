import controllers.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.scene.image.Image;
import model.Model;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Model model = new Model();
        ViewController viewController = new ViewController(model);

        FormController formController = new FormController(model);
        RecentsController recentsController = new RecentsController(model);
        SendController sendController = new SendController(model);
        UpdateController updateController = new UpdateController(model);


        FXMLLoader form= new FXMLLoader(getClass().getResource("fxml/Form.fxml"));
        form.setController(formController);

        FXMLLoader recents= new FXMLLoader(getClass().getResource("fxml/Recents.fxml"));
        recents.setController(recentsController);

        FXMLLoader send= new FXMLLoader(getClass().getResource("fxml/Send.fxml"));
        send.setController(sendController);

        FXMLLoader update = new FXMLLoader(getClass().getResource("fxml/Update.fxml"));
        update.setController(updateController);

        FXMLLoader main = new FXMLLoader(getClass().getResource("fxml/Main.fxml"));
        main.setController(viewController);

        Parent root = main.load();

        //ViewController
        viewController.setAllControllers(form.getController(),recents.getController(),send.getController(),update.getController());
        primaryStage.setTitle("VisID");

        primaryStage.setScene(new Scene(root, 1150, 720));
        primaryStage.getIcons().add(new Image("image/Logo1.png"));
        primaryStage.setResizable(false);
        primaryStage.show();


        primaryStage.setOnCloseRequest(e -> Platform.exit());

    }

    public static void main(String[] args) {
        launch(args);
    }
}
