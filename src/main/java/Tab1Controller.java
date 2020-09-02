import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Tab1Controller implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resource) {

    }

    @FXML
    protected void handleAddProductButtonAction(ActionEvent event) {
        System.out.println("AddProduct button pressed");
    }

}
