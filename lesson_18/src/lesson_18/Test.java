/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson_18;

import adt.Set;

import impl.LLQHashTableSet;


/**
 *
 * @author adm
 */
public class Test {
    public static void main(String[] args){
        // TODO code application logic here
        
                ex1();
//                    ex_2();

    }
    
    static void ex1(){
         LLQHashTableSet<Integer> hash = new LLQHashTableSet(10);
         
         //First tries to removeAny from the empty set
        System.out.println("First tries to removeAny from the empty set");
         try {
         hash.removeAny();
         }
         catch (Exception ex){
             System.out.println("Error in removeAny");
         }
         System.out.println(hash);
         
         
         //Add the integers 1 through 20 to the set
          System.out.println("Add the integers 1 through 20 to the set");
         for (int i=1;i<=20;i++){
             hash.add(i);
         }
         System.out.println(hash);
         
         
         //Remove the even integers 2, 4, 6,…, 20,
          System.out.println("Remove the even integers 2, 4, 6,…, 20");
          for (int i=2;i<=20;i=i+2){
             hash.remove(i);
         }
         System.out.println(hash);
         
         
         //Try to remove the values 10 and 100 
          System.out.println("Try to remove the values 10 and 100 ");
         System.out.println(hash.remove(10));
         System.out.println(hash.remove(100));
          System.out.println(hash);
         
         // add the integers 1 to 30 to the set, 
          System.out.println("add the integers 1 to 30 to the set");
          for (int i=1;i<=30;i++){
             hash.add(i);
         }
         System.out.println(hash);
         
         
         //Call removeAny 10 times
          System.out.println("Call removeAny 10 times");
          try{
          for (int i=1;i<=10;i++){
             hash.removeAny();
         }
          }
          catch (Exception ex){
              
          }
         System.out.println(hash);
         
         //Clear the set
         System.out.println("Clear the set");
         hash.clear();
        System.out.println(hash);
        
        //Finally, add the odd values 51, 53,…, 79 
        System.out.println("Finally, add the odd values 51, 53,…, 79 ");
        for (int i=51;i<=79;i=i+2){
             hash.add(i);
         }
         System.out.println(hash);
        
} 
//    static void ex_2(){
//           
//           String value="a";
//         System.out.println("Hash value >>>>>>>>>>>" + value.hashCode());
//         //2
//        
//         students.add(new Student("Era",123));
//         students.add(new Student("Szx",121));
//         students.add(new Student("Erat",124));
//         students.add(new Student("Eras",125));
//         System.out.println(students);
//         
//      
//         
//         //5
//         students.add(new Student("Erat",124));
//         students.add(new Student("Eras",125));
//         System.out.println(students);
//         
//         //7
//         students.clear();
//         System.out.println(students);
//         //8
//         students.add(new Student("Meir",124));
//         students.add(new Student("Kayr",125));
//         System.out.println(students);
//         
//         //
//         Student st1 = new Student("Erat",124);
//         System.out.println("Call contains on the student Erat with id 124 and verify that the returned results are correct");
//        System.out.println("constains: Erat, 124? "+students.contains(st1));
//        
//        
//    }
    
}
