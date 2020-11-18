import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.text.Text;

/**
 * Represents the controller of the main window of the program.
 *
 * @author Ronald Quiroz
 */
public class Controller {

  public Tab tab1;
  public Tab tab2;
  public Tab tab3;

  //list to add the products and show them in the tableview and listView
  public static ObservableList<Product> productLine;

  //A variable to store the product selected from the list view.
  public static Product productSelected = new Widget();

  //the value selected in the comboBox tab2
  public static int quantityProduced = 0;

  //counters used to follow the count of different types for the serial number.
  public static int countAU = 0;
  public static int countVI = 0;
  public static int countAM = 0;
  public static int countVM = 0;

  //counter to follow the production count.
  public static int productNum = 1;

  //arrayList that is used to add to the database PRODUCTIONRECORD.
  public static final ArrayList<ProductionRecord> productionLog = new ArrayList<>();


  @FXML
  private Text actiontarget;

  @FXML
  protected void handleSubmitButtonAction(ActionEvent event) {
    actiontarget.setText("Sign in button pressed");
  }


}