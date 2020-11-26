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
    static public Map<String ,String > usuarios= new HashMap();

    @Override
    public void start(Stage stage) throws IOException {
     
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        Data.CargarArchivo();
        usuarios.forEach((k,v)-> System.out.println("Clave: " + k + " valor: "+ v));
        usuarios.put("Hola","Geronimo");
        Data.guardarArchivo();
        launch();
    }

}