import java.util.*;
public class GenericArrayList<E> implements GenericList<E>{
    private List<E> list;
    private E[] test;
    public GenericArrayList(){
        list = new ArrayList<E>();
        //test = new E[0];
        test = (E[]) new Object[0];
    }
    
    public boolean add(E addMe){
        list.add(addMe);
        return true;
    }
    
    public void add(int index, E obj){
        if(index < 0)
          list.add(0, obj);
        else if(index > list.size()){
          list.add(obj);
        }
        else
          list.add(index, obj);

    }
    
    public boolean contains(E obj){
        for(int i = 0 ; i <list.size() ; i++)
        {
            if(list.get(i).equals(obj))
                return true;
        }
        return false;
    }
    
    public E get(int index){
        if(isEmpty())
        {
            return null;
        }
        if(index < 0 || index > list.size() - 1)
            return null;
        return list.get(index);
    }
    
    public boolean isEmpty(){
        if(list.size() == 0){
            return true;
        }
        return false;
    }
    
    public E remove(int index){
        if(!(index < 0 || index >= list.size()) && !isEmpty())
            return list.remove(index);
        return null;
    }
    
    public boolean remove(E obj){
        for(int i = 0 ; i < list.size() ; i++)
        {
            if(list.get(i).equals(obj))
            {
                remove(i);
                return true;
            }
        }
        return false;
     }
    
    public E set(int index, E obj){
        if(index < 0 || index > list.size() - 1)
            return null;
        return list.set(index, obj);
    }

    public int size(){
        return list.size();
    }
}