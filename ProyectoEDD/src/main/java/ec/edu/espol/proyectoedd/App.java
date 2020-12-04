package ec.edu.espol.proyectoedd;

import ec.edu.espol.clases.Data;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * JavaFX App
 */
public class App extends Application {
    
    private static Scene scene;
    

    @Override
    public void start(Stage stage) throws IOException {
<<<<<<< HEAD
        /*Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
=======
        
        Parent root = FXMLLoader.load(getClass().getResource("secondary.fxml"));
>>>>>>> 107eb9fdfca8729af4244ef26e89ec06e3553217
        
        Scene scene1 = new Scene (root);
        
        stage.setScene(scene1);
        stage.show();*/
        
        scene = new Scene(loadFXML("juego"));
        
        stage.setScene(scene);
        stage.show();
        
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    public static void setRoot(FXMLLoader fxmlLoader) throws IOException {
        scene.setRoot(fxmlLoader.load());
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}