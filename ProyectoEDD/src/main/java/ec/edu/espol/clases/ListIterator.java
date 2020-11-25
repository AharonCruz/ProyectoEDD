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
public interface ListIterator<E> {

    public boolean hasNext();
    public E next();
    //public boolean hasPrevious();
    public E previous();
    public void set(E e);
    public void remove();

}
