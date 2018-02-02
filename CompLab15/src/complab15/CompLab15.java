/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab15;

import complab15.impl.Student;
import complab15.adt.Set;
import complab15.impl.QueueSet;

/**
 *
 * @author Lenovo
 */
public class CompLab15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        lab15_1();
    }
    
    static void lab15_1(){
        Set<Student> set = new QueueSet();
        set.add(new Student(545, "asdas"));
        set.add(new Student(555, "asdas"));
        System.out.println(set);
        
        try {
            set.remove(new Student(545, "asdas"));
        } catch (Exception e) {
        }
        System.out.println(set);
        
        
    }
}
