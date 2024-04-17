import java.util.LinkedList;

public class MyStack<E> implements Stack<E>
{
    private LinkedList<E> list;
    public MyStack()
      {
        list = new LinkedList<E>();
      }

    public E peek()
    {
        if(isEmpty())
            return null;
        return list.get(0);
    }
    
    /**
     *    Add item to the top of the Stack
     */
    public void push(E item)
    {
        list.add(0, item);
    }
    
    /**
     *    Remove the Object from the top of the Stack and return it
     *    If the Stack is empty, return null
     */
    public E pop()
    {
        if(isEmpty())
        {
            return null;
        }
        return list.remove();
    }
    
    /**
     *    Return true is this Stack is empty
     */
    public  boolean isEmpty()
    {
        return list.isEmpty();
    }
    
    /**
     *    Return the number of Objects that are in this Stack
     */
    public int size()
    {
        return list.size();
    }
}