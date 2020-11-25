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
public interface List<E> {
    


    public boolean addFirst(E e);

    public boolean addLast(E e);

    public E removeFirst();

    public E removeLast(); 

    public int size();

    public boolean isEmpty();

    public void clear();
    public ListIterator<E> listiterator();
    public void add(int index, E element);
    public E remove(int index);

}
