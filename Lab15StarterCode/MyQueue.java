import java.util.LinkedList;

public class MyQueue<E> implements Queue<E>
{
    private LinkedList<E> list;
    public MyQueue()
      {
        list = new LinkedList<E>();
      }
    
    /**
     *    Return the Object at the beginning of this Queue
     *    If the Queue is empty, return null
     */
    public E peek()
    {
        if(isEmpty())
            return null;
        return list.get(0);
    }
    
    /**
     *    Add obj to the end of this Queue
     */
    public boolean add(E obj)
    {
        return list.add(obj);
    }
    
    /**
     *    Remove the Object from the front of this Queue and return it.
     *    If the Queue is empty, return null
     */
    public E remove()
    {
        if(isEmpty())
            return null;
        return list.remove(0);
    }
    
    /**
     *    Return true if this Queue is empty
     */
    public boolean isEmpty()
    {
        return list.isEmpty();
    }
    
    /**
     *    Return the number of Objects in this Queue
     */
    public int size()
    {
        return list.size();
    }
}