/**
 * Represents main class for the OOP production project.
 * It creates the initial window.
 *
 * @author Ronald Quiroz
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene scene = new Scene(root, 605, 400);

        primaryStage.setTitle("OOP Production Project");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
