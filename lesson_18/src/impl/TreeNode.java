/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

/**
 *
 * @author adm
 */
public class TreeNode <T>{
    private T value;
    
    private TreeNode<T> left;
    private TreeNode<T>right;
    
    public TreeNode(T value){
        this.value=value;
        left=null;
        right=null;
    }
    
    public T getValue(){
        return value;
    }
    
    public void setValue(T value){
        this.value=value;
    }
    
    public TreeNode<T> getLeft(){
        return left;
    }
    public void setLeft(TreeNode<T> left){
        this.left=left;
    }
    public TreeNode<T> getRight(){
        return right;
    }
    public void setRight(TreeNode<T> right){
        this.right=right;
    }
    public String toString(){
        return value.toString();
    }
    
}
