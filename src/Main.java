import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.awt.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("fxml/Main.fxml"));
        primaryStage.setTitle("VisID");
       // GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
       // int width = gd.getDisplayMode().getWidth();
       // int height = gd.getDisplayMode().getHeight();
        primaryStage.setScene(new Scene(root, 1024, 640));

        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
