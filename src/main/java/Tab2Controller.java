import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;


public class Tab2Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resource) {


    }

    @FXML
    protected void handleRecordProductionButtonAction(ActionEvent event) {
        System.out.println("RecordProduction button pressed");
    }

}
