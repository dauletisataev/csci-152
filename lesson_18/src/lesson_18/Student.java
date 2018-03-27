/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson_18;

/**
 *
 * @author adm
 */
public class Student implements Comparable {
    private int id;
    private String name;
    
    Student (String name,int id){
        this.id=id;
        this.name=name;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public int compareTo(Object o) {
        int result;
        Student someStudent = (Student) o;
        
      /**
         * lab12_2
         
        
        if(id < someStudent.getId()) result=-1; 
        else result=1;
*/
        /**
         * lab12_2
         */
        result=name.compareTo(someStudent.getName());
            
        return result;




    }
    
    public boolean equals(Object obj){
        if (obj instanceof Student){
            Student sobj=(Student)obj;
            return id==sobj.id && name.equals(sobj.name);
        }
        return false;
    }
    
     public String toString(){
        return "["+name+": "+id+"]";
    }
    
}
