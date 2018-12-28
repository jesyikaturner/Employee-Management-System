public class BSTNode<T>
{
    public T data;
    public int count;
    public BSTNode left, right;
    
    public BSTNode(T data){
        this.data = data;
        count = 1;
        left = null;
        right = null;
    }
}