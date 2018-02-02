/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab.impl;

import complab.adt.IntStack;

/**
 *
 * @author Lenovo
 */
public class ArrayIntStack implements IntStack {
    private int[] values;
    int size;
    public ArrayIntStack() {
        values = new int[10];
        size = 0;
    }
    
    @Override
    public void push(int value) {
       
        if(size == values.length) {
            int[] newArr = new int[size+10];
            for(int i=0; i<values.length; i++) newArr[i] = values[i];
            values = newArr;
        }
        values[size] = value;
        size++;
    }

    @Override
    public int pop() throws Exception {
        if (size == 0) throw new Exception("no item in the stack");
        int result = values[size-1];
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
       values = new int[10];
       size = 0;
    }
    
    
    @Override
    public String toString(){
        String result ="bottom["; 
        for(int i =0; i<size; i++) result += String.valueOf(values[i])+" ";
        result+="]front";
        return result;
    }
    
    
}
