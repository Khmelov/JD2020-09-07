package by.it.stefankin.jd01_11;
import java.util.*;


public class ListB<T>  implements List<T> {

    private T[] elems=(T[]) new Object[]{};
    private int size =0;

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("[");
        String delim="";
        for (int i = 0; i < size; i++) {
            sb.append(delim).append(elems[i]);
            delim=", ";
        }
        sb.append("]");

        return sb.toString();
    }

    @Override
    public boolean add(T t) {
        if (size==elems.length)
            elems= Arrays.copyOf(elems,(size*3)/2+1);
        elems[size++]=t;

        return false;
    }

    @Override
    public T remove(int index) {
        T del=elems[index];
        System.arraycopy(elems,index+1,elems,index,size-1-index);
        size--;
        return del;
    }

    @Override
    public T get(int index) {
        return elems[index];
    }

    @Override
    public void add(int index, T element) {
        if (size==elems.length)
            elems= Arrays.copyOf(elems,(size*3)/2+1);
        System.arraycopy(elems,index,elems,index+1,size-index);
        elems[index]=element;
        size++;

    }


    @Override
    public T set(int index, T element) {
       T rez=elems[index];
        elems[index]=element;
        return rez;
    }


    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] objarr = c.toArray();
        elems=Arrays.copyOf(elems,elems.length+objarr.length);
        System.arraycopy(objarr, 0, elems, size, objarr.length);
        size += objarr.length;
        return objarr.length !=0;
    }





//







    @Override
    public boolean remove(Object o) {
        int index= indexOf(o);
        if (index>-1) remove(index);
        return (index>-1);

    }



    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elems[i] == null)
                    return i;

        }   else {
            for (int i = 0; i < size; i++)
                if (o.equals(elems[i]))
                    return i;

        }

        return -1;
    }











    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }



    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }



}
