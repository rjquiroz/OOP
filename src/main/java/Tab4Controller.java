import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;


/**
 * Represents tab 4 for the OOP production project.
 * It gives format to tab 4 with a sign in tab.
 * Employees will write their full name and password and it will assign
 * the username and Email to them.
 * Has a sign in button which will check if the name and password are valid.
 *
 * @author Ronald Quiroz
 */
public class Tab4Controller extends Controller implements Initializable {

  @FXML
  private TextField txtName;

  @FXML
  private TextField txtPassword;

  @FXML
  private Label helpMessage;

  @FXML
  private Label fillInMessage;

  @FXML
  private Button signInButton;

  /**
   * initialize the tab4.
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {


  }

  /**
   * handles the signIn button action. takes the full name and password given by the Employee
   * and checks if they are valid to assign a proper username, email, and password.
   *
   * @param event when clicked.
   */
  @FXML
  protected void handleSignInButton(ActionEvent event) {
    String name = txtName.getText();
    String password = txtPassword.getText();

    if (name.equals("") && password.equals("")) {
      fillInMessage.setText("Both name and password are missing!");
      fillInMessage.setVisible(true);
    } else if (password.equals("")) {
      fillInMessage.setText("Password is missing!");
      fillInMessage.setVisible(true);
    } else if (name.equals("")) {
      fillInMessage.setText("Full Name is missing!");
      fillInMessage.setVisible(true);
    } else {
      Employee employee = new Employee(name, password);
      fillInMessage.setVisible(false);
      JOptionPane.showMessageDialog(null, employee.toString());
      txtName.setText("");
      txtPassword.setText("");
    }

  }

  /**
   * handles the help button action.
   * Displays text with instructions.
   *
   * @param event when clicked.
   */
  @FXML
  protected void handleHelpButton(ActionEvent event) {
    helpMessage.setVisible(true);
  }

}