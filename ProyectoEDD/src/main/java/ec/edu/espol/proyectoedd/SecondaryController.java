package ec.edu.espol.proyectoedd;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class SecondaryController {
    
    @FXML
    private Button empezar;

    @FXML
    private void switchToPrimary() throws IOException {
        
    }
    @FXML
    void closeWindows() {
        try {
            FXMLLoader loader = new FXMLLoader ( getClass().getResource("primary.fxml"));
            Parent root = loader.load();
           
            
            Scene scene = new Scene (root);
            javafx.stage.Stage stage = new javafx.stage.Stage();
            
            stage.setScene(scene);
            stage.show();
            
            
            javafx.stage.Stage myStage = (javafx.stage.Stage) this.empezar.getScene().getWindow();
            myStage.close();
            
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (IOException ex) {
        }
    }
}