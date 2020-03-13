/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylist;

/**
 *
 * @author khang
 */
public class BinaryTree {
    public class BinaryTree <E extends Comparable<E>>{
        
        private Node root;
        private int count;
        
        public BinaryTree(){
            root = null;
            count = 0;
        }
        
        
        public void add ( E anEntry){
            if ( root == null) {
                Node node = new Node (anEntry);
                root = node;
                count++;
                
            }
            else {
                add (root, anEntry);
                
            }
        }
        public void add (Node localRoot, E anEntry){
            
        }
        public E[] toArray(){
            
            Comparable[] newList = new Comparable[count];
            E[] list = (E[] newList);
            int postion = 0;
            
            if (root != null){
                position = toArray (position, list, root);
                
            }
            
        }        
        
        
        public int toArray (int position, E[] list, Node localRoot){
            //traveers lt;
            if (localRoot.lt!=null){
                position = toArray{position, list, localRoot.lt);
                
            }
            }
            //visit root
            list[position] = localRoot.data;
            position++;
            //traverse rt
            if (localRoot.rt !=null ){
                position = toArray (position, list, localRoot.rt);
           
            }
            return position;
        }
        private class Node{
            private E data;
            private Node lt;
            private Node rt;
            
            private Node(E data){
                
                this.data = data;
                lt = null;
                rt = null;
                
            }
        }
    }
}
