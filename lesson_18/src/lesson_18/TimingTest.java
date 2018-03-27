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
public class TimingTest {
    public static void main(String[] args) {
     
     Set<Integer> set = new LLQHashTableSet(10);

     System.out.println("Starting timing tests...");
     long time1, time2, duration;
     time1 = System.currentTimeMillis();
     
     for (int i = 0; i < 5000; i++) {
          set.add(i);
     }
   
     time2 = System.currentTimeMillis();
     duration = time2 - time1;

     System.out.println("Time taken in ms: " + duration);
     // 10 (500000) > ave=645212 ms
     // 100 (500000) > ave=82516 ms
     
     // 10 (500) > ave=102.67ms
     // 100 (5000) > ave=31.67ms
}
}
