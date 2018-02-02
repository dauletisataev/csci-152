/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab15.impl;

import complab15.adt.Queue;
import complab15.adt.Set;

/**
 *
 * @author Lenovo
 */
public class QueueSet<T> implements Set<T> {

    private LinkedListQueue<T> queue;

    public QueueSet() {
        this.queue = new LinkedListQueue<>();
    }

    @Override
    public void add(T value) {
        if(!contains(value)){
            queue.enqueue(value);
        }
    }

    @Override
    public boolean contains(T value) {
        
        for(int i=0; i<queue.getSize(); i++){
            try {
                T current = queue.dequeue();
                queue.enqueue(current);
                if(current.equals(value))
                    return true;
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
        
        return false;
    }

    @Override
    public boolean remove(T value) {
        if(contains(value)){
            Queue<T> out = new LinkedListQueue();
            T current = null;
            try {
                current = queue.dequeue();
            } catch (Exception e) {
                System.out.println(e);
            }
            
            while(!value.equals(current)){
                out.enqueue(current);
                try {
                   current = queue.dequeue();
                } catch (Exception e) {
                    System.out.println(e);
                }  
            };
            
            int size = out.getSize();
            for(int i=0; i<size; i++ ){
                try {
                    queue.enqueue(out.dequeue());
                } catch (Exception e) {
                    System.out.println(e);
                }
                
            }
            return true;
        }else 
            return false;
    }

    @Override
    public T removeAny() throws Exception {
        if(queue.getSize() == 0) throw new Exception("empty");
        T result = queue.dequeue();        
        return result;
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String toString(){
        return queue.toString();
    }
}
