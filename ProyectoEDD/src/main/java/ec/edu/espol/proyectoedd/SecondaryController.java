package ec.edu.espol.proyectoedd;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SecondaryController implements Initializable{
    
    
    @FXML
    private Button btnEmpezar;
    @FXML
    private TextField txtJugadores;
    
    public void closeWindows() {
        try {
            FXMLLoader loader = new FXMLLoader ( getClass().getResource("primary.fxml"));
            Parent root = loader.load();
           
            
            Scene scene = new Scene (root);
            javafx.stage.Stage stage = new javafx.stage.Stage();
            
            stage.setScene(scene);
            stage.show();
            
            
            javafx.stage.Stage myStage = (javafx.stage.Stage) this.btnEmpezar.getScene().getWindow();
            myStage.close();
            
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (IOException ex) {
        }
    }

    @FXML
    private void empezarJuego(ActionEvent event) {
    }

    @FXML
    private void numeroJugadores(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}