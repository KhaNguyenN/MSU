/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knguyenhw5;

/**
 * Implementation of Stack interface using an array. In this implementation
 * the top is initialized to 0. If top is 0 then it is empty. In this
 * implementation top always points to an empty location. The
 * stack will be full if top equals size.
 * 
 */
public class StackArray<T> implements StackInterface<T>
{
    
    private T[] stack;
    private int top;
    private int size; //Size of the stack.
    
    /**
     * Constructor initializes the top to 0. It takes one argument (size).
     * Array of the given size is created to represent the stack.
     * @param size Size of the array.
     */
    public StackArray (int size)
    {
        this.size = size; 
        Object[] stackO = new Object[size];
        
        stack = (T[]) stackO;
        top = 0;
    }
    
    /**
     * This method will add a new entry to the top of the stack if space is
     * available.
     * @param newEntry Item to be added to the stack
     * @return It will return true if item was successfully added to the stack,
     * otherwise it will return false.
     */
    public boolean push (T newEntry)
    {
        boolean result = false;
        
        if (!isFull())
        {
            stack[top] = newEntry;
            top++;
            result = true;
        }
        
        
        return result;
    }
    
    /**
     * Item is removed from the top of the stack and it is returned
     * @return Item removed from the stack, null if stack is empty
     */
    public T pop()
    {
        T data = null;
        
        if (!isEmpty())
        {
            top--;
            data = stack[top];
        }
        
        return data;
    }
    
    /**
     * Top item on the stack is returned but not removed from the stack.
     * @return Top item on the stack, null if stack is empty
     */
    public T peek()
    {
        T data = null;
        
        if (!isEmpty())
        {
            data = stack[top-1];
        }
        
        return data;
    }
    
    /**
     * Check if the stack is empty
     * @return True if stack is empty, otherwise it returns false.
     */
    public boolean isEmpty()
    {
        return (top == 0);
    }
    
    /**
     * Check if the stack is full
     * @return True if stack is full, otherwise it returns false.
     */
    public boolean isFull()
    {
        return (top == size);
    }
    
    
    
    /**
     * Removes all items from the stack.
     */
    public void clear()
    {
        top = 0;
    }
}
