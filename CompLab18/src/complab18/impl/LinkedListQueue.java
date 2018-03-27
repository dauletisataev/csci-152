/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab18.impl;

import complab18.adt.Queue;

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
        String result="[";
        Node<T> current = front;
        while(current != null){
            result += current.getValue()+" ";
            current = current.getLink();
        }
        
        return result+"]";
    } 
    
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(T value) {
        T temp;
        int size = getSize();
        for (int i = 0; i < size; i++) {
            try {
                temp = dequeue();
                enqueue(temp);                
                if(temp == value){
                    return true;
                }
            } catch (Exception e) {
                System.out.println("Error has occured");
            }
        }
        return false;
        
    }

    @Override
    public boolean remove(T value) {
        if(!contains(value))return false;
        
        T temp;
        int size = getSize();
        for (int i = 0; i < size; i++) {
            try {
                temp = dequeue();

                if(temp == value){
                    return true;
                }
                enqueue(temp);                

            } catch (Exception e) {
                System.out.println("Error has occured");
            }
        }        
        
        return false;
        
    }
    
}
