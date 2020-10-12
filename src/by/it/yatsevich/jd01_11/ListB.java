package by.it.yatsevich.jd01_11;

import java.util.*;

class ListB <T> implements List<T> {
    private T[] elements= (T[]) new Object[]{};

    private int siz =0;

    @Override
    public boolean add(T t) {
        if (siz ==elements.length)
            elements= Arrays.copyOf(elements,(siz *3)/2+1);
        elements[siz++]=t;
        return false;
    }

    @Override
    public T remove(int index) {
        T delete =elements[index];
        System.arraycopy(elements,index+1,elements,index, siz -1-index);
        siz--;
        return delete;
    }

    @Override
    public T get(int index) {
        Object elem=elements[index];
        return (T) elem;
    }

    @Override
    public T set(int index, T element) {
        T backElem =elements[index];
        elements[index]=element;
        return backElem;
    }

    @Override
    public void add(int index, T element) {
        if (siz ==elements.length)
            Arrays.copyOf(elements,(siz *3)/2+1);
        System.arraycopy(elements,index,elements,index+1, siz -index);
        elements[index]=element;
        siz++;
    }
    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean changes = false;
        for (T t : c) {
            if (add(t))
                changes=true;
        }
        return changes;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index>-1) remove(index);
        return (index>-1);
    }

    @Override
    public int size() {
        return siz;
    }

    @Override
    public int indexOf(Object o) {
        if(Objects.isNull(o))   return -1;
        else for (int i = 0; i < siz; i++) {
            if (o.equals(elements[i]))
                return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder("[");
        String delimeter = "";
        for (int i = 0; i < siz; i++) {
            strB.append(delimeter).append(elements[i]);
            delimeter=", ";
        }strB.append("]");
        return strB.toString();
    }

    //not realised

    @Override
    public boolean isEmpty() {
        if (size()==0)return true;
        else return false;
    }

    @Override
    public boolean contains(Object o) {
        for (T element : elements) {
            if (element==o)return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[elements.length];
        for (int i = 0; i < elements.length; i++) {
            objects[i] = elements[i];
        }
        return objects;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int value=0;
        for (Object o : c) {
            if(contains(o)) value++;
        }
        if (value<=size())return true;
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
        for (Object element : elements) {
            element=null;
            siz=0;
        }
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
