/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.clases;

/**
 *
 * @author F. Lopez
 */
public class Nodo<E>{
    
    private E content;
    private Nodo<E> next;
    private Nodo<E> prev;
    
    public Nodo() {
        content=null;
        next=null;
        prev=null;
    }
    public Nodo(E cont) {
        content=cont;
        next=null;
        prev=null;
    }
    public Nodo(E cont, Nodo<E> n){
        content=cont;
        next =n;
    }
    public Nodo(E cont, Nodo<E> n,Nodo<E> p){
        content=cont;
        next =n;
        prev=p;
    }
    
    
    public Nodo<E> getnext(){
        return next;
    }
    public Nodo<E> getprevious(){
        return prev;
    }
    
    public E getcont(){
        return content;
    }
    public void setnext(Nodo<E> n){
        next=n;
    }
    public void setprevious(Nodo<E> p){
        prev=p;
    }
    
    public void setcont(E e){
        content=e;
    }
}
