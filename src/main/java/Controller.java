/**
 * Represents the controller class for a sign in window that is not in used right now.
 *
 * @author Ronald Quiroz
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.HashSet;

public class Controller {

    @FXML
    private Label lblOutput;

    //list to add the products and show them in the tableview and listView
    public static ObservableList<Product> productLine;

    //arrayList of product so I can select multiples products to produce from the listView.
    public static ArrayList<Product> productSelected = new ArrayList<Product>();

    //array of integer so I can have a diff. int for each product in the arrayList of products.
    public static ArrayList<Integer> num = new ArrayList<Integer>();

    public void sayHello() {
        lblOutput.setText("Hello FXML!");

    }

    @FXML
    private Text actiontarget;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Sign in button pressed");
    }


}