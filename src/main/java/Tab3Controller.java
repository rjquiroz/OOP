import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * Represents tab 3 for the OOP production project.
 * It gives format to tab 3 with a production Log textBox.
 * Every single product that was produced will be found here.
 * Has a refresh button to refresh the tab.
 *
 * @author Ronald Quiroz
 */
public class Tab3Controller extends Controller implements Initializable {

  @FXML
  private Label noChangesMessage;

  @FXML
  private TextArea textArea;

  @FXML
  private Button refreshLog;

  /**
   * initialize the textBox with products that have been produced before.
   */
  @Override
  public void initialize(URL location, ResourceBundle resource) {

    //loads and appends from the RecordProduct database to textBox.
    showProduction();
  }

  /**
   * happens when the Refresh button is clicked.
   * gets data from the array created in tab2 and used to create a a new productionRecord
   * that will be append to the textBox.
   *
   * @param event when clicked.
   */
  @FXML
  protected void handleRefreshLog(ActionEvent event) {
    if (isThereAProductSelected) {
      //hides the message label.
      noChangesMessage.setVisible(false);

      if (lastAdded.equals("")) {

        //prints every new productionRecord to the textBox.
        for (ProductionRecord p : productionL) {
          textArea.appendText(p.toString() + "\n");
        }
        //clear the array so doesnt repeat itself.
        productionL.clear();

      } else {
        //makes the message visible if there are no changes.
        noChangesMessage.setVisible(true);
      }
    } else {
      //makes the message visible if there are no changes.
      noChangesMessage.setVisible(true);
    }
  }

  /**
   * adds the array that was filled from the database of ProductionRecord to the textBox.
   */
  public void showProduction() {

    for (ProductionRecord p : productionLog) {
      textArea.appendText(p.toString() + "\n");

    }


  }

}