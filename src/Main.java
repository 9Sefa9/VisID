import controllers.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.scene.image.Image;


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

        ViewController vc = main.getController();

        vc.formParent = form.load();
        vc.sendParent = send.load();
        vc.recentsParent = recents.load();
        vc.updateParent = update.load();

        FormController f = form.getController();
        SendController s = send.getController();
        RecentsController r = recents.getController();
        UpdateController u = update.getController();

        vc.form = form.getController();
        vc.send = send.getController();
        vc.recents = recents.getController();
        vc.update = update.getController();

        f.setViewController(vc);
        s.setViewController(vc);
        r.setViewController(vc);
        u.setViewController(vc);

        primaryStage.setTitle("VisID");

        primaryStage.setScene(new Scene(root, 1150, 720));
        primaryStage.getIcons().add(new Image("image/Logo1.png"));
        primaryStage.setResizable(false);
        primaryStage.show();


        primaryStage.setOnCloseRequest(e->{
                Platform.exit();
                System.exit(0);

        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
