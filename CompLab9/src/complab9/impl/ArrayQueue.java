/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab9.impl;

import complab9.adt.Queue;

/**
 *
 * @author Lenovo
 */
public class ArrayQueue<T> implements Queue<T> {
    private T[] values;
    private int size, front, back;
    
    public ArrayQueue(){
        values = (T[]) new Object[5];
        size = 0;
        front = -1;
        back = -1;
    }
    @Override
    public void enqueue(T value){
        int back_f = ((back +1)<values.length) ? back +1 : 0;
        
        if(back_f == front){
            T[] newAr = (T[]) new Object[size+5];
            for (int i=0; i<values.length; i++){                
                newAr[i] = values[front];
                front = (front+1<values.length) ? front+1 : 0;                
            }
            front=0;
            back = values.length;
            values = newAr;
            values[back] =  value;
            size++;
            
        } else{
            if(front<0) front++;
            values[back_f] = value;
            back = back_f;
            size++;
        }
        
    }

    @Override
    public T dequeue() throws Exception {
        if(size == 0) throw new Exception("queque is empty");
        T result = values[front];
        values[front] = null;
        size--;
        if(front == back) this.clear();
        
        front = (front+1)< values.length ? front+1 : 0;
        
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        values = (T[]) new Object[5];
        size = 0;
        front = -1;
        back = -1;
    }
    
    @Override
    public String toString(){        
        String result ="";
        int f = front;
        for(int i =0; i<size; i++) {
            result += String.valueOf(values[f])+" ";
            f = (f+1<values.length) ? f+1 : 0;   
        }
        
        return result;
    }
    
}
