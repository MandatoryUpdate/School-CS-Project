public class IntegerArrayList extends MyArrayList implements IntegerList
{
    /**
     *    If obj is *not* an instanceof a String then this method should
     *    NOT add obj to the list and it should return false.
     *    Otherwise, it should do whatever MyArrayList does for this method.
     */
    public boolean add(Object obj)
    {
        //Do whatever MyArrayList does for this method
        if(obj instanceof Integer)
        {
            return super.add(obj);
        }
        return false;
    }
    
    /**
     *    If obj is *not* an instanceof a String then this method should
     *    NOT add obj to the list and it should return false.
     *    Otherwise, it should do whatever MyArrayList does for this method.
     */
    public void add(int index, Object obj)
    {
        //Do whatever MyArrayList does for this method
        if(obj instanceof Integer){
            super.add(index, obj);
        }
    }
    
    /**
     *    If obj is *not* an instanceof a String then this method should
     *    NOT set the value at index to obj and it should reutnr null.
     *    Otherwise, it should do whatever MyArrayList does for this method
     */
    public Object set(int index, Object obj)
    {
        //Do  whatever MyArrayList does for this method
        if(obj instanceof Integer)
            return super.set(index, obj);
        return false;
    }
    
    public Integer getInt(int index)
    {
        return (Integer)get(index);
    }
    
    public Integer removeInt(int index)
    {
        return (Integer)remove(index);
    }
    
    public Integer setInt(int index, Integer str)
    {
        return (Integer)set(index, str);
    }
}