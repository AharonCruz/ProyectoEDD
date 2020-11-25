/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.clases;

import ec.edu.espol.clases.ListIterator;
import java.util.Objects;

/**
 *
 * @author F. Lopez
 */
public class DoubleLinkedList<E> implements List<E>{
    
    private Nodo<E> first;
    private Nodo<E> last;
    private int capacity=0;
    
     public DoubleLinkedList(){
        first=null;
        last=null;
        capacity=0;        
    }
     
    @Override
    public boolean addFirst(E e) {
        Nodo <E> nn=new Nodo(e);
        if(this.isEmpty()){
            nn.setnext(first);
            first=nn;
            last=nn;
        }
        else{
            first.setprevious(nn);
            nn.setnext(first);
            first=nn;
        }
        capacity++;
        return true;
    }

    @Override
    public boolean addLast(E e) {
        Nodo <E> nn=new Nodo(e);
        if(this.isEmpty()){
            first=nn;
            last=nn;
        }
        else{
            nn.setprevious(last);
            last.setnext(nn);            
            last=nn;            
        }       
        capacity++;
        return true;
    
    }

    @Override
    public E removeFirst() {
         E conte=first.getcont();
        if(this.isEmpty())
            return first.getcont();
        first.getnext().setprevious(null);
        first=first.getnext();
        capacity--;        
        return conte;
    
    }

    @Override
    public E removeLast() {
        E conte=first.getcont();          
        if(capacity>1){
            last.getprevious().setnext(null);
        }
        capacity--;        
        return conte;    
    
    }

    @Override
    public int size() {
        return capacity; 
    }

    @Override
    public boolean isEmpty() {
        return capacity==0;
    }

    @Override
    public void clear() {
        first=null;
        last=null;
        capacity=0;  
    }

    @Override
    public ListIterator<E> listiterator() {
        ListIterator<E> it=new ListIterator<E>() {            
            Nodo<E> point=first;//puntero
            //con valor inicial first
            @Override
            public boolean hasNext() {
                return point!=null;
            }
            @Override
            public E next() {
                E valor=point.getcont();
                point=point.getnext();
                return valor;            
            }   
            /*@Override
            public boolean hasPrevious() {
                return point!=null;
            }*/
            @Override
            public E previous() {
                E valor=point.getcont();
                point=point.getprevious();
                return valor;            
            }   
            @Override
            public void set(E e){
                point.setcont(e);
            }
            @Override
            public void remove(){
                 Nodo <E> ant=point.getprevious();
                    point.getprevious().setnext(point.getnext());
                    point.getnext().setprevious(ant);
                
            }
    
            
            
        };
        return it;
    
    
    }

    @Override
    public void add(int index, E element) {
       if(index<=0)
            this.addFirst(element);        
        else if(index<capacity){
            int cont=0;
            Nodo<E> nn=new Nodo(element);
            for(Nodo<E> nv=first;nv!=null;nv=nv.getnext()){
                if(cont==index-1)    {
                    
                    nv.getnext().setprevious(nn);
                    
                    nv.setnext(nn);                                     
                    
                    nn.setnext(nv.getnext());                    
                    nn.setprevious(nv);

                }

                cont++;
            }
        }
        else
            this.addLast(element);
        capacity++;
    
    }

    @Override
    public E remove(int index) {
         E conte=first.getcont();
        
        if(index<=0){
            this.removeFirst();
            return conte;
        }
        else if(index<capacity){
            int cont=0;
           
            for(Nodo<E> nv=first;nv!=null;nv=nv.getnext()){
                if(cont==index-1)   {         
                    conte=nv.getnext().getcont();
                    
                    nv.getnext().getnext().setprevious(nv);
                    nv.setnext(nv.getnext().getnext());
                }                                   
                cont++;
            }
            capacity--;
            return conte;
        }
        else{
            this.removeLast();
            return null;
        }
    
    }
    @Override
    public String toString(){
        String cad="[";
        for(Nodo<E> nv=first;nv!=null;nv=nv.getnext()){ 
            if(!Objects.equals(null, nv.getcont()))
                cad=cad.concat(nv.getcont().toString()+",");
        }
        return cad.substring(0,cad.length()-1).concat("]");      
    }
    
}
