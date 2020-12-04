/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.multimedia.Constantes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
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
        
        ArrayList<ImageView> lview=new ArrayList();
        double cont=0;
        for(int i=0;i<n;i++){
            
            System.out.println(i);
            FileInputStream inputstream=null; 
            try {
                inputstream = new FileInputStream(Constantes.PERSONAVIVA);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            Image image = new Image(inputstream); 
            ImageView imageView = new ImageView(image);
            imageView.setX(400+radio*Math.cos(Math.toRadians(cont)));
            System.out.println(radio*Math.cos(Math.toRadians(cont))+"-"+radio*Math.sin(Math.toRadians(cont)));
            imageView.setY(235+radio*Math.sin(Math.toRadians(cont)));
            imageView.setFitWidth(40.0);
            imageView.setFitHeight(60.0);
            lview.add(imageView);
            try {
                inputstream.close();
                //fondo.getChildren().add(imageView);
            } catch (IOException ex) {
                System.out.println("");
            }
            cont+=360/n;
        }
        System.out.println(lview.size());
        for(ImageView v: lview){
            fondo.getChildren().add(v);
        }
        
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
        
        /*
        img=null; 
        try {
            img = new Image(new FileInputStream(Constantes.ARMA));
            imgView = new ImageView(img);
            imgView.setX(415);
            imgView.setY(220);
            imgView.setFitWidth(60.0);
            imgView.setFitHeight(80.0);
            fondo.getChildren().add(imgView);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }*/
        
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
