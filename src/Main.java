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

        FXMLLoader form = new FXMLLoader(getClass().getResource("fxml/Form.fxml"));
        FXMLLoader send = new FXMLLoader(getClass().getResource("fxml/Send.fxml"));
        FXMLLoader recents = new FXMLLoader(getClass().getResource("fxml/Recents.fxml"));
        FXMLLoader update = new FXMLLoader(getClass().getResource("fxml/Update.fxml"));

        form.load();
        send.load();
        recents.load();
        update.load();

        ViewController vc = main.getController();
        FormController f = form.getController();
        SendController s = send.getController();
        RecentsController r = recents.getController();
        UpdateController u = update.getController();

        f.setViewController(vc);
        s.setViewController(vc);
        r.setViewController(vc);
        u.setViewController(vc);

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
