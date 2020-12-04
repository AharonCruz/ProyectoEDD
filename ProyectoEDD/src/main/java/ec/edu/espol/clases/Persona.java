/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.clases;

import ec.edu.espol.multimedia.Constantes;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author F. Lopez
 */
public class Persona extends Rectangle {

    private Image apariencia;
    private boolean vivo;
    private boolean armado;

    public Persona() {
        apariencia = new Image(Constantes.PERSONAVIVA);
        vivo = true;
        armado = false;

    }

    public Persona apuntar(DoubleLinkedList<Persona> grupo, int orientacion) {
        Persona personaApuntada;
         Persona estaPersona;
        ListIterator<Persona> iterator = grupo.listiterator();
        
        if(grupo.size()==1){
            return this;
        }

        while (iterator.hasNext()) {
            switch (orientacion) {
                case 1:
                    estaPersona= iterator.next();
                    if(estaPersona.equals(this)){
                    for(int i=0; i< grupo.size(); i++){
                        personaApuntada=iterator.next();
                        if(personaApuntada.isAlive()){
                            return personaApuntada;
                        }
                    }
                    }
                    break;
                case -1:
                    estaPersona= iterator.previous();
                    if(estaPersona.equals(this)){
                    for(int i=0; i< grupo.size(); i++){
                        personaApuntada=iterator.previous();
                        if(personaApuntada.isAlive()){
                            return personaApuntada;}
                    }
                    }
                    break;
                default:
                    System.out.println("1 para sentido horario, -1 para sentido anti horario");
                    break;
            }
        }

        return null;
    }
    
    public void matar(Persona objetivo){
        objetivo.vivo=false;
        objetivo.apariencia=new Image(Constantes.PERSONAMUERTA);
    }
    
    public void pasarArma(Persona persona){
        this.armado=false;
        persona.armado=true;
    }

    public Image getApariencia() {
        return apariencia;
    }

    public void setApariencia(Image apariencia) {
        this.apariencia = apariencia;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public boolean isArmado() {
        return armado;
    }

    public void setArmado(boolean armado) {
        this.armado = armado;
    }
    
    public boolean isAlive(){
        return vivo;
    }

}
