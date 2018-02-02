/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab15.impl;
 
import complab15.adt.Set;
import complab15.adt.Stack;

/**
 *
 * @author Lenovo
 */
public class StackSet<T> implements Set<T> {

    private LinkedListStack<T> stack;

    public StackSet() {
        this.stack = new LinkedListStack<>();
    }

    @Override
    public void add(T value) {
        if(!contains(value)){
            stack.push(value);
        }
    }

    @Override
    public boolean contains(T value) {
        int size = stack.getSize();  
        Stack<T> temp = new LinkedListStack<>();
        for(int i=0; i<size; i++){
            try {                
                T current = stack.pop();
                temp.push(current);  
                if(current.equals(value)){ 
                    int t_size= temp.getSize();
                    for (int j = 0; j < t_size; j++) { 
                        stack.push(temp.pop()); 
                    }
                    return true;
                }else if(stack.getSize() == 0){
                    int t_size= temp.getSize();    
                    for (int j = 0; j < t_size; j++) { 
                        stack.push(temp.pop()); 
                    }
                }
                
                    
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
        
        return false;
    }

    @Override
    public boolean remove(T value) {
        if(contains(value)){
            Stack<T> out = new LinkedListStack();
            T current = null;
            try {
                current = stack.pop();
            } catch (Exception e) {
                System.out.println(e);
            } 
            while(!value.equals(current)){ 
                out.push(current);
                try {
                   current = stack.pop();
                } catch (Exception e) {
                    System.out.println(e);
                }  
            };
            
            int size = out.getSize();
            for(int i=0; i<size; i++ ){
                try {
                    stack.push(out.pop());
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
        if(stack.getSize() == 0) throw new Exception("empty");
        T result = stack.pop();        
        return result;
    }

    @Override
    public int getSize() {
        return stack.getSize();
    }

    @Override
    public void clear() {
        stack.clear();
    }
    
    public String toString(){
        return stack.toString();
    }
}
