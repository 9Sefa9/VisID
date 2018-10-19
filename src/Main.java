import viewController.ViewController;
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
        //Parent root = FXMLLoader.load(getClass().getResource("fxml/Main.fxml"));

        FXMLLoader load = new FXMLLoader(getClass().getResource("fxml/Main.fxml"));
        load.setController(viewController);

        Parent root = load.load();
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
