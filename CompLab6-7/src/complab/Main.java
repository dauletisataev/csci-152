/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab;

import complab.impl.ArrayIntQueue;
import complab.impl.ArrayIntStack;


/**
 *
 * @author Lenovo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //lab6();
        lab7();
    }
    
    static void lab6(){
        /**
         * Creates a new stack and tries to pop from the empty stack
         */
        ArrayIntStack intStack = new ArrayIntStack();
        
        try{
            System.out.println(intStack.pop());
            
        }catch(Exception e){
            System.out.println(e);
        }
        /**
         * Pushes 12 items on the stack using a loop, and
         * then prints the stack contents and its size afterwards
         */
        for(int i =0; i<12; i++) intStack.push((int) (Math.random()*50+1) );
        
        System.out.println(intStack);
        
        /** 
         * Pop several items from the stack, and print its contents and resulting size
         */
        for(int i =0; i<3; i++)
            try{
                System.out.println(intStack.pop()+" and size:"+ intStack.getSize());            
            }catch(Exception e){
                System.out.println(e);
            }
        System.out.println(intStack);
        /**
         * Clear the stack, and print its contents and resulting size
         */
        intStack.clear();
        System.out.println("content: "+intStack+" and size:"+intStack.getSize());
        
        /**
         * Push 22 more items to the stack using a loop, and 
         * again print its contents and resulting size
         */
        for(int i =0; i<22; i++) intStack.push( (int) (Math.random()*50+1) );
        
        System.out.println("content: "+intStack+" and size:"+intStack.getSize());       
    }
    
    static void lab7(){
       ArrayIntQueue intQueue = new ArrayIntQueue();
        try {
            System.out.println(intQueue.dequeue());
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        for(int i =0; i<8; i++) intQueue.enqueue(i);//(int) (Math.random()*50+1) );
        System.out.println(intQueue+" and size:"+intQueue.getSize());
        
        for(int i =0; i<3; i++)
            try {
                System.out.println(intQueue.dequeue());
            } catch (Exception e) {
                System.out.println(e);
            }
        
        System.out.println("Starting 9 iterations loop");
        for(int i=0; i<9; i++){
            intQueue.enqueue(i);
            intQueue.enqueue(i);
            try {
                intQueue.dequeue();
                intQueue.dequeue();
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(intQueue+" and size:"+intQueue.getSize());
            
        }
        System.out.println(intQueue+" and size:"+intQueue.getSize());
        
        intQueue.clear();
        System.out.println(intQueue+" and size:"+intQueue.getSize());
        
        for(int i =0; i<22; i++) intQueue.enqueue(i);//(int) (Math.random()*50+1) );
        System.out.println(intQueue+" and size:"+intQueue.getSize());    
        
        
    }
}
