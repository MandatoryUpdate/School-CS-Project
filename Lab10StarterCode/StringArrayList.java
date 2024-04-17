public class StringArrayList extends MyArrayList implements StringList
{
    /**
     *    If obj is *not* an instanceof a String then this method should
     *    NOT add obj to the list and it should return false.
     *    Otherwise, it should do whatever MyArrayList does for this method.
     */
    public boolean add(Object obj)
    {
        //Do whatever MyArrayList does for this method
        if(obj instanceof String)
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
        if(obj instanceof String){
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
        if(obj instanceof String)
            return super.set(index, obj);
        return false;
    }
    
    public String getStr(int index)
    {
        return (String)get(index);
    }
    
    public String removeStr(int index)
    {
        return (String)remove(index);
    }
    
    public String setStr(int index, String str)
    {
        return (String)set(index, str);
    }
}