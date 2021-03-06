/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.clases;

import ec.edu.espol.multimedia.Constantes;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author F. Lopez
 */
public class Persona {

    //dimensiones persona 40x60, 
    //dimensiones arma 60x80  ;X+=15      Y-=15      
    //dimensiones MIRA 90x100  ;X-=25      Y-=25
    //CENTRO DEL CIRCULO EN X=400 ; Y 235;    RADIO=225
    Image apariencia;
    ImageView vista;
    boolean vivo;
    boolean armado;
    boolean apuntado;
    double posx = 400;
    double posy = 235;
    ArrayList<ImageView> estado_v = new ArrayList();

    public Persona() {
        vivo = true;
        armado = false;
        apuntado = false;
        actualizarEstadov();

    }

    public Persona(double x, double y) {
        vivo = true;
        armado = false;
        apuntado = false;
        posx += x;
        posy += y;
        actualizarEstadov();
    }

    public ArrayList<ImageView> getEstado_v() {
        return this.estado_v;
    }

    public boolean isArmado() {
        return armado;
    }

    public boolean isVivo() {
        return vivo;
    }
     public boolean isPointed() {
        return apuntado;
    }

    public void setVida(boolean b) {
        vivo = b;
    }

    public void setArma(boolean b) {
        armado = b;
    }

    public void setBlanco(boolean b) {
        apuntado = b;

    }

    public void actualizarEstadov() {

        try {

            estado_v.clear();
            Image img;
            ImageView imgView;
            ///CREO/ACTUALIZO LA IMAGEN DE LA PERSONA
            if (this.vivo) {
                img = new Image(new FileInputStream(Constantes.PERSONAVIVA));
            } else {
                img = new Image(new FileInputStream(Constantes.PERSONAMUERTA));
                armado = false;
                apuntado = false;
            }
            imgView = new ImageView(img);
            imgView.setX(posx);
            imgView.setY(posy);
            imgView.setFitWidth(40.0);
            imgView.setFitHeight(60.0);
            estado_v.add(imgView);
            if (this.apuntado) {
                img = new Image(new FileInputStream(Constantes.MIRA));
                imgView = new ImageView(img);
                imgView.setX(posx - 25);
                imgView.setY(posy - 25);
                imgView.setFitWidth(90.0);
                imgView.setFitHeight(100.0);
                estado_v.add(imgView);
            }
            if (this.armado) {
                img = new Image(new FileInputStream(Constantes.ARMA));
                imgView = new ImageView(img);
                imgView.setX(posx + 15);
                imgView.setY(posy - 15);
                imgView.setFitWidth(60.0);
                imgView.setFitHeight(80.0);
                estado_v.add(imgView);
            }
        } catch (Exception ex) {
            System.out.println("");;
        }

    }

    public Persona seleccionarPersona(DoubleLinkedList<Persona> grupo, int orientacion) {
        Persona personaApuntada;
        Persona estaPersona;
        ListIterator<Persona> iterator = grupo.listiterator();

        if (grupo.size() == 1) {
            return this;
        }
            switch (orientacion) {
                case 1:
                    if (this.isVivo() && this.isArmado()) {
                      int pos= grupo.getindex(this);
                        System.out.println(pos);
                     for( int i= (pos+1);i<grupo.size();i++){
                         if( grupo.get(i).isVivo()){
                             System.out.println("Se apunta a :" + i +".era persona ");
                             return grupo.get(i);
                             
                         }else{
                               System.out.println(i + "esta muerto");
                         }if(i==grupo.size()-1){
                             i=-1;
                         }
                     }
                     
                    }else{
                    }

                    break;
                case -1:
                    
                    estaPersona = iterator.previous();
                    if(estaPersona.isVivo()){
                        if (estaPersona.equals(this)) {
                        for (int i = 0; i < grupo.size(); i++) {
                            personaApuntada = iterator.previous();
                            if (personaApuntada.isVivo()) {
                                System.out.println("persona en indice :" + i + " apuntada");
                                return personaApuntada;
                            }
                        }
                    }   
                    }
                    
                    break;
                default:
                    System.out.println("1 para sentido horario, -1 para sentido anti horario");
                    break;
            }
        

        return null;
    
}

    public void matar(Persona objetivo) {
        objetivo.setVida(false); 
        System.out.println("se ha matado a :"+ objetivo);
        //objetivo.apariencia = new Image(Constantes.PERSONAMUERTA);
    }

    public void pasarArma(Persona persona) {
        this.armado = false;
        persona.armado = true;
        System.out.println("se ha entregado a :"+ persona);
    }

    public Image getApariencia() {
        return apariencia;
    }

    public void setApariencia(Image apariencia) {
        this.apariencia = apariencia;
    }
    
    
    public boolean equals(Persona p){
        return (this.posx == p.posx) && (this.posy== p.posy);
         
    }
    @Override
    public String toString(){
        return "Pos en x :"+this.posx +" Pos en y :" +this.posy+" Esta vivo: "+ this.isVivo() ;
    }
}
