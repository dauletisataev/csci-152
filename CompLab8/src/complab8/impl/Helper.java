/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab8.impl;

import complab8.adt.IntQueue;
import complab8.adt.IntStack;

/**
 *
 * @author Lenovo
 */
public class Helper {

    public Helper() {
    }
    public static int evenCount(IntStack stk){
        int count = 0,
            size = stk.getSize();
        IntStack temp = new ArrayIntStack();
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
    public static IntStack copyStack(IntStack orig){
        ArrayIntStack newStack = new ArrayIntStack(),
                      temp = new ArrayIntStack();
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
    
    public static IntQueue copyQueue(IntQueue orig){
        ArrayIntQueue newQueue = new ArrayIntQueue();
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
    
    public static void reverseStack(IntStack toRev){
        int size = toRev.getSize();
        ArrayIntQueue queue = new ArrayIntQueue(); 
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
    
    public static void reverseQueue(IntQueue toRev){
        int size = toRev.getSize();
        ArrayIntStack stack = new ArrayIntStack(); 
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
    
    public static boolean isPalindrome(IntQueue q){
        ArrayIntStack stack = new ArrayIntStack();
        ArrayIntQueue queue = new ArrayIntQueue();
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
    
    public static void insert(IntStack st, int pos, int val){
        if(pos<0 || pos>=st.getSize()) return;
        
        int size = st.getSize();
        
        ArrayIntStack temp = new ArrayIntStack();
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
    
    public static IntStack merge(IntStack s1, IntStack s2){
        int size1 = s1.getSize(),
            size2 = s2.getSize();
        ArrayIntStack newStack = new ArrayIntStack();
        ArrayIntStack temp = new ArrayIntStack();
        
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
