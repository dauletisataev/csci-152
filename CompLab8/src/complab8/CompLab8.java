/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab8;

import complab8.impl.ArrayIntQueue;
import complab8.impl.ArrayIntStack; 
import complab8.impl.Helper;

/**
 *
 * @author Lenovo
 */
public class CompLab8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Helper helper = new Helper();
        
        ////
        System.out.println("The evenCount method, which returns the number of even-numbered integers:");
        ArrayIntStack stack = new ArrayIntStack();
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
        ArrayIntQueue queue = new ArrayIntQueue();
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
        ArrayIntStack stack1 = new ArrayIntStack();
        stack1.push(1);
        stack1.push(3);
        stack1.push(5);
        stack1.push(7);
        ArrayIntStack stack2 = new ArrayIntStack();
        stack2.push(2);
        stack2.push(4);
        stack2.push(6);
        stack2.push(8);
        stack2.push(18);
        System.out.println("original stacks:"+stack1+" and "+stack2);
        System.out.println("merged stack: "+helper.merge(stack1, stack2));
    }
    
    
    
}
