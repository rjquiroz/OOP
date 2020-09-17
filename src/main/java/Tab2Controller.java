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

public class Tab2Controller implements Initializable {

    @FXML
    private ComboBox<String> cmbQuantity;

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

    }

    @FXML
    protected void handleRecordProductionButtonAction(ActionEvent event) {
        System.out.println("RecordProduction button pressed");
    }

}
