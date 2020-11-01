/**
 * Represents tab 3 for the OOP production project.
 * It gives format to tab 3, doesnt do anything yet.
 *
 * @author Ronald Quiroz
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class Tab3Controller extends Tab2Controller implements Initializable {

    @FXML
    private TextArea textArea;

    @Override
    public void initialize(URL location, ResourceBundle resource) {

        //couldn't figure out how to print the productionRecord to string here after the bottom was click.
        //so I prompt the user to refresh the by clicking the bottom, so that way once a product is added is
        //when we start productRecording.
        textArea.setText("There have not been added any products. try refreshing! ");


    }

    @FXML
    protected void handleRefreshLog(ActionEvent event) {
        //index so I can increase it by 1 as the for loop goes by each product of the list.
        //that way for each product I can have a diff. number to produce even if in an ArrayList.
        int index = 0;
        //to reset the textArea so the initial prompt is there anymore.
        textArea.setText(" ");

        //goes over each product selected in the Array and prints its results.
        for (Product p : productSelected) {
            ProductionRecord productProduced = new ProductionRecord(p, num.get(index));
            textArea.appendText(productProduced.toString() + "\n");
            index++;
        }
    }

}