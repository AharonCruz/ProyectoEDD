/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.clases.Persona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
//import tritonus-share.class ;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

//import javax.sound.AudioFormat;
/**
 * FXML Controller class
 *
 * @author F. Lopez
 */
public class JuegoController implements Initializable {

    
    @FXML
    private Pane fondo;
    @FXML
    private Button salir;
    @FXML
    private Button repetir;
    
    private final int radio=225;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //CENTRO DEL CIRCULO EN X=400 ; Y 235;    RADIO=225
        int n=12;
        System.out.println("inicia");
        // AudioInputStream audioInput;
        /*try{
        File musicPath=new File("ssss");
        if(musicPath.exists()){
            AudioInputStream audioInput=AudioSystem.getAudioInputStream(musicPath);
            Clip clip=AudioSystem.getClip();
        }
        else{
            System.out.println("F");
        }
        }
        catch(Exception e){
                System.out.println("F");
                }
        */
        double cont=0;
        for(int i=0;i<n;i++){
            Persona pt=new Persona(radio*Math.cos(Math.toRadians(cont)),radio*Math.sin(Math.toRadians(cont)));
            for(ImageView iv: pt.getEstado_v()){
                fondo.getChildren().add(iv);
            }
            cont+=360/n;
        }
        
        /*
        Image img=null; 
        try {
            img = new Image(new FileInputStream(Constantes.PERSONAMUERTA));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        ImageView imgView = new ImageView(img);
        imgView.setX(400);
        imgView.setY(235);
        imgView.setFitWidth(40.0);
        imgView.setFitHeight(60.0);
        fondo.getChildren().add(imgView);
        */
        Persona p1=new Persona();
        p1.setArma(true);
        p1.actualizarEstadov();
        for(ImageView iv: p1.getEstado_v()){
            fondo.getChildren().add(iv);
        }
        
        
    }    
    
    @FXML
    private void salida(MouseEvent event) {
        System.out.println("salgo");
    }

    @FXML
    private void rept(MouseEvent event) {
        System.out.println("repito");
    }

}
