/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab13.impl;
import  complab13.adt.Deque;

/**
 *
 * @author Lenovo
 */
public class LinkedListDeque<T> implements Deque<T> {
    private DoublyLinkedNode<T> front, back;
    private int size;
    
    public LinkedListDeque(){
        front = null;
        back = null;
        size = 0;
    }
    @Override
    public void pushToFront(T value) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode(value);
        
        if(size == 0){
            front = newNode;
            back = newNode;
        }else {
            newNode.setNext(front);
            front.setPrevious(newNode);
            front=newNode;            
        }
        
        size++;
        
    }

    @Override
    public void pushToBack(T value) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode(value);
        if(size == 0){
            front = newNode;
            back = newNode;
        }else {
            newNode.setPrevious(back);
            back.setNext(newNode);
            back=newNode;            
        }        
        size++;
    }

    @Override
    public T popFromFront() throws Exception {
        if(size == 0) throw new Exception("empty");
        T result = front.getValue();
        if(size == 1) {
            front = null; 
            back =null;
        } else{
            front = front.getNext();
            front.setPrevious(null);
        }
        size--;
        return result;
    }

    @Override
    public T popFromBack() throws Exception {
        if(size == 0) throw new Exception("empty");
        T result = back.getValue();
        if(size == 1) {
            front = null; 
            back =null;
        } else{
            back = back.getPrevious();
            back.setNext(null);
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
       back = null;
       size = 0;
    }
    
    public String toString(){
        String result = "front[ ";
        
        DoublyLinkedNode<T> current = front;
        while(current != null){
            result+=current.getValue()+" ";
            current = current.getNext();
        }
        
        return result+"]back";
                
    }
    

    
}
