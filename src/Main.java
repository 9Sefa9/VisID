import controllers.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.scene.image.Image;
import model.Model;

import javax.swing.text.View;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader main = new FXMLLoader(getClass().getResource("fxml/Main.fxml"));
        //main.setController(viewController);

        Parent root = main.load();

        //ViewController viewController = main.getController();
        //viewController.form = new FormController();
        //ViewController
        //viewController.setAllControllers(form.getController(),recents.getController(),send.getController(),update.getController());
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
