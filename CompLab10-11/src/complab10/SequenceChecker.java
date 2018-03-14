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
public class SequenceChecker { 
    public SequenceChecker(){
        
    }
    public static boolean isBalanced(Queue<Character> q) throws Exception {
        Queue<Character> queue = new LinkedListQueue();
        LinkedListStack<Character> stack  = new LinkedListStack();
        int size = q.getSize();
        for(int i= 0; i<size; i++){
            char c = q.dequeue();
            queue.enqueue(c);
            q.enqueue(c);
        }
        for(int i= 0; i<size; i++){
            char c = queue.dequeue();
            if(c== '{' || c=='[' || c=='('){
                stack.push(c);
            } else if(c==')'){
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if(c=='}'){                
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }else if(c==']'){
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else            
                throw new Exception("Illegal character taken");
        }
        return true;
        
    }
}
