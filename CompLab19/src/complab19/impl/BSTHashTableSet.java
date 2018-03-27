/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab19.impl;

import complab19.adt.HashTableSet; 

/**
 *
 * @author Lenovo
 */
public class BSTHashTableSet<T extends Comparable> implements HashTableSet<T> {
    private BSTSet<T>[] buskets;
    private int size;

    public BSTHashTableSet(int a){
        buskets= new BSTSet[a];
        size=0;
    }       
    
    @Override
    public void add(T value) {
        int ind = Math.abs(value.hashCode()) % buskets.length;
        
        if(!contains(value)){
            if(buskets[ind] == null){
                buskets[ind] = new BSTSet();
                buskets[ind].add(value);
            }else {
                buskets[ind].add(value);
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
                result = buskets[j].removeAny();
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
            if(buskets[i] == null) continue; 
            result += buskets[i].toString()+" "; 
            
        }
        return result+" size:"+size;        
    }

    @Override
    public int getNumberOfBuckets() {
        return buskets.length;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if(buskets[index] == null) throw new Exception("this busket is empty");
        return buskets[index].getSize();
    }

    @Override
    public double getLoadFactor() {
        return size/buskets.length;
    }

    @Override
    public double getBucketSizeStandardDev() {
        int mean , sum = 0;
        for (int i = 0; i < buskets.length; i++) {
            if(buskets[i] != null)
            sum += buskets[i].getSize();
        }
        mean = sum/buskets.length;
        
        int sumOfSquares = 0;
        
        for (int i = 0; i < buskets.length; i++) {
            int s = 0;
            if(buskets[i]!=null) s = buskets[i].getSize(); 
            sumOfSquares += Math.pow(s - mean , 2);
        }
        
        return Math.sqrt(sumOfSquares/buskets.length);
    }

    @Override
    public String bucketsToString() {
        return toString();
    }
    
}
