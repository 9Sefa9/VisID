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
        FXMLLoader form = new FXMLLoader(getClass().getResource("fxmlS/Recents.fxml"));

        Parent root = main.load();

        controllersS.ViewController vc = (controllersS.ViewController)main.getController();

        vc.recentsParent = form.load();

        controllersS.RecentsController f = form.getController();

        vc.recentsController = form.getController();

        f.setViewController(vc);

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
}
