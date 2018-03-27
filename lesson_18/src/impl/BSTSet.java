/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import adt.Set;

/**
 *
 * @author adm
 */
public class BSTSet   <T extends Comparable> implements Set<T>   {
    private TreeNode<T> root;
    private int size;
    
    public BSTSet(){
        root=null;
        size=0;
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
            TreeNode<T> temp = root;    
            
            while(true){
                if(temp.getValue().compareTo(newNode.getValue()) > 0){
                    
                    if(temp.getLeft() == null) {
                        temp.setLeft(newNode);
                        return;
                    }
                    temp = temp.getLeft();
                } else if(temp.getValue().compareTo(newNode.getValue()) <= 0){
                  
                    if(temp.getRight() == null) {
                        temp.setRight(newNode);
                        return;
                    }
                    temp = temp.getRight();
                }
            }
        }}

    @Override
    public boolean contains(T value) {
      if(root == null) return false;
        TreeNode<T> temp = root;
        while(true){
            int compare = temp.getValue().compareTo(value);
            
            if(compare>0){
               
                if(temp.getLeft() == null) return false;
                temp  = temp.getLeft();
            }else if(compare<0){
                
                if(temp.getRight() == null) return false;
                temp  = temp.getRight();
            }else
                
                return true;
        }
    }

    
    
    @Override
    public boolean remove(T value) {
    
if(!contains(value)){return false;} 
TreeNode<T> parentofnode=null; 
TreeNode<T> node=root; 

if(size==0){System.out.println("Empty");return false;} 


while(node!=null) { 
if(node.getValue().equals(value)){ 

if(node.getLeft()==null&&node.getRight()==null){ 
if(parentofnode==null){root=null; size--; return true;} 
if(node.getValue().compareTo(parentofnode.getValue())<0){ 
parentofnode.setLeft(null);} 
else{parentofnode.setRight(null);} 
size--; 
return true;} 

if(node.getLeft()==null){ 
if(parentofnode==null){root=node.getRight(); size--; 
return true;} 
if(node.getValue().compareTo(parentofnode.getValue())<0){parentofnode.setLeft(node.getRight());} 
else{parentofnode.setRight(node.getRight());} 
size--; 
return true;} 

if(node.getRight()==null){ 
if(parentofnode==null){root=node.getLeft(); size--; 
return true;} 
if(node.getValue().compareTo(parentofnode.getValue())<0){parentofnode.setLeft(node.getLeft());} 
else{parentofnode.setRight(node.getLeft());} 
size--; 
return true;} 

if(node.getLeft()!=null&&node.getRight()!=null){ 
TreeNode<T> parentmin = node; 
TreeNode<T> min = node.getRight(); 
if(min.getLeft()==null){node.setValue(min.getValue());node.setRight(min.getRight());size--;return true;} 
while(min.getLeft()!=null){parentmin=min; min=min.getLeft();} 
if(min.getLeft()==null){ 
if(min.getRight()==null){node.setValue(min.getValue());parentmin.setLeft(null);size--;return true;} 
else{node.setValue(min.getValue());parentmin.setLeft(min.getRight());size--;return true;} 


} 
} 

} 




if(node.getValue().compareTo(value)>0){ 
parentofnode=node; 
node=node.getLeft(); 
} 
if(node.getValue().compareTo(value)<0){ 
parentofnode=node; 
node=node.getRight(); 
} 
if(!node.getValue().equals(value)&&node.getLeft()==null&&node.getRight()==null){return false;} 
} 

//no children, then its parent should essentially “null out” its reference to it. 
//one then “promote” the child to the parent’s position in the tree. 
//twoFind the node containing the smallest value in the right subtree, and set the value of the current node to it 
//Remove the node containing that smallest value 

return false; 
    }

    @Override
    public T removeAny() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSize() {
     
     return size;
    }

    @Override
    public void clear() {
       root=null;
       size=0;
    }
    
    public String toString(){
        return toStringHelper(root);
    }

    private String toStringHelper(TreeNode<T> node){
        if (node==null) return " ";
        return toStringHelper(node.getLeft())+node.getValue()+toStringHelper(node.getRight());
    }
}

