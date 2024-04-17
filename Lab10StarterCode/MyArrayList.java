public class MyArrayList implements MyList{
    private Object[] data;
    
    public MyArrayList(){
        data = new Object[0];
    }
    
    public boolean add(Object addMe){
        Object[] newArr = new Object[data.length + 1];
        for(int i = 0 ; i < data.length; i++)
        {
            newArr[i] = data[i];
        }
        newArr[newArr.length - 1] = addMe;
        data = newArr;
        return true;
    }
    
    public void add(int index, Object obj){
        Object[] newArr = new Object[data.length + 1];
        for(int i = 0 ; i < newArr.length ; i++){
            if(i < index)
                newArr[i] = data[i];
            else if(i > index){
                newArr[i] = data[i-1];
            }
            else
                newArr[i] = obj;
        }
        data = newArr;
    }
    
    public boolean contains(Object obj){
        for(int i = 0 ; i <data.length ; i++)
        {
            if(data[i].equals(obj))
                return true;
        }
        return false;
    }
    
    public Object get(int index){
        if(index < 0 || index > data.length - 1)
            return null;
        return data[index];
    }
    
    public boolean isEmpty(){
        if(data.length == 0)
            return true;
        return false;
    }
    
    public Object remove(int index){
        if(index < 0 || index >= data.length)
            return null;
        if(data.length == 0)
            return null;
        Object old = null;
        Object[] newArr = new Object[data.length - 1];
        for(int i = 0 ; i < data.length ; i++)
        {
            if(i < index)
                newArr[i] = data[i];
            else if(i > index)
                newArr[i-1] = data[i];
            else
                old = data[i];
        }
        data = newArr;
        return old;
    }
    
    public boolean remove(Object obj){
        for(int i =0; i<data.length;i++){
            if(data[i]==null){
                return false;
            }
        }
        if(obj==null){
            return false;
        }
        Object[] newArr = new Object[data.length-1];
        for(int i = 0;i<data.length;i++){
            if(data[i].equals(obj)){
                for(int j = 0; j<i;j++){
                    newArr[j] = data[j];
                }
                for(int j = i;j<data.length-1;j++){
                    newArr[j] = data[j+1];
                }
                data = newArr;
                return true;
            }
        }
        return false;
        
     }
    
    public Object set(int index, Object obj){
        if(index < 0 || index > data.length - 1)
            return null;
        Object stuff = data[index];
        data[index] = obj;
        return stuff;
    }

    public int size(){
        return data.length;
    }
}