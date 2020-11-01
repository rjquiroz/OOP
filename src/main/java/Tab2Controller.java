/**
 * Represents tab 2 of the OOP production project.
 * It gives format to the tab 2, initialize the comboBox with some values, and handles the recordProduction button event.
 *
 * @author Ronald Quiroz
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class Tab2Controller extends Controller implements Initializable {

    @FXML
    private ComboBox<String> cmbQuantity;

    @FXML
    private ListView<Product> listView;

    /**
     * initilialize the comboBox of tab 2 with some values.
     */
    @Override
    public void initialize(URL location, ResourceBundle resource) {
        for (int i = 1; i <= 10; i++) {
            cmbQuantity.getItems().add(String.valueOf(i));
        }

        cmbQuantity.setEditable(true);
        cmbQuantity.getSelectionModel().selectFirst();

        //set the products on the productLine list to the listView in the tab2
        listView.setItems(productLine);
        //allow to select multiple products from the listView.
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    @FXML
    protected void handleRecordProductionButtonAction(ActionEvent event) {
        //add the number selected from the comboBox to the num arrayList,
        // so I can associate it to the arrayList of products.
        num.add(Integer.parseInt(cmbQuantity.getValue()));

        //if the product selected isnt already in the list add it. else a print statement saying otherwise.
        if (!productSelected.contains(listView.getSelectionModel().getSelectedItem()))
            productSelected.add(listView.getSelectionModel().getSelectedItem());
        else {
            System.out.println("That product had been produced!");
        }

    }

}
