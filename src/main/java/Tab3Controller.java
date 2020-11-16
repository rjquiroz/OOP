/*
  Represents tab 3 for the OOP production project.
  It gives format to tab 3, doesnt do anything yet.

  @author Ronald Quiroz
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class Tab3Controller extends Controller implements Initializable {

  public Button RefreshLog;
  @FXML
  private TextArea textArea;

  @Override
  public void initialize(URL location, ResourceBundle resource) {

    //couldn't figure out how to print the productionRecord to string here after the bottom was click.
    //so I prompt the user to refresh the by clicking the bottom, so that way once a product is added is
    //when we start productRecording.
    // textArea.setText("There have not been added any products. try refreshing! ");
    showProduction();


  }

  @FXML
  protected void handleRefreshLog(ActionEvent event) {
    int proNumber = productNum - quantityProduced + 1;

    switch (productSelected.type) {
      case AUDIO:
        countAU = countAU - quantityProduced;
        break;
      case VISUAL:
        countVI = countVI - quantityProduced;
        break;
      case AUDIOMOBILE:
        countAM = countAM - quantityProduced;
        break;
      case VISUALMOBILE:
        countVM = countVM - quantityProduced;
        break;
    }

    //create a new productionRecord and assign the correct count depending on type of the productSelected.
    ProductionRecord productProduced;
    for (int produceRecord = 1; produceRecord <= quantityProduced; produceRecord++) {

      if (productSelected.type.equals(ItemType.AUDIO)) {
        countAU++;
        productProduced = new ProductionRecord(productSelected, countAU);
      } else if (productSelected.type.equals(ItemType.VISUAL)) {
        countVI++;
        productProduced = new ProductionRecord(productSelected, countVI);
      } else if (productSelected.type.equals(ItemType.AUDIOMOBILE)) {
        countAM++;
        productProduced = new ProductionRecord(productSelected, countAM);
      } else {
        countVM++;
        productProduced = new ProductionRecord(productSelected, countVM);
      }
      productProduced.productionNumber = proNumber++;
      textArea.appendText(productProduced.toString() + "\n");
    }


  }

  public void showProduction() {


    for (ProductionRecord p : productionLog) {
      textArea.appendText(p.toString() + "\n");

    }


  }

}