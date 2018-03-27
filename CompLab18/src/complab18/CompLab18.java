/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab18;

import complab18.adt.Set;
import complab18.impl.LLQHashTableSet;

/**
 *
 * @author Lenovo
 */
public class CompLab18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //lab18_1();
        lab18_2();
    }
    
    static void lab18_1(){
        LLQHashTableSet<Integer> hashTable = new LLQHashTableSet(10);
         
        //////////////////////
        System.out.println("First tries to removeAny from the empty set");
        try {
            hashTable.removeAny();
        }
        catch (Exception ex){
            System.out.println("Error in removeAny");
        }
        System.out.println(hashTable);
         
        System.out.println("");
         
        /////////////////////////////////////////////
        System.out.println("Add the integers 1 through 20 to the set");
        
        for (int i=1;i<=20;i++){
           hashTable.add(i);
        }
        System.out.println(hashTable);
        System.out.println("");
         
        /////////////////////////////
        System.out.println("Remove the even integers 2, 4, 6,…, 20");
        
        for (int i=2;i<=20;i=i+2){
           hashTable.remove(i);
        }
        System.out.println(hashTable);
        System.out.println("");
         
         //////////////////////////////
        System.out.println("Try to remove the values 10 and 100 ");
        
        System.out.println(hashTable.remove(10));
        System.out.println(hashTable.remove(100));
        System.out.println(hashTable);
        System.out.println(""); 
        /////////////////////////////// 
        System.out.println("add the integers 1 to 30 to the set");
        
        for (int i=1;i<=30;i++){
            hashTable.add(i);
        }
        System.out.println(hashTable);
        System.out.println(""); 
         
        //Call removeAny 10 times
        System.out.println("Call removeAny 10 times");
        try{
            for (int i=1;i<=10;i++){
               hashTable.removeAny();
            }
        }
        catch (Exception ex){
            System.out.println("error has occured");
        }
        System.out.println(hashTable);
         
        //////////////////////////////////////////////
        System.out.println("Clear the set");
        
        hashTable.clear();
        System.out.println(hashTable);
        System.out.println("");
        
        /////////////////////////////////////////////////
        System.out.println("Finally, add the odd values 51, 53,…, 79 ");
        
        for (int i=51;i<=79;i=i+2){
             hashTable.add(i);
        }
        System.out.println(hashTable);
    }
    
    static void lab18_2(){
        Set<Integer> set = new LLQHashTableSet(5000);

        System.out.println("Starting timing tests...");
        long time1, time2, duration;
        time1 = System.currentTimeMillis();

        for (int i = 0; i < 50000; i++) {
             set.add(i);
        }
        
        //for 10 buskets
        /*
            2256; 4561;2225
        average: 3014
        */
        
        //for 100 buskets
        /*
            323; 275;273
        average: 290
        */
        
       //for 5000 buskets
        /*
            47; 34; 22
        average: 34
        */

        time2 = System.currentTimeMillis();
        duration = time2 - time1;

        System.out.println("Time taken in ms: " + duration);        
    }
    
}
