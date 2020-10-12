package by.it.mialeshka.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    public String toString(){
        StringBuilder str = new StringBuilder("[");
        String delimeter = "";
        for (int i = 0; i < size; i++) {
            str.append(delimeter).append(elements[i]);
            delimeter = ", ";
        }
        str.append("]");
        return str.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if(o == null){
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return true;
            }
        }
        else{
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) return true;
            }
        }
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
    public boolean add(T t) {
        if(!contains(t)) {
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, (elements.length * 3) / 2 + 1);
            }
            elements[size++] = t;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > -1){
            System.arraycopy(elements, index+1, elements, index, size-1-index);
            size--;
            }
            return index > -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        T[] addArray = (T[])c.toArray();
        for (int i = 0; i < addArray.length; i++) {
            if(!contains(addArray[i])) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] addArray = (T[])c.toArray();
        boolean result = false;
        for (int i = 0; i < addArray.length; i++) {
            if(!contains(addArray[i])){
                add(addArray[i]);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        T[] arrDel = (T[]) c.toArray();
        for (int i = 0; i < arrDel.length; i++) {
            remove(arrDel[i]);
        }
        return true;
    }

    @Override
    public void clear() {
        T[] arrDel = Arrays.copyOf(elements, size);
        for (int i = 0; i < arrDel.length; i++) {
            remove(arrDel[i]);
        }
    }

    private int indexOf(Object o) {
        if(o == null){
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(o)){
                    return i;
                }
            }
        }
        return -1;
    }
}
