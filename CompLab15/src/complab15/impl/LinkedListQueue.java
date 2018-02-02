/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab15.impl;

import complab15.adt.Queue;

/**
 *
 * @author Lenovo
 */
public class LinkedListQueue<T> implements Queue<T> {
    private Node<T> front, back;
    private int size;
    
    public LinkedListQueue(){
        front = null;
        back = null;
        size = 0;
    }
    @Override
    public void enqueue(T value) {
        Node<T> newItem = new Node(value); 
        
        if(size == 0) {
            front = newItem;
            back = front;
        }else{
            back.setLink(newItem);
            back = newItem;            
        }
        size++;
    }

    @Override
    public T dequeue() throws Exception {
        if(size == 0) throw new Exception("queue is empty....");
        T result = front.getValue();
        if(size == 1) {
            front = null; back= null;
        } else front = front.getLink();
        size--;
        return result;
    }

    @Override
    public int getSize() {  
        return size;
    }

    @Override
    public void clear() {
        front = null;
        back = null;
        size = 0;
    }
    
    public String toString(){
        String result="front[ ";
        Node<T> current = front;
        while(current != null){
            result += current.getValue()+" ";
            current = current.getLink();
        }
        
        return result+"]back";
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    
}
