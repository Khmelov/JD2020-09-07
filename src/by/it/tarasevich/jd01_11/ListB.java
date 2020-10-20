package by.it.tarasevich.jd01_11;

import java.util.*;

public class ListB <T> implements List<T> {
    private T[] elements= (T[]) new Object[]{};

    private int size=0;


    @Override
    public boolean add(T t) {
        if (size==elements.length)
        {
            elements= Arrays.copyOf(elements,elements.length * 3 / 2 + 1);
        }
        elements[size++]=t;
        return true;
    }

    @Override
    public T remove(int index) {
        T element=elements[index];
        System.arraycopy(elements,index+1,elements,index,size-index-1);
        size--;
        return element;

    }

    @Override
    public T get(int index) {
        return elements[index];
    }
    @Override
    public String toString() {
        StringBuilder out=new StringBuilder();
        out.append("[");
        for (int i = 0; i < size; i++) {
            if (i>0) {
                out.append(", ");
            }
            out.append(elements[i]);
        }
        out.append("]");
        return out.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T set(int index, T element) {
        T old=elements[index];
        elements[index]=element;
        return old;
    }
    @Override
    public void add(int index, T element) {
        elements=Arrays.copyOf(elements,elements.length * 3 / 2 + 1);
        size++;
        for (int i = size-1; i >index; i--) {
            elements[i]=elements[i-1];
        }
        elements[index]=element;
    }
    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] a = c.toArray();
        elements=Arrays.copyOf(elements,elements.length+a.length);
        System.arraycopy(a, 0, elements, size, a.length);
        size += a.length;
        return a.length != 0;
    }

    @Override
    public boolean contains(Object o) {
        for (T element : elements) {
            if (element == o) return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
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
    public int indexOf(Object o) {
        return 0;
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
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
