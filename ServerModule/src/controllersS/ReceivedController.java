package controllersS;

import external.Form;
import externalS.Transmission;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReceivedController {
    @FXML
    public TextField searchField;
    @FXML
    public TableView receivedTableView;

    @FXML
    public TableColumn buttonColumn;

    @FXML
    public TableColumn nameColumn;

    @FXML
    public TableColumn mobilColumn;

    @FXML
    public TableColumn firmaColumn;

    @FXML
    public TableColumn emailColumn;

    @FXML
    public TableColumn vorgesetzterColumn;

    @FXML
    public TableColumn plzOrtColumn;

    @FXML
    public TableColumn strasseColumn;

    @FXML
    public TableColumn notwendigeArbeitsbereicheColumn;

    @FXML
    public TableColumn vonColumn;

    @FXML
    public TableColumn bisColumn;

    @FXML
    public TableColumn kreuz0Column;

    @FXML
    public TableColumn kreuz1Column;

    @FXML
    public TableColumn kreuz2Column;

    @FXML
    public TableColumn kreuz3Column;

    @FXML
    public TableColumn kreuz00Column;

    @FXML
    public TableColumn kreuz01Column;

    @FXML
    public TableColumn kreuz02Column;

    @FXML
    public TableColumn kreuz10Column;

    @FXML
    public TableColumn kreuz11Column;

    @FXML
    public TableColumn kreuz12Column;

    @FXML
    public TableColumn kreuz20Column;

    @FXML
    public TableColumn kreuz21Column;

    @FXML
    public TableColumn kreuz22Column;

    public controllersS.ViewController viewController;

    public modelS.Model model;

    public ObservableList<Object> formListTableView;

    @FXML
    public void initialize(){
        System.out.println("INITIALIZE :: "+this.getClass());

    }

    public void setViewController(controllersS.ViewController viewController) {
        this.viewController = viewController;
        setModel(this.viewController.model);
    }
    private void setModel(modelS.Model model){
        this.model = model;
        model.prepareTableView(this);
        model.prepareSearchField(this);
    }
}
