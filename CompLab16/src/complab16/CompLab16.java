/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab16;

import complab16.impl.Student;
import complab16.impl.BSTSet;

/**
 *
 * @author Lenovo
 */
public class CompLab16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //lab16_1();
        lab16_2();
    }
    
    static void lab16_1(){
        BSTSet<Integer> set = new BSTSet();
        //////////////////////
        System.out.println("Add the integers 5, 12, 3, 6, 14, 2, -6, 8, and 0 to the set in that order");
        set.add(5); 
        set.add(12); 
        set.add(3); 
        set.add(6); 
        set.add(14); 
        set.add(2); 
        set.add(-6); 
        set.add(8); 
        set.add(0);         
        System.out.println(set+" and size:"+set.getSize());
        
        ///////////
        System.out.println("\nAttempt to re-add the integers 14, -6, and 5 to the set");
        set.add(14); 
        set.add(-6); 
        set.add(5); 
        System.out.println(set+" and size:"+set.getSize());
        
        /////////////
        System.out.println("\nCall contains on the integers 12, 7, 2, -8, and 5, and verify that the returned results are correct");
        System.out.println("constains: 12 "+set.contains(12));
        System.out.println("constains: 7 "+set.contains(7));
        System.out.println("constains: 2 "+set.contains(2));
        System.out.println("constains: -8 "+set.contains(-8));
        
        ////////////
        System.out.println("\nClear the set, and print its contents and resulting size");
        set.clear();
        System.out.println(set+" and size:"+set.getSize());
        
        //////
        System.out.println("\nFinally, add the integers 55, 24, 78, and 51 to the set, and print the set’s    ");    
        set.add(55); 
        set.add(24); 
        set.add(78); 
        set.add(51); 
        System.out.println(set+" and size:"+set.getSize());        
                    
        
    }
    
    static void lab16_2(){
        BSTSet<Student> set = new BSTSet();
        //////////////////////
        System.out.println("Add the integers 5, 12, 3, 6, 14, 2, -6, 8, and 0 to the set in that order");
        set.add(new Student(5,"a")); 
        set.add(new Student(12,"a")); 
        set.add(new Student(3,"a")); 
        set.add(new Student(6,"a")); 
        set.add(new Student(14,"a")); 
        set.add(new Student(2,"a")); 
        set.add(new Student(-6,"a")); 
        set.add(new Student(8,"a")); 
        set.add(new Student(0,"a"));         
        System.out.println(set+" and size:"+set.getSize());
        
        ///////////
        System.out.println("\nAttempt to re-add the integers 14, -6, and 5 to the set");
        set.add(new Student(14,"a")); 
        set.add(new Student(-6,"a")); 
        set.add(new Student(5,"a")); 
        System.out.println(set+" and size:"+set.getSize());
        
        /////////////
        System.out.println("\nCall contains on the integers 12, 7, 2, -8, and 5, and verify that the returned results are correct");
        System.out.println("constains: 12 "+set.contains(new Student(12,"a")));
        System.out.println("constains: 7 "+set.contains(new Student(7,"a")));
        System.out.println("constains: 2 "+set.contains(new Student(2,"a")));
        System.out.println("constains: -8 "+set.contains(new Student(-8,"a")));
        
        ////////////
        System.out.println("\nClear the set, and print its contents and resulting size");
        set.clear();
        System.out.println(set+" and size:"+set.getSize());
        
        //////
        System.out.println("\nFinally, add the integers 55, 24, 78, and 51 to the set, and print the set’s    ");    
        set.add(new Student(55,"a")); 
        set.add(new Student(24,"a")); 
        set.add(new Student(78,"a")); 
        set.add(new Student(51,"a")); 
        System.out.println(set+" and size:"+set.getSize());            
    }
}
