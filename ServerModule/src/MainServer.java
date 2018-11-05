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
        FXMLLoader form = new FXMLLoader(getClass().getResource("fxmlS/Received.fxml"));

        Parent root = main.load();

        controllersS.ViewController vc = (controllersS.ViewController)main.getController();

        vc.recentsParent = form.load();

        ReceivedController f = form.getController();

        vc.receivedController = form.getController();

        f.setViewController(vc);

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
