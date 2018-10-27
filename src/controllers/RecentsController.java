package controllers;

import external.Form;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.Model;

public class RecentsController {
    @FXML
    private ViewController viewController;

    @FXML
    public TableView recentTableView;

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


    private Model model;

    public RecentsController(){ }

    @FXML
    public void initialize(){
        System.out.println("INITIALIZE :: "+this.getClass());

    }

    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
        setModel(this.viewController.model);
    }
    private void setModel(Model model){
        this.model = model;
    }
}

