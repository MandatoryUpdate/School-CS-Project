import java.util.List;

public class BST<E extends Comparable>
{
    private BNode<E> root;
    
    public BST() 
    {
        root = null;
    }
    
    //add data to this BST
    public void add(E data)
    {
        if(root == null){
            root = new BNode<E>(data);
        }
        else{
            addHelper(root,new BNode<E>(data));
        }
    }
    
    //Recursive helper method for add
    private void addHelper(BNode<E> node, BNode<E> addMe)
    {
        if(addMe.getData().compareTo(node.getData())<0){
            if(node.getLeft() != null){
                addHelper(node.getLeft(),addMe);
            }
            else{
                node.setLeft(addMe);
            }
        }
        else{
            if(node.getRight() != null){
                addHelper(node.getRight(),addMe);
            }
            else{
                node.setRight(addMe);
            }
        }
    }
    
    public void addAll(List<E> data)
    {
        for(E d:data){
            add(d);
        }
    }
    
    //reutrn the size of this tree (how many nodes are in it?)
    public int size()
    {
        return sizeHelper(root);
    }
    
    //recursive helper method for size
    public int sizeHelper(BNode<E> node)
    {
        if(node == null){
            return 0;
        }
        int left = sizeHelper(node.getLeft());
        int right = sizeHelper(node.getRight());
        return 1 + left + right;
    }
    
    //Return a string with the data of this BST in pre order
    public String preorder()
    {
        String temp = preorderHelper(root,"");
        return "[" + temp.substring(0,temp.length() - 2) + "]";    
    }
    
    //Recursive helper method for preorder
    private String preorderHelper(BNode<E> node, String ret)
    {
        ret += node.getData() + ", ";
        if(node.hasLeftChild()){
            ret = preorderHelper(node.getLeft(), ret);
        }
        if(node.hasRightChild()){
            ret = preorderHelper(node.getRight(), ret);
        }
        return ret;
    }
    
    //Return a string with the data of this BST in order
    public String inorder()
    {
        String temp = inorderHelper(root,"");
        return "[" + temp.substring(0,temp.length() - 2) + "]";    
    }
    
    //Recursive helper method for inorder
    private String inorderHelper(BNode<E> node, String ret)
    {
        if(node.hasLeftChild()){
            ret = inorderHelper(node.getLeft(), ret);
        }
        ret += node.getData()+", ";
        if(node.hasRightChild()){
            ret = inorderHelper(node.getRight(), ret);
        }
        return ret;
    }
    
    //Return a string with the data of this BST in post order
    public String postorder()
    {
        String temp = postorderHelper(root,"");
        return "[" + temp.substring(0,temp.length() - 2) + "]";    
    }
    
    //Recursive helper method for postorder
    private String postorderHelper(BNode<E> node, String ret)
    {
        if(node.hasLeftChild()){
            ret = postorderHelper(node.getLeft(),ret);
        }
        if(node.hasRightChild()){
            ret = postorderHelper(node.getRight(),ret);
        }
        ret += node.getData() + ", ";
        return ret;
    }
    
    //Check if this BST contains the specified data
    public boolean contains(E data)
    {
        return containsHelper(root, data);
    }
    
    //Recursive helper method for contains
    private boolean containsHelper(BNode<E> node, E data)
    {
        if(node == null){
            return false;
        }
        if(node.getData().equals(data) || containsHelper(node.getRight(),data)){
            return true;
        }
        return containsHelper(node.getLeft(),data);
    }
    
    //Remove the first occurance of data from this BST tree.
    //If data is successfully removed return true, otherwise return false.
    public boolean remove(E data) {        
        BNode<E> node = root;
        BNode<E> parent = null;
        while(node != null && !(node.getData().equals(data)))
        {
            parent = node;
            if(data.compareTo(node.getData()) < 0)
            {
                node = node.getLeft();
            }
            else if(data.compareTo(node.getData()) > 0)
            {
                node = node.getRight();
            }
            else if(node == null)
            {
                return false;
            }
        }
        if(node == null)
            return false;
        if(node.getNumChildren() == 0)
        {
            if(parent.getRight() == node)
            {
                parent.setRight(null);
            }
            else{
                parent.setLeft(null);
            }
        }
        if(node.getNumChildren() == 1){
            if (parent.getLeft() == node){
                parent.setLeft(node.getLeft());
                parent.setLeft(node.getRight());
            }
            else{
                parent.setRight(node.getLeft());
                parent.setRight(node.getRight());
            }
        }
        if (node.getNumChildren() == 2){
            BNode<E> combined = combine(node.getLeft(), node.getRight());
            if (node == root){
                root = combined;
            }
            else if (parent.getLeft()==node){
                parent.setLeft(combined);
            }else{
                parent.setRight(combined);
            }
        }
        return true;
    }


    //Recursive helper method for remove. Removes the smallest descendant from the specified node.
    public BNode<E> removeSmallestChild(BNode<E> node)
    {
        if(!node.hasChildren() || node.hasRightChild() && !node.hasLeftChild()) {
            return node;
        }
        BNode<E> smallLeft = node.getLeft();
        if(node.hasLeftChild())
        {
            removeSmallestChild(smallLeft);
        }
        node.setLeft(smallLeft.getRight());
        return smallLeft;
    }
    
    //Helper method for remove. Reforms the left and right subtrees into a single
    //BST and returns its root node.
    public BNode<E> combine(BNode<E> left, BNode<E> right)
    {
        BNode<E> x = removeSmallestChild(right);
        if(x == right)
            right = right.getRight();
        x.setLeft(left);
        x.setRight(right);
        return x;
    }
    
    ///////////////////
    //    Helper Class //
    ///////////////////
    class BNode<E extends Comparable>
    {
        private E data;
        private BNode<E> left, right;
        
        public BNode(E data)
        {this.data = data;}
        
        public E getData()
        {return data;}
        
        public BNode<E> getLeft()
        {return left;}
        
        public BNode<E> getRight()
        {return right;}
        
        public void setLeft(BNode<E> left)
        {this.left = left;}
        
        public void setRight(BNode<E> right)
        {this.right = right;}
        
        public boolean hasLeftChild()
        {return null != left;}
        
        public boolean hasRightChild()
        {return null != right;}
  
          public boolean hasChildren()
          {return getNumChildren() > 0;}
          
          public int getNumChildren()
          {
              int ret = 0;
              if(hasLeftChild())  ret++;
              if(hasRightChild()) ret++;
              return ret;
          }
    }
}