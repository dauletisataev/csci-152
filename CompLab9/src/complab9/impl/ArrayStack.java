package complab9.impl;

import java.util.Arrays;
import complab9.adt.Stack;

/**
 *
 * @author Lenovo
 */
public class ArrayStack<T> implements Stack<T> {
    private T[] values;
    int size;
    public ArrayStack() {
        values = (T[]) new Object[10];
        size = 0;
    }
    
    @Override
    public void push(T value) {
        if(size == values.length) values = Arrays.copyOf(values, size+10);
        values[size] = value;
        size++;
    }

    @Override
    public T pop() throws Exception {
        if (size == 0) throw new Exception("no item in the stack");
        T result = values[size-1];
        size--;
        values = Arrays.copyOf(values, size);
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
       values = (T[]) new Object[10];
       size = 0;
    }
    
    @Override
    public String toString(){
        String result ="";
        for(int i =0; i<size; i++) result += String.valueOf(values[i])+" ";
        
        return result+" and size:"+getSize();
    }
    
    
}
