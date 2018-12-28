import java.io.PrintStream;

public class MyLinkedList<T> extends Multiset<T>
{
    private MyNode head;
    private int length;
    
    public MyLinkedList()
    {
        head = new MyNode<T>(null);
        length = 0;
    }
    
    public void add (T item)
    {
        MyNode temp = new MyNode<T>(item);
        MyNode current = head;
        int counter = 0;
        
        // if the current node exists.
        if(current != null) {
            // iterate through the nodes connected to each other,
            // until it reaches the last node.
            while(current.getNextNode() != null) {
                // if there's an element that already exists, increase the count of it.
                // also increase the counter by 1, so that can be added to the new node's counter.
                if(item.toString().compareTo(current.getNextNode().getData().toString()) == 0){
                    current.getNextNode().setCount(current.getNextNode().getCount()+1);
                    break;
                }
                current = current.getNextNode();
            }
        }
        
        // add the new node to the currently selected node.
        if(current.getNextNode() == null){
            // add the number of elements found to the temp node's count.
            current.setNextNode(temp);
            // increase the list length
            length++;
        }
    }
    
    public int search(T item)
    {
        int numOfElements = 0;
        MyNode current = head;
        
        if(current != null) {
            while(current.getNextNode() != null) {
                if(item.toString().compareTo(current.getNextNode().getData().toString()) == 0) {
                    numOfElements = current.getNextNode().getCount();
                }
                current = current.getNextNode();
            }
        }else {
            current = null;
        }
        return numOfElements;
    }
    
    public void removeOne (T item)
    {
        MyNode current = head;
        
        if(current != null){
            while(current.getNextNode() != null){
                if(item.toString().compareTo(current.getNextNode().getData().toString()) == 0){
                    current.getNextNode().setCount(current.getNextNode().getCount()-1);
                    break;
                }
                current = current.getNextNode();
            }
            if(current.getNextNode() != null){
                if(current.getNextNode().getCount() < 1){
                    current.setNextNode(current.getNextNode().getNextNode());
                    length--;
                }
            }else{
                current.setNextNode(null);
                length--;
            }
        }
    }
    
    public void removeAll (T item)
    {
        MyNode current = head;
        
        if(current != null){
            while(current.getNextNode() != null){
                if(item.toString().compareTo(current.getNextNode().getData().toString()) == 0){
                    current.getNextNode().setCount(0);
                    break;
                }
                current = current.getNextNode();
            }
            if(current.getNextNode() != null){
                if(current.getNextNode().getCount() < 1){
                    current.setNextNode(current.getNextNode().getNextNode());
                    length--;
                }
            }else{
                current.setNextNode(null);
                length--;
            }
        }
    }
    
    public void print (PrintStream out)
    {
        MyNode current = head;
        if(current != null) {
            while(current.getNextNode() != null) {
                out.printf("%s%s%d\n", current.getNextNode().getData(), printDelim, current.getNextNode().getCount());
                current = current.getNextNode();
            }
        }
    }
}