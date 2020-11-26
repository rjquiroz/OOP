import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

/**
 * Class that is used to control everything within the Tab1 'Product Line'.
 * It extends the main controller in which all tabs are located.
 * connects to the database and loads the products on the TableView.
 * can add products to the database as well.
 *
 * @author Ronald Quiroz
 */
@SuppressWarnings("ALL")
public class Tab1Controller extends Controller implements Initializable {

  //field where we write the name of the product.
  @FXML
  private TextField txtNameField;

  //field where we write the name of the manufacturer.
  @FXML
  private TextField txtManufacturerField;

  @FXML
  //label "product was successfully added!".
  private Label productAddedTxt;

  //choiceBox where we select the type of product.
  @FXML
  private ChoiceBox<String> chcType;

  //TableView where the list of products are going to be visible.
  @FXML
  private TableView<Product> tableView;

  //column on the table for the id of the product.
  @FXML
  private TableColumn<?, ?> productIdCol;

  //column on the table for the name of the product.
  @FXML
  private TableColumn<?, ?> productNameCol;

  //column on the table for the manufacturer of the product.
  @FXML
  private TableColumn<?, ?> manufacturerCol;

  //column on the table for the type of the product.
  @FXML
  private TableColumn<?, ?> productTypeCol;

  /**
   * This method does whatever happens as soon as the program starts.
   * add the ItemTypes to the choiceBox.
   * assign the colums to the tableView.
   * opens the date base to load the products already created to the tableView.
   */
  @Override
  public void initialize(URL location, ResourceBundle resource) {
    //add the ItemType to the choiceBox in the first tab.
    for (ItemType it : ItemType.values()) {
      chcType.getItems().add(it + " " + it.code);
    }
    chcType.getSelectionModel().selectFirst();

    //instantiate the productLine List.
    productLine = FXCollections.observableArrayList();

    //set the column values of the tableView.
    productIdCol.setCellValueFactory(new PropertyValueFactory("id"));
    productNameCol.setCellValueFactory(new PropertyValueFactory("name"));
    manufacturerCol.setCellValueFactory(new PropertyValueFactory("Manufacturer"));
    productTypeCol.setCellValueFactory(new PropertyValueFactory("type"));

    //loads the products from the database.
    try {
      loadProductList();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    //assign the values from the list to the table.
    tableView.setItems(productLine);

  }

  /**
   * handles the event of the AddProduct button by adding the product to the database PRODUCT.
   * Also, loads the database once more so the list of products in the TableView is updated.
   *
   * @param event when clicked.
   */
  @FXML
  protected void handleAddProductButtonAction(ActionEvent event) throws SQLException {
    //print the appropiate message for each possible input.
    if (txtNameField.getText().equals("") && txtManufacturerField.getText().equals("")) {
      productAddedTxt.setTextFill(Color.RED);
      productAddedTxt.setText("Name and manufacturer must be filled!");
      productAddedTxt.setLayoutX(240.0);
      productAddedTxt.setVisible(true);
    } else if (txtNameField.getText().equals("")) {
      productAddedTxt.setTextFill(Color.RED);
      productAddedTxt.setText("The name of the product is missing!");
      productAddedTxt.setLayoutX(255.0);
      productAddedTxt.setVisible(true);
    } else if (txtManufacturerField.getText().equals("")) {
      productAddedTxt.setTextFill(Color.RED);
      productAddedTxt.setText("The manufacturer of the product is missing!");
      productAddedTxt.setLayoutX(217.0);
      productAddedTxt.setVisible(true);
    } else {
      //make the label visible when the button is clicked.
      productAddedTxt.setText("The product was successfully added!");
      productAddedTxt.setTextFill(Color.BLUE);
      productAddedTxt.setVisible(true);

      //insert added product to the database.
      connectToDb();

      //loads the database into the tableView.
      loadProductList();

      //set all the fields to its default state and selected the product that was added.
      txtNameField.setText("");
      txtManufacturerField.setText("");
      chcType.getSelectionModel().selectFirst();
      tableView.getSelectionModel().selectLast();
    }
  }

  /**
   * method that loads the database into the tableView on tab1
   * connects to the database, select the products from it and then load it into
   * a observable list that is going to the tableView.
   */
  public void loadProductList() throws SQLException {

    final String jdbc_Driver = "org.h2.Driver";
    final String db_Url = "jdbc:h2:./res/OOPdb";

    //  Database credentials
    final String user = "";
    final String pass = "";
    Connection conn = null;
    Statement stmt = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(jdbc_Driver);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(db_Url, user, pass);

      //STEP 3: Execute a query
      stmt = conn.createStatement();

      String sql = "SELECT * FROM PRODUCT";


      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {

        // these lines correspond to the database table columns

        int id = rs.getInt(1);

        String name = rs.getString(2);

        String type = rs.getString(3);
        ItemType realType = ItemType.AUDIO;
        switch (type) {
          case "AUDIO AU":
            realType = ItemType.AUDIO;
            break;
          case "VISUAL VI":
            realType = ItemType.VISUAL;
            break;
          case "AUDIOMOBILE AM":
            realType = ItemType.AUDIOMOBILE;
            break;
          case "VISUALMOBILE VM":
            realType = ItemType.VISUALMOBILE;
            break;
          default:
            realType = ItemType.AUDIO;
            break;
        }

        String manufacturer = rs.getString(4);

        // create object

        Product productFromDB = new Product(id, name, manufacturer, realType) {
        };

        // save to observable list

        productLine.add(productFromDB);
        productsDB.add(productFromDB);
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
   * makes the connection to the database PRODUCT.
   * reads the user input and add it to the database.
   * and prints the list of database to the console.
   */
  @edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"ODR_OPEN_DATABASE_RESOURCE",
          "OBL_UNSATISFIED_OBLIGATION"})
  public void connectToDb() {

    final String jdbc_Driver = "org.h2.Driver";
    final String db_Url = "jdbc:h2:./res/OOPdb";

    //  Database credentials
    final String user = "";
    final String pass = "";
    Connection conn = null;
    Statement stmt = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(jdbc_Driver);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(db_Url, user, pass);

      //STEP 3: Execute a query
      stmt = conn.createStatement();


      //takes the input from the user in tab 1 and stored
      //so we can insert it to the database later.
      String txtName = txtNameField.getText();
      String txtManu = txtManufacturerField.getText();
      String txtType = chcType.getValue();

      String insertSql = "INSERT INTO PRODUCT (name, type, manufacturer)values(?,?,?)";

      PreparedStatement preparedStatement =
              conn.prepareStatement(insertSql);


      //insert the values read before in the database.
      preparedStatement.setString(1, txtName);
      preparedStatement.setString(2, txtType);
      preparedStatement.setString(3, txtManu);

      preparedStatement.executeUpdate();

      String sql = "SELECT id, name, type, manufacturer\n" + "FROM product\n";


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
