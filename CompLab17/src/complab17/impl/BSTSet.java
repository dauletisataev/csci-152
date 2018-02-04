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
public class BSTSet<T extends Comparable> implements Set<T> {

    private TreeNode<T> root;
    private int size;


    public BSTSet() {
        root = null;
        size = 0;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    @Override
    public void add(T value) {
        TreeNode<T> newNode = new TreeNode(value);
        if(contains(value)) return;
        size++;
        if(root == null){
            root = newNode;
        }else{
            TreeNode<T> current = root;    
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
                }
            }
        }
        
    }

    @Override
    public boolean contains(T value) {
        if(root == null) return false;
        TreeNode<T> current = root;
        while(true){
            int compare = current.getValue().compareTo(value);
            //System.out.println("comparison to "+current.getValue()+" "+compare);
            if(compare>0){
                //System.out.println("going left from:"+current.getValue());
                if(current.getLeft() == null) return false;
                current  = current.getLeft();
            }else if(compare<0){
                //System.out.println("going right from:"+current.getValue());
                if(current.getRight() == null) return false;
                current  = current.getRight();
            }else
                // it means current equals to value
                return true;
        }
    }

    @Override
    public boolean remove(T value) {
        if(!contains(value)) return false;
        
        TreeNode<T> current = root; 
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
                isLeftChild = false;
                //System.out.println("going right from:"+current.getValue());
                if(current.getRight() == null) return false;
                current  = current.getRight();
            }else{
                // it means current equals to value
                
                //case1: has no child;
                size--;
                if(current.getLeft() == null && current.getRight() == null){
                    if(size  == 0) {
                        root = null;
                        return true;
                    }
                    if(isLeftChild == true){
                        current.getParent().setLeft(null);
                        return true;
                    }else{
                        current.getParent().setRight(null);
                        return true;
                    }
                }
                
                //case2: has one child:
                if(current.getLeft() == null){//have a right child
                    if(size == 0) {
                        root = null;
                        root = current.getRight();
                        return true;
                    }
                    if(isLeftChild == true){
                        current.getParent().setLeft(current.getRight());
                        current = null;
                        return true;
                    }else{
                        current.getParent().setRight(current.getRight());
                        current = null;
                        return true;
                    }
                }else 
                if(current.getRight() == null){//have a right child
                    if(size == 0) {
                        root = current.getLeft();
                        return true;
                    }
                    if(isLeftChild == true){
                        current.getParent().setLeft(current.getLeft());
                        current = null;
                        return true;
                    }else{
                        current.getParent().setRight(current.getLeft());
                        current = null;
                        return true;
                    }
                } 
                //case 3: has two child
                if(current.getLeft()!=null && current.getRight()!=null){
                    TreeNode<T> min = current.getRight();
                    while(true){
                        if(min.getLeft() == null){
                            if(min.getRight()!=null){
                                min.getParent().setLeft(min.getRight());
                            }
                            min.getParent().setLeft(null);
                            min.setLeft(current.getLeft());
                            min.setRight(current.getRight());
                            if(isLeftChild == true){
                                current.getParent().setLeft(min);
                                current = null;     
                                return true;
                            }else{
                                if(current.getParent()==null){
                                    root = min;
                                }else
                                current.getParent().setRight(min);
                                current = null; 
                                return true;
                            }  
                        }
                        min = min.getLeft();
                    }
                } 
                        
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
    
    public String treeToString(TreeNode tree){
        if(tree == null) return "";
        return treeToString(tree.getLeft())+" "+tree.getValue()+" "+ treeToString(tree.getRight());
        
    }
    
    
}
