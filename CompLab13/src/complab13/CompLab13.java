/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab13;

import complab13.impl.LinkedListDeque;

/**
 *
 * @author Lenovo
 */
public class CompLab13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedListDeque<Integer> deque = new LinkedListDeque();
        //Tries to pop from both the front and the back of the empty deque 
        try {
            deque.popFromBack();
            deque.popFromFront();
        } catch (Exception e) {
            System.err.println(e);
        }
        
        //Pushes 5 items to the front of the deque, and print its contents and resulting size after each push.
        for (int i = 0; i < 5; i++) {
            deque.pushToFront(i);
        }
        System.out.println(deque);
        //Pops the 5 items from the front of the deque, and print its contents and resulting size after each pop.
        for (int i = 0; i < 5; i++) {
            try {
                deque.popFromFront();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        System.out.println(deque);
        
        //Pushes 6 items to the front of the deque, and print its contents and resulting size after each push.
        for (int i = 0; i < 6; i++) {
            deque.pushToFront(i);
        }
        System.out.println(deque);        
        //Pops the 6 items from the back of the deque, and print its contents and resulting size after each pop.
        for (int i = 0; i < 6; i++) {
            try {
                deque.popFromBack();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        System.out.println(deque);
    }
    
}
