/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab18.impl;

import complab18.adt.Set;

/**
 *
 * @author Lenovo
 */
public class LLQHashTableSet<T> implements Set<T> {
    private LinkedListQueue<T>[] buskets;
    private int size;

    public LLQHashTableSet(int a){
        buskets=new LinkedListQueue[a];
        size=0;
    }       
    
    @Override
    public void add(T value) {
        int ind = Math.abs(value.hashCode()) % buskets.length;
        
        if(!contains(value)){
            if(buskets[ind] == null){
                buskets[ind] = new LinkedListQueue();
                buskets[ind].enqueue(value);
            }else {
                buskets[ind].enqueue(value);
            }
            size++;
        }
    }

    @Override
    public boolean contains(T value) {
        int ind = Math.abs(value.hashCode()) % buskets.length;
        
        if(buskets[ind] == null) return false;    
        
        return buskets[ind].contains(value);
    }

    @Override
    public boolean remove(T value) {
        if(!contains(value)) return false;
        
        int ind = Math.abs(value.hashCode()) % buskets.length;
        
        size--;

        return buskets[ind].remove(value);
        
        
    }

    @Override
    public T removeAny() throws Exception {
        if(size == 0 ) throw new Exception("buskets are empty");
        
        T result = null;
        
        for (int j = 0; j < buskets.length; j++) { 
            if(buskets[j].getSize() >0) {
                result = buskets[j].dequeue();
                size--;      
                break;
            }                       
        }
        
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size=0;       
        for (int i = 0; i < buskets.length; i++) {
            buskets[i].clear();            
        }
    }
    
    public String toString(){
        String result = "";
        if(size == 0 ) return "Set Is empty";
        
        for (int i = 0; i < buskets.length; i++) {
            result += buskets[i].toString()+" ";
            
        }
        return result+" size:"+size;        
    }
    
}
