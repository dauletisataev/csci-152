/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab19;

import complab19.adt.HashTableSet;
import complab19.adt.Set;
import complab19.impl.BSTHashTableSet;
import complab19.impl.LLQHashTableSet;
import complab19.impl.LinkedListQueue;
import complab19.impl.Student;

/**
 *
 * @author Lenovo
 */
public class CompLab19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        lab19_1();
    }
    
    static void lab19_1(){
        System.out.println("a)  Next, create (or use your previous version of) the class Student which has the fields id");
        LLQHashTableSet<Student> set1 = new LLQHashTableSet(10); 
        for (int i = 100; i < 300; i++) {
            set1.add(new Student(i,"Bob"));            
        }
        test(set1); 
        
        System.out.println("b)  Increase the number of buckets to 100, repeat the same tests as before, and record the resulting statistics on your paper.");
        LLQHashTableSet<Student> set2 = new LLQHashTableSet(100); 
        for (int i = 100; i < 300; i++) {
            set2.add(new Student(i,"Bob"));            
        }
        test(set2); 
        
        
    }
    static void lab19_2(){
        System.out.println("a)  Next, create (or use your previous version of) the class Student which has the fields id");
        BSTHashTableSet<Student> set1 = new BSTHashTableSet(10); 
        for (int i = 100; i < 300; i++) {
            set1.add(new Student(i,"Bob"));            
        }
        test(set1); 
        
        System.out.println("b)  Increase the number of buckets to 100, repeat the same tests as before, and record the resulting statistics on your paper.");
        BSTHashTableSet<Student> set2 = new BSTHashTableSet(100); 
        for (int i = 100; i < 300; i++) {
            set2.add(new Student(i,"Bob"));            
        }
        test(set2); 
        
        
    }    
    static void test(HashTableSet set){
        System.out.println("-------------");
        System.out.println(set);
        System.out.println("load factor is: "+set.getLoadFactor());
        System.out.println("std deviation is: "+set.getBucketSizeStandardDev());
        System.out.println("-------------\n");
    }
    
}
