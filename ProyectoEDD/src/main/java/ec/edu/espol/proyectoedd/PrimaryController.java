package ec.edu.espol.proyectoedd;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PrimaryController {

    @FXML
    private Button regresar;
    private Button iniciar;

    
    
    PrimaryController Primarycontroller;
    
    
    
    @FXML
    private void Iniciar(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader ( getClass().getResource("secondary.fxml"));
        Parent root = loader.load();
        
        SecondaryController controlador = loader.getController();
        
        Scene scene = new Scene (root);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.show();
        
        stage.setOnCloseRequest(e -> controlador.closeWindows());
        
        Stage myStage = (Stage) this.iniciar.getScene().getWindow();
        myStage.close();
        
        
        
        
        //SecondaryControllerInstancia.recibeparametros(Primarycontroller, txt_secondarycontroller.getText());
        //label.setText("Texto que se recibe de secondarycontroller");
        //Scene scene = new Scene(root);
        //secondarycontroller.getScene(scene);
        //secondarycontroller.alwaysOnTopProperty();
        //secondarycontroller.initModality(Modality.APPLICATION_MODAL);
        //secondarycontroller.show();
        
    }

    private Stage Stage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
