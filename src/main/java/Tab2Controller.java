import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

/**
 * Represents tab 2 of the OOP production project.
 * It gives format to the tab 2, initialize the comboBox with some values,
 * loads the database products into the ListView.
 * and handles the recordProduction button event which add to the ProductionRecord database
 * from the product selected.
 *
 * @author Ronald Quiroz
 */
@SuppressWarnings({"TryWithIdenticalCatches", "RedundantThrows"})
public class Tab2Controller extends Controller implements Initializable {

  @FXML
  private ComboBox<String> cmbQuantity;

  @FXML
  private ListView<Product> listView;

  @FXML
  private Button recordButton;

  @FXML
  private Label productRecordMessage;

  /**
   * initialize the comboBox of tab 2 with some values.
   * loads the products from the database to the listView.
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

    //calls loadProductionLog which will load productionRecordDB into the textArea in tab3.
    try {
      loadProductionLog();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    //disables the record button until an Item is selected.
    recordButton.disableProperty()
            .bind(listView.getSelectionModel().selectedItemProperty().isNull());

  }

  /**
   * handles the action taken when the RecordProduction button is clicked.
   * takes the selected product and quantity and creates a productionRecord to be stored
   * in the database.
   *
   * @param event when clicked.
   */
  @FXML
  protected void handleRecordProductionButtonAction(ActionEvent event) {
    productionRun.clear();

    //number from the comboBox. It says how many times the same productRecord will be print it.
    quantityProduced = Integer.parseInt(cmbQuantity.getValue());

    //The product selected is store in a variable.
    productSelected = listView.getSelectionModel().getSelectedItem();

    //create an arrayList to store what will be added to the database ProductionRecord.
    //adds depending on the type of product selected, so the count can increase accordingly.
    if (productSelected.type.equals(ItemType.AUDIO)) {
      for (int i = 0; i < quantityProduced; i++) {
        countAU++;
        productionRun.add(new ProductionRecord(productSelected, countAU));
      }
    } else if (productSelected.type.equals(ItemType.VISUAL)) {
      for (int i = 0; i < quantityProduced; i++) {
        countVI++;
        productionRun.add(new ProductionRecord(productSelected, countVI));
      }
    } else if (productSelected.type.equals(ItemType.AUDIOMOBILE)) {
      for (int i = 0; i < quantityProduced; i++) {
        countAM++;
        productionRun.add(new ProductionRecord(productSelected, countAM));
      }
    } else {
      for (int i = 0; i < quantityProduced; i++) {
        countVM++;
        productionRun.add(new ProductionRecord(productSelected, countVM));
      }
    }

    //add productionRun to a new array in order to print it correctly.
    productionL.addAll(productionRun);

    //add the list to the database.
    addToProductionDB(productionRun);


    //indicates that there is a product selected.
    isThereAProductSelected = true;

    //reset the last product Recorded.
    lastAdded = "";

    //shows the message of success.
    productRecordMessage.setTextFill(Color.BLUE);
    productRecordMessage.setVisible(true);
  }

  /**
   * adds the selected product with the quantity to the database ProductionRecord.
   *
   * @param record and arrayList of type ProductionRecord filled with all the productionRecords
   *               to be added.
   */
  public void addToProductionDB(ArrayList<ProductionRecord> record) {

    final String jdbc_Driver = "org.h2.Driver";
    final String db_Url = "jdbc:h2:./res/OOPdb";

    //  Database credentials
    final String user = "";
    final String pass = "";
    Connection conn;
    Statement stmt;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(jdbc_Driver);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(db_Url, user, pass);

      //STEP 3: Execute a query
      stmt = conn.createStatement();

      /*
       takes the input from the user in tab 1 and stored
       so we can insert it to the database later.
      */
      int productNum;
      int productID;
      String serialNum;
      java.sql.Timestamp sqlDate;


      for (ProductionRecord p : record) {
        productNum = p.productionNumber;
        productID = p.productID;
        serialNum = p.serialNumber;
        sqlDate = new java.sql.Timestamp(p.dateProduced.getTime());


        String insertSql = "INSERT INTO PRODUCTIONRECORD (PRODUCTION_NUM, PRODUCT_ID, serial_Num,"
                + " DATE_PRODUCED)values(?,?,?,?)";

        PreparedStatement preparedStatement =
                conn.prepareStatement(insertSql);

        /*
          insert the values read before in the database.
        */
        preparedStatement.setInt(1, productNum);
        preparedStatement.setInt(2, productID);
        preparedStatement.setString(3, serialNum);
        preparedStatement.setTimestamp(4, sqlDate);


        preparedStatement.executeUpdate();
      }


      // STEP 4: Clean-up environment
      stmt.close();
      conn.close();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) {
      e.printStackTrace();
    }


  }

  /**
   * connects and reads from the database ProductionRecord.
   * creates an arrayList with the production records so it can be used later.
   */
  public void loadProductionLog() throws SQLException {

    final String jdbc_Driver = "org.h2.Driver";
    final String db_Url = "jdbc:h2:./res/OOPdb";

    //  Database credentials
    final String user = "";
    final String pass = "";
    Connection conn;
    Statement stmt;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(jdbc_Driver);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(db_Url, user, pass);

      //STEP 3: Execute a query
      stmt = conn.createStatement();

      String sql = "SELECT * FROM PRODUCTIONRECORD";


      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {

        // these lines correspond to the database table columns

        int productNumber = rs.getInt(1);

        int id = rs.getInt(2);

        String serialNum = rs.getString(3);

        Date date = rs.getTimestamp(4);

        // create object

        ProductionRecord productionRecordFromDB = new ProductionRecord(productNumber, id,
                serialNum, date) {
        };

        switch (serialNum.substring(3, 5)) {
          case "AU":
            countAU++;
            break;
          case "VI":
            countVI++;
            break;
          case "AM":
            countAM++;
            break;
          case "VM":
            countVM++;
            break;
          default:
            break;
        }


        productNum = productNumber;

        // save to ArrayList

        productionLog.add(productionRecordFromDB);

      }
      // STEP 4: Clean-up environment
      stmt.close();
      conn.close();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) {
      e.printStackTrace();
    }


  }


}
