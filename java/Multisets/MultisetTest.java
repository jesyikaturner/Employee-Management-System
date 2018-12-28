import java.io.PrintStream;

public class MultisetTest
{
    /** Standard outstream. */
    protected static final PrintStream outStream = System.out;
    
    public static void main(String[] args) {
     
        Multiset<String> multiset = new MyLinkedList<String>();
        
        multiset.add("robot");
        multiset.add("fortune");
        multiset.add("macbook");
        multiset.add("robot");
        outStream.println("Searching Robot: "+multiset.search("robot"));
        outStream.println("Searching Book "+multiset.search("Book"));
        multiset.add("macbook");
        multiset.add("macbook");
        multiset.add("fortune");
        multiset.removeOne("fortune");  
        multiset.removeAll("macbook");  
        outStream.println();
        multiset.print(outStream);
        
        
    }
    
}