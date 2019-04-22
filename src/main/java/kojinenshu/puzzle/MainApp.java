package kojinenshu.puzzle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {

//        log.info("Starting Hello JavaFX and Maven demonstration application");

        String doPuzzle = "/fxml/puzzle.fxml";
        //log.debug("Loading FXML for main view from: {}", fxmlFile);

        FXMLLoader loader = new FXMLLoader();

        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(doPuzzle));

       // log.debug("Showing JFX scene");
        Scene scene = new Scene(rootNode, 800, 500);
        scene.getStylesheets().add("/styles/puzzleStyle.css");

        stage.setTitle("Hello JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }
}
