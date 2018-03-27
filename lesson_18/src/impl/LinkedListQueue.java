/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import adt.Queue;
import adt.Set;



/**
 *
 * @author Lenovo
 */
public class LinkedListQueue<T> implements Queue<T> {
    private Node<T> front;
    private Node<T> back;
    private int size;
    
    public LinkedListQueue(){
        front = null;
        back=null;
        size = 0;
    }
    @Override
    public void enqueue(T value) {
        Node<T> newBack = new Node(value);
        if(size==0) {
           
            front=newBack;
            back=newBack;
        }
        else {
            back.setLink(newBack);
            back=newBack; 
        }
        size++;
    }

    @Override
    public T dequeue() throws Exception {
       if (size == 0) throw new Exception("Queue is empty");
       T result = front.getValue(); 
       if (size == 1){ front =null; back=null;}
       else{
        front=front.getLink();
       }
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
        back=null;
        size = 0;
    }
    
    public String toString(){
        String result = "";
        Node<T> current = front;
        while(current!=null){
            result += current.getValue()+",";
            current = current.getLink();
        }
        return result+"\n";
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    
    
}
