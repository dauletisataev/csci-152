/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab10;

import complab10.impl.LinkedListQueue;
import complab10.impl.LinkedListStack;

/**
 *
 * @author Lenovo
 */
public class CompLab10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //lab10();
        //lab11_1();
        //lab11_2();
        lab11_3();
    }
    
    static void lab10(){
        LinkedListStack<Integer> listStack = new LinkedListStack();
        try {
            System.out.println(listStack.pop());
        } catch (Exception e) {
            System.out.println(e);
        }
        
        for(int i=0; i<12; i++) listStack.push(i);        
        System.out.println(listStack+" and size is:"+listStack.getSize());
        
        for(int i = 0; i<12; i++) 
            try {
                System.out.println("Popped: "+listStack.pop());
            } catch (Exception e) {
                System.out.println(e);
            }
        System.out.println(listStack+" and size is:"+listStack.getSize());  
    }
    
    static void lab11_1(){
        LinkedListQueue<Integer> listQueue = new LinkedListQueue();
        try {
            System.out.println(listQueue.dequeue());
        } catch (Exception e) {
            System.err.println(e);
        }
        
        for(int i =0; i<8; i++){
            listQueue.enqueue(i);
        } 
        System.out.println(listQueue+" and size: "+listQueue.getSize());
        
        for(int i=0; i<3; i++)
            try {
                System.out.println(listQueue.dequeue());
            } catch (Exception e) {
                System.out.println(e);
            }
        System.out.println(listQueue+" and size: "+listQueue.getSize());
        
        System.out.println("\nStarting 9 iteration");
        for(int i=0; i<9; i++){
            listQueue.enqueue(i);
            listQueue.enqueue(i);
            try {
                listQueue.dequeue();
                listQueue.dequeue();
            } catch (Exception e) {
                System.err.println(e);
            }
            System.out.println(listQueue+" and size: "+listQueue.getSize());
        }
        
        System.out.println(listQueue+" and size: "+listQueue.getSize());
        
        
        System.out.println("\nClear the queue");
        listQueue.clear();
        System.err.println(listQueue+" and size: "+listQueue.getSize());
    }
    
    static void lab11_2(){
        SequenceChecker checker = new SequenceChecker();
        LinkedListQueue<Character> queue = new LinkedListQueue();
        queue.enqueue('{');
        queue.enqueue('{');
        queue.enqueue('[');
        queue.enqueue('(');
        queue.enqueue(')'); 
        queue.enqueue(']');
        queue.enqueue('}');
        queue.enqueue('}');
        try {
            System.out.println( checker.isBalanced(queue));
        } catch (Exception e) {
            System.out.println(e);
        }
            
        
    }
    
    static void lab11_3(){
        PalindromeChecker checker = new PalindromeChecker();
        
        LinkedListQueue<Character> queue = new LinkedListQueue();
        queue.enqueue('a');
        queue.enqueue('r');
        queue.enqueue('a');
        queue.enqueue('r');
        queue.enqueue('a'); 
        System.out.println(checker.isPalindrome(queue));
    }
}
