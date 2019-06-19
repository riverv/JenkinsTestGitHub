package kojinenshu.puzzle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

   public static void main(String[] args) throws Exception {
        launch(args);
   }

   public void start(Stage stage) throws Exception {


        String doPuzzle = "/fxml/puzzle.fxml";

        FXMLLoader loader = new FXMLLoader();

        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(doPuzzle));

        Scene scene = new Scene(rootNode, 800, 500);
        scene.getStylesheets().add("/styles/puzzleStyle.css");
//Jenkins test test
        stage.setTitle("15Puzzle");
        stage.setScene(scene);
        stage.show();
   }
}
