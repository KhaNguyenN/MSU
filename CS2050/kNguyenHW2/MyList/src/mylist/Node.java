/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylist;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author msudenver
 * @param <T>
 */
public class MyList1<T> implements MyCollectionInterface<T> {
    private int count;
    private T[] list;
    
    public MyList1(int size)
    {
        count = 0;
        Object[] listO = new Object[size];
        //listO is empty. It is ok to convert to a subtype.
        list = (T[]) listO;
    }
    
     /**
     * Adds a new entry to this collection
     * 
     * @param newItem The object to be added to the collection
     * @return True if the addition is successful, or false if not.
     */
    public boolean add (T newItem)
    {
        boolean result = false;
        
        if (count < list.length)
        {
            list[count] = newItem;
            count++;
            result = true;
                    
        }
        
        return result;
    }
    
    /**
     * Adds a new entry to this collection at the given position
     * 
     * @param newItem The object to be added to the collection
     * @param position The location where newItem will be inserted.
     * @return True if the addition is successful, or false if not.
     */
    public boolean add (T newItem, int position)
    {
        boolean result = false;
        
        if(position >= 0 && position <= count)
        {
            if (position == 0){
                Node newNode = new Node(newItem);
                newNode.next = first;
                first = newNode;
                count++;
                result = true;
            }
            else{
                
            
            Node pn = first;
            for (int i = 1; i<position; i++)
            {
                pn = pn.next;
            }
            Node newNode = new NOde(newItem);
            newNode.next = pn.next;
            pn.next = newNode;
            count++;
            result = true;
        }
        }
            
            
        return result;
    }
    
    /**
     * Removes one unspecified entry from the collection, if possible.
     *
     * @return Either the removed entry, if the removal was successful, or
     * null.
     */
    public T remove ()
    {
       T data = first.data;
       first = first.next;
       count--;
       
       return data;
       
       
       Node cn = first;
       first = first.next;
       count--;
       return cn.data;
    }
    
    /**
     * Removes one occurrence of a given entry from this collection.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public boolean remove (T anEntry)
    {
        boolean result = false;
        
        Node cn = find (anEnry);
        
        if (cn != null)
        {
          cn.data = first.data;
          first = first.next;
          count--;
          result= true;
        }
        
        return result;
    }
    
    /**
     * Removes all entries from this collection.
     */
    public void clear()
    {
        count = 0;
    }
    
    /**
     * Gets the current number of entries in this collection.
     *
     * @return The integer number of entries currently in the collection.
     */
    public int getCurrentSize()
    {
        return count;
    }
    
    
    /**
     * Check to see if the collection is empty.
     *
     * @return True if the collection is empty, or false if not.
     */
    public boolean isEmpty()
    {
        return (count == 0);
    
    }
    
    /**
     * Counts the number of times a given entry appears in this collection.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the collection.
     */
    public int getFrequencyOf(T anItem)
    {
        int frequency = 0;
        
        Node cn = first;
        for( int i= 0; i < count; i++)
        {
            if (cn.data.equals(anEntry)){
                frequency++;
            }
                cn=cn.next;
        }
        
        
        return frequency;
    }
    
    /**
     * Tests whether this collection contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if the collection contains anEntry, or false if not.
     */
    public boolean contains (T anEntry)
    {
        boolean result = false;
        
        Node cn = find (anEntry);
        if(cn !=null)
        {
            result = true;
        }
        
        return result;
    
    }
    
    /**
     * Retrieves all entries that are in this collection.
     *
     * @return A newly allocated array of all the entries in the collection. 
     * Note: If the collection is empty, the returned array is empty.
     */
    public T[] toArray ()
    {
        Object[] list1 = new Object [count];
        T[] list = (T[]) list1;
        
        
        Node cn = first;
        for (int i = 0; i < count; i++){
            list[i] = cn.data;
            cn = cn.next;
        }
        
        return list;
    }
    
    /**
     * Find the given item if it is in the list
     * @param anItem Item we need to find in the list
     * @return index number of the item if it is in the list, -1 otherwise
     */
    private int find (T anItem)
    {
        Node cn = first;
        
        while( cn !=null && !cn.data.equals(anItem))
        {
            cn = cn.next;
        }
        
        return cn;
        
    }
    
}
