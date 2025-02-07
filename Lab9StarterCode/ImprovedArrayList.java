 

public class ImprovedArrayList implements MyList
{
    private int size;
    private Object[] data;
    
    public ImprovedArrayList()
    {
        // Let the other constructor do the work!
        this(0);
    }

    public ImprovedArrayList(int x)
    {
        size = 0;
        data = new Object[x];
    }

    private boolean outOfBounds(int index){
        return index<0 || index>=size;
    }
    
    /**
     * Add obj to the end of the list.
     * This method always returns true
     */
    public boolean add(Object obj)
    {
        if(size==0){
            data=new Object[1];
        }
        else if(size==data.length){
            Object[] newData=new Object[data.length*2];
            for(int i=0;i<size;i++){
                newData[i]=data[i];
            }
            data=newData;
        }
        if(size>data.length){
            Object[] newArr=new Object[data.length*2];
            for(int i=0;i<size;i++){
                newArr[i]=data[i];
            }
            data=newArr;
        }
        data[size]=obj;
        size++;
        return true;        
    }

    /**
     * Add obj to the specified index of the list.
     * If index is too big, then add obj to the end of the list
     * If index is too small, then add obj to the start of the list
     */
    public void add(int index, Object obj)
    {
        if(index==size){
            add(obj);
            return;
        }
        if(outOfBounds(index)){
            return;
        }
        if(size==0){
            data=new Object[1];
        }
        else if(size==data.length){
            Object[] newData=new Object[data.length*2];
            for(int i=0;i<size;i++){
                newData[i]=data[i];
            }
            data=newData;
        }
        for(int i=size;i>index;i--){
            data[i]=data[i-1];
        }
        data[index]=obj;
        size++;
    }

    /**
     * Return true is this list contains something that is .equals() to obj
     */
    public boolean contains(Object obj)
    {
        for(Object o:data){
            if(o!=null && o.equals(obj)){
                return true;
            }
        }
        return false;
    }

    /**
     * Return the Object located at the specified index
     * If index is too big or too small, return null
     */
    public Object get(int index)
    {
        if(outOfBounds(index) || size==0){
            return null;
        }
        return data[index];
    }

    /**
     * Return true if there are no elements in the list
     */
    public boolean isEmpty()
    {
        if(size==0){
            return true;
        }
        return false;
    }

    /**
     * Remove the Object at the specified index from the list
     * Return the Object that was removed
     * If index is too big or to small, do not remove anything from the list and return null
     */
    public Object remove(int index)
    {
        System.out.println(index);
        if(outOfBounds(index) || size==0){
            return null;
        }
        Object old=null;
        for(int i=0;i<size;i++){                                                        
            if(i>index){
                data[i-1]=data[i];
            }
            else{
                old=data[i];
            }
        }
        size--;
        return old;
    }

    /**
     * Remove the first Object that is .equals() to obj
     * Return true if an object was removed
     */
    public boolean remove(Object obj)
    {
        //HINT: Find the index of obj and then call remove(int index)
        for(int i=0;i<size;i++){
            if(data[i].equals(obj)){
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Change the value stored at index to obj
     * Return the value that was replaced
     * If index is too big or too smalll, do not change and values and return null
     */
    public Object set(int index, Object obj)
    {
        if(outOfBounds(index) || size==0){
            return null;
        }
        Object old=data[index];
        data[index]=obj;
        return old;
    }

    /**
     * Return the number of elements that are in the list
     */
    public int size()
    {
        // HINT: Do you have a variable that holds the size?
        return size;
    }
}
