/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Ac 001
 */
public class SecundarioController implements Initializable {
    @FXML    
    Slider numPersonas;
    @FXML    
    CheckBox horario;
    @FXML    
    CheckBox antiHorario;
    @FXML    
    Button comenzar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
       
    }
    @FXML
    private void num(MouseEvent event){
        int numero=(int) numPersonas.getValue();
        System.out.println(numero);
    }
    
    @FXML
    private void checkAntiHorario(MouseEvent event){
       if(horario.isSelected()){
          horario.setSelected(false);
       }
    }
    
     @FXML
    private void checkHorario(MouseEvent event){
       if(antiHorario.isSelected()){
          antiHorario.setSelected(false);
       }
    }
    
    
}
