import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> implements Map<K, V>
{
    private List<Map.Node<K, V>>[] arr;
    
    public HashMap()
    {
        this(10);
    }
    
    @SuppressWarnings("unchecked")
    public HashMap(int n)
    {
        arr = (ArrayList<Map.Node<K, V>>[])new ArrayList[n];
        
        //populate the array with Lists
        for(int i = 0; i < arr.length; i++)
            arr[i] = new ArrayList<Map.Node<K, V>>();
    }
    
    /*
     *    Helper Method: Calculate the index that an object will be stored in an array using its hashCode
     *
     *    Returns the index where key belongs in the instance variable array using the key's hashCode
     *    Becareful about objects that have a negative hashCode! Remember, you can't have a negative index!
     */
    private int getIndex(Object key)
    {
        int index = key.hashCode();        //convert key to int
        index = Math.abs(index);            //make sure index is not negative
        index = index % arr.length;
        return index;
    }
    
    /*
     *    Return true if this map contains the specified key
     *    Precondition: key != null
     */
    public boolean containsKey(Object key)
    {
        int index = key.hashCode();        //convert key to int
        index = Math.abs(index);            //make sure index is not negative
        index = index % arr.length;        //make sure index is not too big
        List<Map.Node<K, V>> nodes = arr[index]; //get the List of values from arr
        for(Map.Node<K, V> node: nodes){
           if(node.getKey().equals(key))
              return true;
        }
        return false;
    }
    
    /*
     *    Return true if this map contins the specified value
     *    Precondition: value != null
     */
    public boolean containsValue(Object value)
    {
        for(List<Map.Node<K, V>> nodes : arr)
        {
            for(Map.Node<K, V> node : nodes)
            {
                if(node.getValue().equals(value))
                    return true;
            }
        }
        return false;
    }
    
    /*
     *    Return true is this map contains no Nodes
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }
    
    /*
     *    Return the number of Nodes this map contains
     */
    public int size()
    {
        int total = 0;
        for(int i = 0 ; i < arr.length ; i++)
        {
            total+= arr[i].size();
        }
        return total;
    }
    
    /*
     *    Return the value of the Node that has the specified key
     *    If there is no Node with the specified key, then return null
     */
    public V get(Object key)
    {
        int index = key.hashCode();        //convert key to int
        index = Math.abs(index);            //make sure index is not negative
        index = index % arr.length;        //make sure index is not too big
        List<Map.Node<K, V>> nodes = arr[index]; //get the List of values from arr
        for(Map.Node<K, V> node: nodes){
           if(node.getKey().equals(key))
              return node.getValue();
        }
        return null;
    }
    
    /*
     *    Associate the specified value with the specified key
     *    If the map already contains the specified key, the replace 
     *    the value of that key and return the original value.
     *    Otherwise add a new Node to the map and return null.
     *    Precondition: key != null && value != null
     */
    public V put(K key, V value)
    {
        int index = getIndex(key);
        List<Map.Node<K, V>> nodes = arr[index];

        for(Map.Node<K, V> node: nodes){
           if(node.getKey().equals(key))
                return node.setValue(value);
        }  //Found the node; set the value; return old value
        nodes.add(new Map.Node<K, V>(key, value)); //never found the node; make a new one
        return null;
    }
    
    /*
     *    Remove the association for the specified key from this map.
     *    Return the value that was associated with the specified key
     *    Or return null if no value was associated with the key.
     *    Precondition: key != null
     */
    public V remove(Object key)
    {
        int index = key.hashCode();        //convert key to int
        V value = get(key);
        index = Math.abs(index);            //make sure index is not negative
        index = index % arr.length;        //make sure index is not too big
        for(Map.Node<K, V> node: arr[index]){
           if(node.getKey().equals(key)){
              arr[index].remove(node);
              return value;
           }
        }
        return null;
    }
    
    /*
     *    Return a List<V> of the values that are stored in this map
     */
    public List<V> values()
    {
        List<V> vals = new ArrayList<V>();
        for(List<Map.Node<K, V>> nodes : arr)
        {
            for(Map.Node<K, V> node: nodes)
            {
                vals.add(node.getValue());
            }
        }
        return vals;
    }
    
    /*
     *    Return a Set<E> of the keys that have associations in this map
     */
    public Set<K> keySet()
    {
        Set<K> ret = new ListSet<K>();
        for(List<Map.Node<K, V>> nodes : arr){
           for(Map.Node<K, V> node : nodes){
              ret.add(node.getKey());
            }
        }
        return ret;
    }
}