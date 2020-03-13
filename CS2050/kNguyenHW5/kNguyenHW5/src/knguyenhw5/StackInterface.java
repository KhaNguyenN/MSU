package knguyenhw5;

/**
 * This is stack interface
 * @author Salim Lakhani
 * @version 20160929
 */
public interface StackInterface<T>
{
    
    /**
     * This method will add a new entry to the top of the stack if space is
     * available.
     * @param newEntry Item to be added to the stack
     * @return It will return true if item was successfully added to the stack,
     * otherwise it will return false.
     */
    public boolean push (T newEntry);
    
    /**
     * Item is removed from the top of the stack and it is returned
     * @return Item removed from the stack, null if stack is empty
     */
    public T pop();
    
    /**
     * Top item on the stack is returned but not removed from the stack.
     * @return Top item on the stack, null if stack is empty
     */
    public T peek();
    
    /**
     * Check if the stack is empty
     * @return True if stack is empty, otherwise it returns false.
     */
    public boolean isEmpty();
    
    /**
     * Removes all items from the stack.
     */
    public void clear();
    
}
