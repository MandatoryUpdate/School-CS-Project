public class MyLinkedList<E> implements GenericList<E>
{
    private class Node<E>
    {
        private Node<E> next;
        private E value;
        public Node(E data)
        {
            value = data;
            next = null;
        }
        public E getValue()
        {
            return value;
        }
        public void setValue(E data)
        {
            value = data;
        }
        public Node<E> getNext()
        {
            return next;
        }
        public void setNext(Node<E> node)
        {
            next = node;
        }
    }
    private Node<E> head;
    public MyLinkedList()
    {
        head = new Node<E>(null);
    }
    public int size()
    {
        Node<E> n = head.getNext();
        int count = 0;
        while(n != null)
        {
            count++;
            n = n.getNext();
        }
        return count;
    }
    private int indexOf(E obj)
    {
        int spot = 0;
        Node<E> n = head.getNext();
        while(n != null && !n.getValue().equals(obj))
        {
            spot++;
            n = n.getNext();
        }
        if(n == null)
            return -1;
        return spot;
    }
    private Node<E> getNode(int index)
    {
        if(index < 0 || index >= size())
            return null;
        Node<E> n = head.getNext();
        int i = 0;
        while(n != null && i < index)
        {
            i++;
            n = n.getNext();
        }
        return n;
    }
    /**
     *    Add obj to the end of the list.
     *    This method always returns true
     */
    public boolean add(E obj)
    { 
        Node<E> n = head;
        while(n.getNext() != null)
        {
            n = n.getNext();
        }
        n.setNext(new Node<E>(obj));
        return true;
    }
    
    /**
     *    Add obj to the specified index of the list.
     *    If index is too big, then add obj to the end of the list
     *    If index is too small, then add obj to the start of the list
     */
    public void add(int index, E obj)
    {
        Node<E> n = new Node<>(obj);
        if(index < 0)
            add(0, obj);
        if(index == 0){
            Node<E> after = head.getNext();
            head.setNext(n);
            n.setNext(after);
        }
        else{
            Node<E> before = getNode(index - 1);
            Node<E> after = before.getNext();
            n.setNext(after);
            before.setNext(n);
        }
    }
    
    /**
     *    Return true is this list contains something that is .equals() to obj
     */
    public boolean contains(E obj)
    {
        Node<E> n = head.getNext();
        while(n != null)
        {
            if(n.getValue().equals(obj))
                return true;
            n = n.getNext();
        }
        return false;
    }
    
    /**
     *    Return the Object located at the specified index
     *    If index is too big or too small, return null
     */
    public E get(int index)
    {
        Node<E> n = getNode(index);
        return n != null?n.getValue():null;
    }
    
    /**
     *    Return true if there are no elements in the list
     */
    public boolean isEmpty()
    {
        return head.getNext() == null;
    }
    
    /**
    
    *    Remove the Object at the specified index from the list
     *    Return the Object that was removed
     *    If index is too big or to small, do not remove anything from the list and return null
     *  If the list is empty, return null
     */
    public E remove(int index)
    {
        if(index < 0 || index >= size() || isEmpty()){
            return null;
        }
        Node<E> old = getNode(index);
        if(index == 0){
            Node<E> after = old.getNext();
            head.setNext(after);
            return old.getValue();
        }
        Node<E> before = getNode(index - 1);
        Node<E> after = old.getNext();
        before.setNext(after);
        return old.getValue();
    }
    
    /**
     *    Remove the first Object that is .equals() to obj
     *    Return true if an object was removed
     */
    public boolean remove(E obj)
    {
        if(indexOf(obj) == -1)
            return false;
        if(obj == null)
            return false;
        int index = indexOf(obj);
        Node<E> old = getNode(index);
        if(index == 0){
            Node<E> after = old.getNext();
            head.setNext(after);
            return true;
        }
        Node<E> before = getNode(index - 1);
        Node<E> after = old.getNext();
        before.setNext(after);
        return true;
    }
    
    /**
     *    Change the value stored at index to obj
     *    Return the value that was replaced
     *    If index is too big or too smalll, do not change and values and return null
     */
    public E set(int index, E obj)
    {
        if(index < 0 || index >= size())
            return null;
        Node<E> n = getNode(index);
        E old = n.getValue();
        n.setValue(obj);
        return old;
    }
    
}