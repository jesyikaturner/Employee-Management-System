public class MyNode<T> {
    private T data;
    private MyNode nextNode;
    private int count;
    
    public MyNode(T data){
        this.data = data;
        nextNode = null;
        count = 1;
    }
    
    public T getData()
    {
        return data;
    }
    
    public void setNextNode(MyNode node)
    {
        nextNode = node;
    }
    
    public MyNode getNextNode()
    {
        return nextNode;
    }
    
    public void setCount(int value)
    {
        count = value;
    }
    
    public int getCount()
    {
        return count;
    }
}