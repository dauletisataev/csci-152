/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab9.impl;

import complab9.adt.Queue;
import complab9.adt.Stack;

/**
 *
 * @author Lenovo
 */
public class Helper {

    public Helper() {
    }
    public static int evenCount(Stack<Integer> stk){
        int count = 0,
            size = stk.getSize();
        Stack<Integer> temp = new ArrayStack();
        for (int i = 0; i < size; i++) {
            int current;
            try {
                current = stk.pop();
                temp.push(current);
                if(current % 2 == 0) count++;
            } catch (Exception e) {
                System.out.println(e);
            }            
        }
        for (int i = 0; i < size; i++)  
            try {
                stk.push(temp.pop());
            } catch (Exception e) {
                System.out.println(e);
            }
        return count;
    }
    public static Stack<Integer> copyStack(Stack<Integer> orig){
        Stack<Integer> newStack = new ArrayStack(),
                      temp = new ArrayStack();
        int size = orig.getSize();
        for (int i = 0; i < size; i++) {
            try {
                temp.push(orig.pop());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        for (int i = 0; i < size; i++) {
            try {
                int value = temp.pop();
                orig.push(value);
                newStack.push(value);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return newStack;
    }
    
    public static Queue<Integer> copyQueue(Queue<Integer> orig){
        ArrayQueue<Integer>  newQueue = new ArrayQueue();
        int size = orig.getSize();
        for (int i = 0; i < size; i++) {
            try {
                int value = orig.dequeue();
                newQueue.enqueue(value);
                orig.enqueue(value);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return newQueue;
    }
    
    public static void reverseStack(Stack<Integer>  toRev){
        int size = toRev.getSize();
        ArrayQueue<Integer>  queue = new ArrayQueue<Integer> (); 
        for (int i = 0; i < size; i++) {
            try {
                queue.enqueue(toRev.pop());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        for (int i = 0; i < size; i++) {
            try {
                toRev.push(queue.dequeue());
            } catch (Exception e) {
                System.out.println(e);
            }
 
        }
    }
    
    public static void reverseQueue(Queue<Integer>  toRev){
        int size = toRev.getSize();
        ArrayStack<Integer>  stack = new ArrayStack(); 
        for (int i = 0; i < size; i++) {
            try {
                stack.push(toRev.dequeue());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("stack:"+stack);
        System.out.println("queue:"+toRev);
        for (int i = 0; i < size; i++) {
            try {
                toRev.enqueue(stack.pop());
                //System.out.println("queue:"+toRev);
            } catch (Exception e) {
                System.out.println(e);
            }
 
        }
    }
    
    public static boolean isPalindrome(Queue<Integer>  q){
        ArrayStack<Integer>  stack = new ArrayStack();
        ArrayQueue<Integer>  queue = new ArrayQueue();
        int size = q.getSize(); 
        for(int i=0; i<size; i++){
            try {
                int c = q.dequeue();
                stack.push(c);
                queue.enqueue(c);
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
        
        while(queue.getSize()!=0){
            try {
                if(queue.dequeue() != stack.pop()) return false;
            } catch (Exception e) {
                System.out.println(e);
            }            
        } 
        return true;
    }
    
    public static void insert(Stack<Integer>  st, int pos, int val){
        if(pos<0 || pos>=st.getSize()) return;
        
        int size = st.getSize();
        
        ArrayStack<Integer>  temp = new ArrayStack();
        for (int i = 0; i < size; i++) {
            try {
                temp.push(st.pop());
            } catch (Exception e) {
            }
        }
        for (int i = 0; i <= size; i++) {
            if(i == pos) st.push(val);
            try {                
                st.push(temp.pop());
            } catch (Exception e) {
            }
        }
    }
    
    public static Stack<Integer>  merge(Stack<Integer> s1, Stack<Integer> s2){
        int size1 = s1.getSize(),
            size2 = s2.getSize();
        ArrayStack<Integer> newStack = new ArrayStack();
        ArrayStack<Integer> temp = new ArrayStack();
        
        int j = 0, k = 0;
        
        for (int i = 0; i < size1+size2; i++) {
            if(j<size1 && k<size2){
                try {
                    int a = s1.pop(),
                        b = s2.pop();
                    if(a>b){
                        temp.push(a);
                        s2.push(b);
                        j++;
                        
                    }else{
                        temp.push(b);
                        s1.push(a);
                        k++;
                    }
                    
                     
                } catch (Exception e) {
                    System.out.println(e);
                } 
            }else if(j<size1){
                try {
                   temp.push(s1.pop()); 
                   j++;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }else{
                try {
                   temp.push(s2.pop()); 
                   k++;
                } catch (Exception e) {
                    System.out.println(e);
                }
            } 
            
        } 
        
        for (int i = 0; i < size1+size2; i++) {
            try {
                newStack.push(temp.pop());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return newStack;
    }
   
    
}
