import java.io.PrintStream;

public class MyBST<T> extends Multiset<T>
{
    private BSTNode<T> mRoot;
    
    public MyBST()
    {
        mRoot = null;
    }
    
    /*
     * /// ADD ///
     */   
    public void add(T item) {
        mRoot = add(mRoot, item);
    } // end of add()
    
    public BSTNode<T> add(BSTNode<T> root, T item){
        if(root == null){
            root = new BSTNode<T>(item);
            //System.out.printf("Adding: %s, count is: %d\n",root.data,root.count);
            return root;
            //return root;
        }
        // if the item is less than the current node data, go down the left node.
        if(item.toString().compareTo(root.data.toString()) < 0){
            root.left = add(root.left,item);
            // if the item is greater than the current node data, go down the right node.
        }else if (item.toString().compareTo(root.data.toString()) > 0){
            root.right = add(root.right,item);
            // if it's the same then increase the count;
        }else{
            root.count++;
            //System.out.printf("Increasing: %s, count is: %d\n",root.data,root.count);
        }
        return root;
    }
    
    /*
     * /// SEARCH ///
     */  
    public int search(T item) {
        BSTNode<T> temp = search(mRoot, item);
        if(temp != null){
            return temp.count;
        }
        return 0;
        
    } // end of add()   
    
    public BSTNode<T> search(BSTNode<T> root, T item){
        if(root == null){
            return null;
        }
        // if the item is less than the current node data, go down the left node.
        if(item.toString().compareTo(root.data.toString()) < 0){
            return search(root.left,item);
            // if the item is greater than the current node data, go down the right node.
        }else if (item.toString().compareTo(root.data.toString()) > 0){
            return search(root.right,item);
            // if it's the same then increase the count;
        }else if(item.toString().compareTo(root.data.toString()) == 0){    
            return root;
        }
        
        return null;
    }
    
    /*
     * /// REMOVE ONE ///
     */     
    public void removeOne(T item) {
        removeOne(mRoot,item);
    } // end of removeOne()
    
    private BSTNode<T> removeOne(BSTNode<T> root, T item){
        if(root == null){
            return root;
        }
        
        // if the item is less than the current node data, go down the left node.
        if(item.toString().compareTo(root.data.toString()) < 0){
            root.left = removeOne(root.left,item);
            // if the item is greater than the current node data, go down the right node.
        }else if (item.toString().compareTo(root.data.toString()) > 0){
            root.right = removeOne(root.right,item);
        }else{
            root.count--;
            //System.out.printf("Decreasing: %s, count is: %d\n",root.data,root.count);
            if (root.count < 1){
                //System.out.printf("Deleting: %s, count is: %d\n",root.data,root.count);
                if(root.left == null && root.right == null){
                    return null;
                }else if(root.left == null){
                    return root.right;
                }else if (root.right == null){
                    return root.left;
                }else{
                    BSTNode<T> temp = minValue(root.right);
                    root.data = temp.data;
                    root.count = temp.count;
                    
                    root.right = remove(root.right,temp.data);     
                }
            }
        }
        return root;
    }
    
    /*
     * /// REMOVE ALL ///
     */ 
    public void removeAll(T item) {
        mRoot = removeAll(mRoot, item);
    } // end of removeAll()
    
    public BSTNode<T> removeAll(BSTNode<T> root, T item){
        //System.out.println("Remove ALL: "+item.toString());
        if(root == null){
            return root;
        }
        
        // if the item is less than the current node data, go down the left node.
        if(item.toString().compareTo(root.data.toString()) < 0){
            root.left = removeAll(root.left,item);
            // if the item is greater than the current node data, go down the right node.
        }else if (item.toString().compareTo(root.data.toString()) > 0){
            root.right = removeAll(root.right,item);
        }else{
            //System.out.printf("RemoveAll: %s, count is: %d\n",root.data,root.count);
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }else{
                BSTNode<T> temp = minValue(root.right);
                root.data = temp.data;
                root.count = temp.count;
                root.right = removeAll(root.right, (T)temp.data);        
            }
        }
        return root;
    }
    
    // finds the node, sets it to null.
    private BSTNode<T> remove(BSTNode<T> root, T item){
        if(item.toString().compareTo(root.data.toString()) < 0){
            root.left = remove(root.left,item);
            // if the item is greater than the current node data, go down the right node.
        }else if (item.toString().compareTo(root.data.toString()) > 0){
            root.right = remove(root.right,item);
        }else{
            return null;
        }
        return root;
    }
    
    private BSTNode<T> minValue(BSTNode<T> root){
        if(root.left != null){
            return minValue(root.left);
        }            
        //System.out.printf("Getting min: %s | %d\n",root.data.toString(),root.count);
        return root;
    }
    
    /*
     * /// PRINT ///
     */     
    public void print(PrintStream out) {
        traverseInOrder(out,mRoot);
    } // end of print()
    
    private void traverseInOrder(PrintStream out, BSTNode node){
        if(node != null){
            traverseInOrder(out,node.left);
            out.printf("%s%s%d\n", node.data, printDelim, node.count);
            traverseInOrder(out,node.right);
        }
    }
    
    private void traversePreOrder(PrintStream out, BSTNode node){
        if(node != null){
            out.printf("%s%s%d\n", node.data, printDelim, node.count);
            traversePreOrder(out,node.left);
            traversePreOrder(out,node.right);
        }
    }
}