import java.util.LinkedList;
public class MySet<E> implements Set<E>
{
    private LinkedList<E> list;
    public MySet()
      {
        list = new LinkedList<E>();
      }
    public boolean isEmpty()
    {
        if(list.isEmpty())
            return true;
        return false;
    }
    
    /**
     *    Return the number of elements in the Set
     */
    public int size(){
        return list.size();
    }
    
    /**
     *    Return true if this Set contains obj
     */
    public boolean contains(Object obj)
    {
        if(list.contains(obj))
            return true;
        return false;
    }
    
    /**
     *    Remove obj from this set.
     *    Return true if obj was removed from the set
     */
    public boolean remove(Object obj)
    {
        if(list.contains(obj)){
            list.remove(list.indexOf(obj));
            return true;
        }
        return false;
    }
    
    /**
     *    If the set does not alreay contain item:
     *        add item to the Set
     *        return true
     *    Otherwise, return false
     */
    public boolean add(E item)
    {
        if(list.contains(item))
            return false;
        list.add(item);
        return true;
    }
}

