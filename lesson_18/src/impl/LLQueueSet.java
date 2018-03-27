/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import adt.Queue;
import adt.Set;
import static java.lang.Math.random;



/**
 *
 * @author Lenovo
 */
public class LLQueueSet<T> implements Set<T> {
    
    
    private LinkedListQueue<T> queue=new LinkedListQueue();
    public LLQueueSet(){
        queue.clear();
                
    }
    
    @Override
    public void add(T value) {
        if (queue.getSize()==0) queue.enqueue(value);
        else if (!contains(value)){
            queue.enqueue(value);
        }
    }

    
    
    @Override
    public boolean contains(T value) {
      for (int i=0;i<queue.getSize();i++){
          try{
              T x = queue.dequeue();
              queue.enqueue(x);
              if (x.equals(value)){
                  return true;
              }
          }
          catch (Exception ex){
              
          }
      }
        return false;
    }

    @Override
    public boolean remove(T value) {
        if(contains(value)){
            Queue<T> tempq=new LinkedListQueue();
            T temp=null;
            int size=queue.getSize();
            for (int i=0;i<size;i++){
          try{
              T x = queue.dequeue();
              tempq.enqueue(x);
              if (x.equals(value)){
                  temp=value;
              }
          }
          catch (Exception ex){}      
             }
            
            for(int i=0;i<size-1;i++){
                try{
                T y= tempq.dequeue();
                if (y.equals(temp)){
                    y= tempq.dequeue();
                }
                queue.enqueue(y);
                }
          
          catch (Exception ex){}  
                }

            return true;
        }
        else return false;
    }
   
    public T removeAny() throws Exception {
       if(queue.getSize() == 0) throw new Exception("empty");
       T result=queue.dequeue(); 
       
        
       return result;
    }

    
    public int getSize() {
        return queue.getSize();
    }

    
    public void clear() {
        queue.clear();
    }
    
    public String toString(){
        
        return queue.toString();
    }

    
    

    
    
    
}
