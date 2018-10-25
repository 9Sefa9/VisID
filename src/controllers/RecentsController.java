package controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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

    private Model model;
    public RecentsController(){ }

    @FXML
    public void initialize(){
        System.out.println("INITIALIZE :: "+this.getClass());
//TODO!
       // this.nameColumn.setCellValueFactory();
    }

    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
        setModel(this.viewController.model);
    }
    private void setModel(Model model){
        this.model = model;
    }
}

