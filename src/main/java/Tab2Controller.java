/*
  Represents tab 2 of the OOP production project.
  It gives format to the tab 2, initialize the comboBox with some values, and handles the recordProduction button event.

  @author Ronald Quiroz
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.util.Date;

@SuppressWarnings({"TryWithIdenticalCatches", "RedundantThrows"})
public class Tab2Controller extends Controller implements Initializable {

  @FXML
  private ComboBox<String> cmbQuantity;

  @FXML
  private ListView<Product> listView;

  /**
   * initialize the comboBox of tab 2 with some values.
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


  }

  @FXML
  protected void handleRecordProductionButtonAction(ActionEvent event) {
    //number from the comboBox. It says how many times the same productRecord will be print it.
    quantityProduced = Integer.parseInt(cmbQuantity.getValue());

    //The product selected is store in a variable.
    productSelected = listView.getSelectionModel().getSelectedItem();


    ArrayList<ProductionRecord> productionRun = new ArrayList<>();
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

    for (ProductionRecord p : productionRun) {
      productNum++;
      p.productionNumber = productNum;
    }


    addToProductionDB(productionRun);

  }

  public void addToProductionDB(ArrayList<ProductionRecord> record) {

    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/OOPdb";

    //  Database credentials
    final String USER = "";
    final String PASS = "";
    Connection conn;
    Statement stmt;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

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


        String insertSql = "INSERT INTO PRODUCTIONRECORD (PRODUCTION_NUM, PRODUCT_ID, serial_Num, DATE_PRODUCED)values(?,?,?,?)";

        PreparedStatement preparedStatement =
                conn.prepareStatement(insertSql);

                /*
                  insert the values read before in the database.
                 */
        //preparedStatement.setInt(1, idRan);
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

  public void loadProductionLog() throws SQLException {

    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/OOPdb";

    //  Database credentials
    final String USER = "";
    final String PASS = "";
    Connection conn;
    Statement stmt;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

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

        ProductionRecord productionRecordFromDB = new ProductionRecord(productNumber, id, serialNum, date) {
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
