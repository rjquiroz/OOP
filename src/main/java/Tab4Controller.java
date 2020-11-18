import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Tab4Controller extends Controller implements Initializable {

  @FXML
  private TextField txtName;

  @FXML
  private TextField txtPassword;

  @FXML
  private Button signInButton;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }

  @FXML
  protected void handleSignInButton(ActionEvent event) {
    String name = txtName.getText();
    String password = txtPassword.getText();

    Employee employee = new Employee(name, password);
    System.out.println(employee.toString());
  }


}