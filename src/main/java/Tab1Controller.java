/**
 * Represents tab 1 of the OOP production project.
 * It gives format to the tab 1 and connects the database 'PRODUCT' to it as well as inserts products to it..
 *
 * @author Ronald Quiroz
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class Tab1Controller implements Initializable {

    @FXML
    private TextField txtNameField;

    @FXML
    private TextField txtManufacturerField;

    @FXML
    private ChoiceBox<String> chcType;

    /**
     * initialize choiceBox with some values.
     */
    @Override
    public void initialize(URL location, ResourceBundle resource) {
        //add the ItemType to the choiceBox in the first tab.
        for (ItemType it : ItemType.values()) {
            chcType.getItems().add(it + " " + it.code);
        }
        chcType.getSelectionModel().selectFirst();


    }

    /**
     * handles the event of the AddProduct button by adding the product to the database PRODUCT.
     */
    @FXML
    protected void handleAddProductButtonAction(ActionEvent event) {
        connectToDb();

    }

    /**
     * makes the connection to the database PRODUCT
     * reads the user input and add it to the database
     * and prints the list of database to the console
     */
    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"ODR_OPEN_DATABASE_RESOURCE", "OBL_UNSATISFIED_OBLIGATION"})
    public void connectToDb() {

        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./res/OOPdb";

        //  Database credentials
        final String USER = "";
        final String PASS = "";
        Connection conn = null;
        Statement stmt = null;

        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            stmt = conn.createStatement();

            /**
             * Creates a random number between 1-100 and assign id to it
             * so each product added has an ID and the database can be sorted.
             */
            //double randNumber = Math.random();
            //int idRan = (int) (randNumber * 100) + 1;

            /**
             * takes the input from the user in tab 1 and stored
             * so we can insert it to the database later.
             */
            String txtId = txtNameField.getText();
            String txtManu = txtManufacturerField.getText();
            String txtType = chcType.getValue();

            String insertSql = "INSERT INTO PRODUCT (name, type, manufacturer)values(?,?,?)";

            PreparedStatement preparedStatement =
                    conn.prepareStatement(insertSql);

            /**
             * insert the values read before in the database.
             */
            //preparedStatement.setInt(1, idRan);
            preparedStatement.setString(1, txtId);
            preparedStatement.setString(2, txtType);
            preparedStatement.setString(3, txtManu);

            preparedStatement.executeUpdate();

            String sql = "SELECT id, name, type, manufacturer\n" +
                    "FROM product\n";

            System.out.println("The list of the products on the database so far is: ");

            ResultSet rs = stmt.executeQuery(sql);
            /**
             * Prints the entire database to the system console.
             */
            while (rs.next()) {
                //rs.next();
                String prdId = rs.getString(1);
                String prdName = rs.getString(2);
                String prdType = rs.getString(3);
                String prdManu = rs.getString(4);
                System.out.println(prdId + " " + prdName + " " + prdType + " " + prdManu);

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
