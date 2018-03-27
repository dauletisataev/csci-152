/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson_18;
import impl.LLQueueSet;

import adt.Set;

/**
 *
 * @author adm
 */
public class Help {
    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2){
        boolean result=true;
        int size=set1.getSize();
        for (int i=0;i<size;i++){
            try {
            int x=set1.removeAny();
            set1.add(x);
            if (!set2.contains(x)){
                result=false;
                break;
            }
            
            
            }
            catch(Exception ex){
                
            }
        }
        return result;
    }
    
    
    public static Set<String> union(Set<String> set1, Set<String> set2){
        Set<String> result=new LLQueueSet();
        
        for (int i=0;i<set1.getSize();i++){
            try {
                String x=set1.removeAny();
                set1.add(x); 
                result.add(x);  
            }
            catch(Exception ex){  }   
              
        }
        for (int j=0;j<set2.getSize();j++){
                try{
                    String y=set2.removeAny();
                    set2.add(y);
                    result.add(y);
             
                }
                catch(Exception ex){}
            }
        
        return result;
    }
    
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> result=new LLQueueSet();
        int size=set1.getSize();
        for (int i=0;i<size;i++){
            try {
            int x=set1.removeAny();
            set1.add(x);
            if (set2.contains(x)==true){
                result.add(x);
            }
            
            
            }
            catch(Exception ex){
                
            }
        }
        return result;
    }
    
    
}
