/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controllers;

import ec.edu.espol.clases.DoubleLinkedList;
import ec.edu.espol.clases.Hilo;
import ec.edu.espol.clases.ListIterator;
import ec.edu.espol.clases.Persona;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    DoubleLinkedList<Persona> pers=new DoubleLinkedList();//TOdas las personas
    ArrayList<ArrayList<Node>> dirs=new ArrayList();//Todas las direcciones de memoria de los elementos de cada persona separado por sublistas
    private final int radio=225;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //CENTRO DEL CIRCULO EN X=400 ; Y 235;    RADIO=225
        int n=12;
        System.out.println("inicia");
        //AudioInputStream audioInput;
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
            pers.addLast(pt);
            ArrayList<Node> atris=new ArrayList();//ArrayList con todos los componentes de la persona que se agregan al contenedor
            for(ImageView iv: pt.getEstado_v()){
                fondo.getChildren().add(iv);   //Agrego el contenido visual de la persona             
                atris.add(fondo.getChildren().get(fondo.getChildren().size()-1));
            }
            dirs.add(atris);
            cont+=360/n;
        }

        
    }    
    
    public static void Sleep(int t){
        try{
            Thread.sleep(t);
        }
        catch (Exception e){
            
        }
    }
    
    private void actualizarAp(int pos){
        
        
        
        Persona pert=pers.get(pos);
        int tamprev=2;
        for(int i=0;i<pert.getEstado_v().size();i++){
            tamprev+=dirs.get(i).size();
        }
        fondo.getChildren().removeAll(dirs.get(pos));
        pert.setVida(false);
        pert.actualizarEstadov();
        dirs.get(pos).clear();
        ArrayList<Node> atris=new ArrayList();
        for(ImageView iv: pert.getEstado_v()){
            fondo.getChildren().add(tamprev,iv);
            atris.add(fondo.getChildren().get(tamprev));
            }
        dirs.get(pos).addAll(atris);
        
        }
        
        
    public static void pausar(long timeInMilliSeconds) {

    long timestamp = System.currentTimeMillis();

        do {
        } while (System.currentTimeMillis() < timestamp + timeInMilliSeconds);
        
    }
    
    
    @FXML
    private void salida(MouseEvent event) {   
        System.out.println("salgo");
    }

    @FXML
    private void rept(MouseEvent event) {
        
        //int pos=0;
  
       // for(int pos=0;pos<6;pos++)   {              
           //pausar(2000);
       //    actualizarAp(pos);
       // }
       ListIterator<Persona> iterador= pers.listiterator();
       pers.get(0).setArma(true);
       int cont=0;
       //Persona primero= iterador.next();
       
       while(cont< pers.size()-2){
           Persona persona= iterador.next();
           if(persona.seleccionarPersona(pers, 1) != null){
            persona.matar(persona.seleccionarPersona(pers, 1));
            persona.pasarArma(persona.seleccionarPersona(pers, 1));
           }
          
       }
        System.out.println("final");
        
    }
}
