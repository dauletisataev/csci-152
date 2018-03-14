/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab12;

import complab12.impl.LinkedListSortedQueue;
import complab12.impl.Student;
import complab12.adt.SortedQueue;

/**
 *
 * @author Lenovo
 */
public class CompLab12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //lab12_1();
        lab12_2();

    }
    
    static void lab12_1(){
        SortedQueue<Integer> sortedQueue = new LinkedListSortedQueue();
        
//        Inserts the integers 90, 80, 70, …, 10 in that order, and then prints its contents and size afterwards
        for(int i=90; i>0; i-=10){
            sortedQueue.insert(i);
        }
        System.out.println(sortedQueue+" and size:"+ sortedQueue.getSize());
        
//      Dequeue 3 items from the queue, and print its contents and resulting size     
        for(int i=0; i<3; i++)
            try {
                sortedQueue.dequeue();
            } catch (Exception e) {
                System.out.println(e);
            }
        System.out.println(sortedQueue+" and size:"+ sortedQueue.getSize());

//        Inserts the integers 100, 200, 300, …, 900 in that order, and then prints its contents and size afterwards

        for(int i=100; i<=900; i+=100){
            sortedQueue.insert(i);
        }
        System.out.println(sortedQueue+" and size:"+ sortedQueue.getSize());

        
//      Dequeue 4 items from the queue, and print its contents and resulting size
        for(int i=0; i<4; i++)
            try {
                sortedQueue.dequeue();
            } catch (Exception e) {
                System.out.println(e);
            }
        System.out.println(sortedQueue+" and size:"+ sortedQueue.getSize());
        
//        Inserts the integers 5, 15, 25, 35, …, 905, 915 in that order, and then prints its contents and size afterwards
        for(int i=5; i<=915; i+=10){
            sortedQueue.insert(i);
        }
        System.out.println(sortedQueue+" and size:"+ sortedQueue.getSize());
        
//        Create a for loop the dequeue’s all of the items from the queue, and then print its contents and resulting size

        int size = sortedQueue.getSize();
        for(int i=0; i<size; i++){
            try {
                sortedQueue.dequeue();
            } catch (Exception e) {
                System.out.println(e);
            }            
        }
        System.out.println(sortedQueue+" and size:"+ sortedQueue.getSize());
        
//        Insert three integers (your choice), and print its contents and resulting size
        sortedQueue.insert(10);        
        sortedQueue.insert(53);
        sortedQueue.insert(-25);
        System.out.println(sortedQueue+" and size:"+ sortedQueue.getSize());
        
//        Clear the queue, and print its contents and resulting size
        sortedQueue.clear();
        System.out.println(sortedQueue+" and size:"+ sortedQueue.getSize());
        
//        Insert four more integers (your choice) to the queue and finally print its contents and resulting size
        sortedQueue.insert(1555);        
        sortedQueue.insert(-8);
        sortedQueue.insert(-25);
        sortedQueue.insert(500);

        System.out.println(sortedQueue+" and size:"+ sortedQueue.getSize());
    }
    
    static void lab12_2(){
        LinkedListSortedQueue<Student> sortedStudent = new LinkedListSortedQueue();
        Student st1 = new  Student(2010, "Daulet");
        Student st2 = new  Student(2015, "Dbulet");
        Student st3 = new  Student(1010, "Dzulet");        
        Student st4 = new  Student(2013, "Dkulet");

        sortedStudent.insert(st1);
        sortedStudent.insert(st2);
        sortedStudent.insert(st3);
        sortedStudent.insert(st4);
        sortedStudent.insert(st2);

        System.out.println(sortedStudent);

 
        
        for(int i=0; i<2; i++)
            try {
                sortedStudent.dequeue();
            } catch (Exception e) {
                System.out.println(e);
            }
        
        System.out.println(sortedStudent);
        
       
        
    }
    
}
