/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab9;

import complab9.adt.Queue;
import complab9.adt.Stack;
import complab9.impl.ArrayQueue;
import complab9.impl.ArrayStack;
import complab9.impl.Helper;

/**
 *
 * @author Lenovo
 */
public class CompLab9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //lab6();
        lab7();
        //lab8();
    }
    static void lab7(){
       Queue<Integer> intQueue = new ArrayQueue();
        try {
            System.out.println(intQueue.dequeue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
        
        intQueue.clear();
        System.out.println(intQueue+" and size:"+intQueue.getSize());
        
        for(int i =0; i<22; i++) intQueue.enqueue(i);//(int) (Math.random()*50+1) );
        System.out.println(intQueue+" and size:"+intQueue.getSize());    
        
        
    }
     
    static void lab6(){
        /**
         * Creates a new stack and tries to pop from the empty stack
         */
        Stack<Integer> intStack = new ArrayStack();
        
        try{
            System.out.println(intStack.pop());
        }catch(Exception e){
            System.out.println(e.getMessage());
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
        System.out.println("content: "+intStack);
        
        /**
         * Push 22 more items to the stack using a loop, and 
         * again print its contents and resulting size
         */
        for(int i =0; i<22; i++) intStack.push( (int) (Math.random()*50+1) );
        
        System.out.println("content: "+intStack);       
    }
    static void lab8(){
        Helper helper = new Helper();
        
        ////
        System.out.println("The evenCount method, which returns the number of even-numbered integers:");
        ArrayStack<Integer> stack = new ArrayStack();
        stack.push(12);
        stack.push(4);
        stack.push(5);
        stack.push(8);
        System.out.println(stack);
        System.out.println("even count:"+helper.evenCount(stack)); 
        
        /////
        System.out.println("\nThe copyStack method, which creates and returns a copy of the stack orig, where orig is “preserved”");
        System.out.println("copy of the stack:"+helper.copyStack(stack)); 
        
        /////
        System.out.println("\nThe copyQueue method, which creates and returns a copy of the queue orig, where orig is “preserved”");
        ArrayQueue<Integer> queue = new ArrayQueue();
        queue.enqueue(12);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(8);
        System.out.println(queue);
        System.out.println("copy of queue: "+helper.copyQueue(queue));
        
        System.out.println("\nThe reverseStack method, which reverses the order of the elements stored in the stack toRev.");
        System.out.println("original stack: "+stack);
        helper.reverseStack(stack);
        System.out.println("reversed stack: "+stack);
        
        System.out.println("\nThe reverseQueue method, which reverses the order of the elements stored in the queue toRev.");
        System.out.println("original queue: "+queue);
        helper.reverseQueue(queue);
        System.out.println("reversed queue: "+queue);
        
        
        System.out.println("\n The isPalindrome method, which returns whether or not the given queue q represents a palindrome");
        queue.enqueue(12);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(8);
        System.out.println("queue is: "+queue);
        System.out.println("queue is palindrome: "+helper.isPalindrome(queue));
        
        System.out.println("\nThe insert method, which modifies the contents of the stack st, so that the value val is inserted pos places from the bottom");
        System.out.println("original stack: "+stack);
        helper.insert(stack, 2, 7);
        System.out.println("modified stack: "+stack);
        
        System.out.println("\nThe merge method, where s1 and s2 are stacks whose elements are in order (smallest at the bottom)");
        ArrayStack<Integer> stack1 = new ArrayStack();
        stack1.push(1);
        stack1.push(3);
        stack1.push(5);
        stack1.push(7);
        ArrayStack<Integer> stack2 = new ArrayStack();
        stack2.push(2);
        stack2.push(4);
        stack2.push(6);
        stack2.push(8);
        stack2.push(18);
        System.out.println("original stacks:"+stack1+" and "+stack2);
        System.out.println("merged stack: "+helper.merge(stack1, stack2));
    }
}
