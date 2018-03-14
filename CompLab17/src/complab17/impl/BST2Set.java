/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complab17.impl;

import complab17.adt.Set;

/**
 *
 * @author Lenovo
 */
public class BST2Set<T extends Comparable> implements Set<T> {

    private OnOffTreeNode<T> root;
    private int size;


    public BST2Set() {
        root = null;
        size = 0;
    }

    public OnOffTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(OnOffTreeNode<T> root) {
        this.root = root;
    }

    @Override
    public void add(T value) {
        OnOffTreeNode<T> newNode = new OnOffTreeNode(value); 
        size++;
        if(root == null){
            root = newNode;            
        }else{
            OnOffTreeNode<T> current = root;    
            //System.out.println("inserting "+value+":"); 
            while(true){ 
                if(current.getValue().compareTo(newNode.getValue()) > 0){
                    //System.out.println("going left");
                    if(current.getLeft() == null) { 
                        current.setLeft(newNode);
                        return;
                    }
                    current = current.getLeft();
                } else if(current.getValue().compareTo(newNode.getValue()) <= 0){
                    //System.out.println("going Right");
                    if(current.getRight() == null) { 
                        current.setRight(newNode);
                        return;
                    }
                    current = current.getRight();
                } else {
                    if(current.isActive()){
                        size--;
                        return;
                    }else{
                        current.setActive(true);
                    }
                }
            }
        }
        
    }

    @Override
    public boolean contains(T value) {
        //System.out.println("\nxxxxxxxxxxxxx\nstarting check for contain of "+value.toString()+": ..... \n");
        if(root == null) return false;
        OnOffTreeNode<T> current = root;
        int i =0;
        while(true){
        //    System.out.println("loop №"+i);
            int compare = current.getValue().compareTo(value);
           // System.out.println("comparison to "+current.getValue()+" is "+compare);
            
            if(compare>0){
         //       System.out.println("going left from:"+current.getValue());
                i++;
             //   System.out.println("----------\n");
                if(current.getLeft() == null) return false;
                current  = current.getLeft();
                
            }else if(compare<0){
               // System.out.println("going right from:"+current.getValue());
                i++;
                //System.out.println("----------\n");
                if(current.getRight() == null) return false;
                current  = current.getRight();
            }else{
                // it means current equals to value
                i++;
                //System.out.println("----------\n");
                return true;
            }
            
        }
    }
 
    @Override
    public boolean remove(T value) {
        if(!contains(value)) return false;
        
        OnOffTreeNode<T> current = root; 
        boolean isLeftChild = false;
        while(true){
            int compare = current.getValue().compareTo(value);
            //System.out.println("comparison to "+current.getValue()+" "+compare);
            if(compare>0){
                //System.out.println("going left from:"+current.getValue());
                
                if(current.getLeft() == null) return false;
                current  = current.getLeft();
                isLeftChild = true;
            }else if(compare<0){
                //System.out.println("going right from:"+current.getValue());
                if(current.getRight() == null) return false;
                current  = current.getRight();
                isLeftChild = false;
            }else{ 
                size--;
                current.setActive(false);
                return true;
            }  
        }
    }

    @Override
    public T removeAny() throws Exception { 
        T result = null;
        if(size == 0) throw new Exception("empty");
        if(size == 1){
            result = root.getValue();
            root = null;
            size--;
            return result;
        }else{ 
            result = root.getValue();
            remove(result); 
            return result;
        }
        
        
    }

    public void setSize(int size) {
        this.size = size;
    } 
    
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }
    
    public String toString(){
        return treeToString(root);
    }
    
    public String treeToString(OnOffTreeNode tree){
        if(tree == null) return "";
        if (tree.isActive())
            return treeToString(tree.getLeft())+" "+tree.getValue()+" "+ treeToString(tree.getRight()); 
        else 
            return treeToString(tree.getLeft())+" "+ treeToString(tree.getRight());             
    }
    
    
}
