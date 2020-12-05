/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adria
 */
public class PrimarioController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Button btnRegistrarse;
    @FXML
    private Button btnIniciar;
    @FXML
    private TextField txtContraseña;
    @FXML
    private TextField txtUsuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registrarDatos(ActionEvent event) {
        
        String usuario = this.txtUsuario.getText();
        String contraseña = this.txtContraseña.getText();
       
    }

    @FXML
    private void iniciarJuego(ActionEvent event) throws IOException {
        
        String usuario = this.txtUsuario.getText();
        String contraseña = this.txtContraseña.getText();
        
        if(){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("secundario.fxml"));
            
            Parent root = loader.load();
            
            Scene scene = new Scene (root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
            /*stage.setOnCloseRequest(e -> controlador.closeWindows());*/
                    
        }else
       
    }
    
}
