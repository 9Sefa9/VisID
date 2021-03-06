import controllersS.PreferencesController;
import controllersS.ReceivedController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainServer extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader main = new FXMLLoader(getClass().getResource("/fxmlS/Main.fxml"));
        FXMLLoader received = new FXMLLoader(getClass().getResource("fxmlS/Received.fxml"));
        FXMLLoader preferences = new FXMLLoader(getClass().getResource("fxmlS/Preference.fxml"));

        Parent root = main.load();
        controllersS.ViewController vc = (controllersS.ViewController)main.getController();

        vc.receivedParent = received.load();
        ReceivedController f = received.getController();
        vc.receivedController = f;

        vc.preferencesParent = preferences.load();
        PreferencesController p = preferences.getController();
        vc.preferencesController = p;

        f.setViewController(vc);
        p.setViewController(vc);

        primaryStage.setTitle("VisID");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1150, 720));
        primaryStage.getIcons().add(new Image("image/Logo1.png"));
        primaryStage.show();


        primaryStage.setOnCloseRequest(e->{
            Platform.exit();
            System.exit(0);

        });
    }
}
