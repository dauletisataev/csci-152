/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab19.impl;

/**
 *
 * @author Lenovo
 */
public class Student implements Comparable {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
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


    @Override
    public int compareTo(Object student) { 
        Student st = (Student) student;
        boolean res = id > st.getId();
        if(res == false) return -1; 
        else return name.compareTo(st.getName());   
    }
    
    public String toString(){
        return name+": "+id;
    }
    
    public int hashCode(){
         //return 42;
         return id;
    }
    
}
