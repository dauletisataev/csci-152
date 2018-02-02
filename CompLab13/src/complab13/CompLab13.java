/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab13;

import complab13.adt.Deque;
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
        //lab13_1();
        lab13_2();
    }
    
    static void lab13_1(){
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
    
    static void lab13_2(){
        Deque<Integer> d = new LinkedListDeque<>();
        for (int i = 0; i < 10; i++) {
            d.pushToBack((int) (Math.random()*50));
        }
        System.out.println("before:\n"+d);
        
        System.out.println("after:\n"+mergeSort(d));

        
    }
    
    public static Deque<Integer> merge(Deque<Integer> d1, Deque<Integer> d2) {
     int p1 =0, p2=0;
     int d1_length = d1.getSize(),
         d2_length = d2.getSize(),
         length = d1.getSize()+d2.getSize();
     
     Deque<Integer> result = new LinkedListDeque();
     
     int current1=0, current2=0;
     
     //System.out.println(d1+" and "+d2);
     
     for(int i=0; i<length; i++){
         
         try {
            current1 = d1.popFromFront();
         } catch (Exception e) {
         }
         try {
            current2 = d2.popFromFront();
         } catch (Exception e) {
         }
         
         if(p1==d1_length){
             result.pushToBack(current2);
             p2++;
         }else if(p2 == d2_length){
             result.pushToBack(current1);
             p1++;
         }else if(current1<current2){
             result.pushToBack(current1);
             p1++;
             d2.pushToFront(current2);
         } else{
            result.pushToBack(current2);
            d1.pushToFront(current1);
             p2++; 
         }
         
     };
     return result;
    } 


    public static Deque<Integer> mergeSort(Deque<Integer> deq) {
         int size = deq.getSize();
         if(size <= 1) return deq;
         else{
             int middle = (deq.getSize()/ 2);
             Deque<Integer> half1 = new LinkedListDeque();
             for (int i = 0; i < middle; i++) {
                try {
                    half1.pushToBack(deq.popFromFront());
                } catch (Exception e) {
                    System.out.println(e+" in MergeSort");
                }
             }
             
             Deque<Integer> half2 = new LinkedListDeque();
             for (int i = middle; i < size; i++) {
                try {
                    half2.pushToBack(deq.popFromFront());
                } catch (Exception e) {
                    System.out.println(e+" in MergeSort");
                }
             }
             
             half1 = mergeSort(half1);
             half2 = mergeSort(half2);
             
             return merge(half1, half2);
             
             
         }
//            Step 1:  split deq into two Deques of relatively equal size
//            Step 2:  pass both of these Deques into mergeSort
//            Step 3:  pass the resulting Deques into merge, and return the result
         
    } 
    
}
