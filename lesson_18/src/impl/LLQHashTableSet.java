	/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import adt.Set;

/**
 *
 * @author adm
 */
public class LLQHashTableSet <T> implements Set<T>{
    private LinkedListQueue<T>[] buckets;
    private int size;
    
    
public LLQHashTableSet(int a){
buckets=new LinkedListQueue[a];
size=0;
}     
    
    
    public void add(T value) {
       int index=Math.abs(value.hashCode())%buckets.length;
    if(!this.contains(value)){
       if(buckets[index]==null){
    buckets[index]=new LinkedListQueue();
    buckets[index].enqueue(value);
    } else {
    buckets[index].enqueue(value);
    }
    size++;
    } }

   
    public boolean contains(T value) {
    int index=Math.abs(value.hashCode())%buckets.length;
    if (buckets[index]==null){
    return false;}
    
    int bucketSize=buckets[index].getSize();
    boolean contains=false;
    T temp;
    while (bucketSize>0){
        try {
            temp=buckets[index].dequeue();
            buckets[index].enqueue(temp);
            bucketSize--;
            if (temp==value){contains=true; break;}
        } catch (Exception ex) {System.out.println("Some error in exception!");}
    }
    
    return contains;
    }

   
    public boolean remove(T value) {
        if (!this.contains(value)){
        return false;
        } else{
    int hash=Math.abs(value.hashCode())%buckets.length;
    T temp;
    while (true){
        try {
            temp=buckets[hash].dequeue();
            if (temp==value){break;}
            buckets[hash].enqueue(temp);
        } catch (Exception ex) {System.out.println("Some error in exception!");}
    }
    size--;
return true;    
    }}

 
    public T removeAny() throws Exception {
       if (size==0){{throw new Exception("Set is empty");}
    } else {
    T result=null;
    for (int i=0;i<buckets.length; i++){
    if (buckets[i].getSize()!=0){
    size--;
    result=buckets[i].dequeue();
    break;
    }
    }
    return result;
}  }

   
    public int getSize() {
       return size;
    }


    public void clear() {
        size=0;
         for (int i = 0; i < buckets.length; i++) {
         buckets[i].clear();
         }
    }
     @Override
    public String toString() {
        String st = "";
        if (size == 0) {
            return "Nothing to print out. Stack is empty";
        }
        for (int i = 0; i < buckets.length; i++) {
            st +=buckets[i].toString();
        }
        return st + " ";
    }
    

}
