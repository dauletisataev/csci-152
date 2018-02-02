/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab10;

import complab10.adt.Queue;
import complab10.impl.LinkedListQueue;
import complab10.impl.LinkedListStack;

/**
 *
 * @author Lenovo
 */
public class PalindromeChecker {
    public PalindromeChecker(){
        
    }
    public static boolean isPalindrome(Queue<Character> q){
        LinkedListStack<Character> stack = new LinkedListStack();
        LinkedListQueue<Character> queue = new LinkedListQueue();
        int size = q.getSize(); 
        for(int i=0; i<size; i++){
            try {
                char c = q.dequeue();
                stack.push(c);
                queue.enqueue(c);
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
        
        while(!queue.isEmpty()){
            try {
                if(queue.dequeue() != stack.pop()) return false;
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
        //System.out.println("queue: "+queue+"\nstack:  "+stack);
        return true;
    };
}
