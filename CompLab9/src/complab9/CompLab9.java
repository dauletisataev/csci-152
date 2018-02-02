/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab9;

import complab9.impl.ArrayQueue;
import complab9.impl.ArrayStack;

/**
 *
 * @author Lenovo
 */
public class CompLab9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        lab6();
        //lab7();
    }
     static void lab7(){
       ArrayQueue<Integer> intQueue = new ArrayQueue();
        try {
            System.out.println(intQueue.dequeue());
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        for(int i =0; i<8; i++) intQueue.enqueue(i);//(int) (Math.random()*50+1) );
        System.out.println(intQueue+" and size:"+intQueue.getSize());
        
        for(int i =0; i<4; i++)
            try {
                System.out.println(intQueue.dequeue());
            } catch (Exception e) {
                System.out.println(e);
            }
        System.out.println(intQueue+" and size:"+intQueue.getSize());
        
        intQueue.clear();
        System.out.println(intQueue+" and size:"+intQueue.getSize());
        
        for(int i =0; i<22; i++) intQueue.enqueue(i);//(int) (Math.random()*50+1) );
        System.out.println(intQueue+" and size:"+intQueue.getSize());    
        
        
    } 
     
    static void lab6(){
        /**
         * Creates a new stack and tries to pop from the empty stack
         */
        ArrayStack<Integer> intStack = new ArrayStack();
        
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
}
