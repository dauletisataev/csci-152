/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import adt.Queue;
import adt.Stack;
import adt.Set;




/**
 *
 * @author Lenovo
 */
public class LLStackSet<T> implements Set<T> {
    
    
    private LinkedListStack<T> stack=new LinkedListStack();
    public LLStackSet(){
        stack.clear();
                
    }
    
    @Override
    public void add(T value) {
        if (stack.getSize()==0) stack.push(value);
        else if (!contains(value)){
            stack.push(value);
        }
    }

    
    
    @Override
    public boolean contains(T value) {
        LinkedListStack<T> tempStack=new LinkedListStack();
        boolean result=false;
        int size=stack.getSize();
      for (int i=0;i<size;i++){
          try{
              T x = stack.pop();
              tempStack.push(x);
              if (x.equals(value)){
                  result=true;
              }
          }
          catch (Exception ex){
              
          }
      }
      for (int i=0;i<size;i++){
          try{
              
              stack.push(tempStack.pop());
              
          }
          catch (Exception ex){    
          }
      }
        return result;
    }

    @Override
    public boolean remove(T value) {
        if(contains(value)){
            Queue<T> tempq=new LinkedListQueue();
            T temp=null;
            int size=stack.getSize();
            for (int i=0;i<size;i++){
          try{
              T x = stack.pop();
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
                stack.push(y);
                }
          
          catch (Exception ex){}  
                }

            return true;
        }
        else return false;
    }
   
    public T removeAny() throws Exception {
       if(stack.getSize() == 0) throw new Exception("empty");
       T result=stack.pop(); 
       return result;
    }

    
    public int getSize() {
        return stack.getSize();
    }

    
    public void clear() {
        stack.clear();
    }
    
    public String toString(){
        
        return stack.toString();
    }

    
    

    
    
    
}
