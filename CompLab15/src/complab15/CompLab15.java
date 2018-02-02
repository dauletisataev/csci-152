/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab15;

import complab15.impl.Student;
import complab15.adt.Set;
import complab15.impl.QueueSet;
import complab15.impl.StackSet;

/**
 *
 * @author Lenovo
 */
public class CompLab15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //lab15_1();
        lab15_2();
    }
    
    static void lab15_1(){
        Set<Student> set = new QueueSet();
        
        //First tries to removeAny from the empty set — catch the exception, and print the set’s contents and size 
        try {
            set.removeAny();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        //Add 5 unique Students to the set, and print its contents and size
        set.add(new Student(545, "Daulet1"));
        set.add(new Student(305, "daulet2"));
        set.add(new Student(487, "adsadas"));
        set.add(new Student(527, "mlmlm"));
        set.add(new Student(930, "ijihi"));
        System.out.println(set+" and size:"+set.getSize());
        
        //Remove a specific Student from the set using a different object         
        try {
            set.remove(new Student(545, "asdas"));
        } catch (Exception e) {
        }
        System.out.println(set+" and size:"+set.getSize());
        
        //Attempt to add 2 new Student objects that have the same values as those already in the set
        set.add(new Student(527, "Daulet1"));
        set.add(new Student(305, "daulet2"));
        System.out.println(set+" and size:"+set.getSize());
        
        //Add 3 new Students to the set whose values are not already present, and print the set’s contents and size
        set.add(new Student(111, "rqweqw"));
        set.add(new Student(222, "wqeqwe"));
        set.add(new Student(202, "lplp"));
        System.out.println(set+" and size:"+set.getSize());
        
        //Call removeAny twice on the set, and output the values of those Students who were removed
        try {
            System.out.println("removed: "+set.removeAny());
            System.out.println("removed: "+set.removeAny());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(set+" and size:"+set.getSize());
        
        //Clear the set, and print its contents and resulting size
        set.clear();
        System.out.println(set+" and size:"+set.getSize());
        
        //Finally, add 2 new Students to the set, and print the set’s contents and size
        set.add(new Student(222, "wqeqwe"));
        set.add(new Student(202, "lplp"));
        System.out.println(set+" and size:"+set.getSize());       
        
        
        
        
    }
    
    static void lab15_2(){
        Set<Student> set = new StackSet();
        
        System.out.println("First tries to removeAny from the empty set — catch the exception, and print the set’s contents and size"); 
        try {
            set.removeAny();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("\nAdd 5 unique Students to the set, and print its contents and size");
        set.add(new Student(545, "Daulet1"));
        set.add(new Student(305, "daulet2"));
        set.add(new Student(487, "adsadas"));
        set.add(new Student(527, "mlmlm"));
        set.add(new Student(930, "ijihi"));
        System.out.println(set+" and size:"+set.getSize());
        
       
        System.out.println("\nRemove a specific Student from the set using a different object");    
        try {
            set.remove(new Student(545, "Daulet1"));
        } catch (Exception e) {
        }
        System.out.println(set+" and size:"+set.getSize());
        
        System.out.println("\nAttempt to add 2 new Student objects that have the same values as those already in the set");
        set.add(new Student(527, "Daulet1"));
        set.add(new Student(305, "daulet2"));
        System.out.println(set+" and size:"+set.getSize());
        
        System.out.println("\nAdd 3 new Students to the set whose values are not already present, and print the set’s contents and size");
        set.add(new Student(111, "rqweqw"));
        set.add(new Student(222, "wqeqwe"));
        set.add(new Student(202, "lplp"));
        System.out.println(set+" and size:"+set.getSize());
        
        System.out.println("\nCall removeAny twice on the set, and output the values of those Students who were removed");
        try {
            System.out.println("removed: "+set.removeAny());
            System.out.println("removed: "+set.removeAny());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(set+" and size:"+set.getSize());
        
        System.out.println("\nClear the set, and print its contents and resulting size");
        set.clear();
        System.out.println(set+" and size:"+set.getSize());
        
        System.out.println("\nFinally, add 2 new Students to the set, and print the set’s contents and size");
        set.add(new Student(222, "wqeqwe"));
        set.add(new Student(202, "lplp"));
        System.out.println(set+" and size:"+set.getSize());
    }
}
