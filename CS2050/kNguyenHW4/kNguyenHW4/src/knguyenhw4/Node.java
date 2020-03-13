/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knguyenhw4;

/**
 *
 * @author khang
 */

public class Node<T> {
    private T data;
    private Node next;
        
        /**
         * Check how many entries there are in the node
         * @param anEntry 
         */
        public Node (T anEntry)
        {
            data = anEntry;
            next = null;
        }
        /**
         * Get values of T, and use it as a call data.
         * @return data
         */
        public T getData() {
            return data;
        }
        /**
         * Put the value of data, back as data
         * @param data 
         */
        public void setData(T data) {
            this.data = data;
        }
        /**
         * Use Node to read what's next in the data
         * @return 
         */
        public Node getNext() {
            return next;
        }
        /**
         * The Node uses the next, and then reads the data for whatever is next
         * @param next 
         */
        public void setNext(Node next) {
            this.next = next;
        }
}
