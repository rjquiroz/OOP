import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Controller {

        @FXML
    private Label lblOutput;

    public void sayHello() {
        lblOutput.setText("Hello FXML!");

         }

    @FXML private Text actiontarget;

    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Sign in button pressed");
    }


}