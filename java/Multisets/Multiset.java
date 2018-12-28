import java.io.PrintStream;

/*
 Abstract class for a multiset
 T is a generic data type.
 */

public abstract class Multiset<T>
{
    protected static final String printDelim = " | ";
    
    // Add an element to the multiset
    public abstract void add (T item);
    
    /* 
     * Search for an element and returns the number of 
     * instances of the element occurring in the multiset
     */
    public abstract int search (T item);
    
    // remove one instance of the element from the multiset
    public abstract void removeOne (T item);
    
    // remove all instances of the element from the multiset
    public abstract void removeAll (T item);
    
    public abstract void print (PrintStream out);
}