package by.it.trukhanovich.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    private T[] elements= (T[]) new Object[]{};

    private int size=0;

    @Override
    public boolean contains(Object o) {
        for (T element : elements) {
//            if (element.equals(o)) return true;
            if(element==o) return true;
        }
        return false;
    }

    @Override
    public boolean add(T t) {
        if (size>0) {
            for (int i = 0; i <size; i++) {
            if (elements[i]==t) return false;
            }
        }
        if (size==0||size==elements.length)
        {
            elements=Arrays.copyOf(elements,elements.length * 3 / 2 + 1);
        }
        elements[size]=t;
        size++;
        return true;

    }
    @Override
    public int size() {
        return size;
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
    public boolean remove(Object o) {

        if (size==0) return false;
        for (int index = 0; index < size; index++) {
            if (elements[index].equals(o)) {
                System.arraycopy(elements, index + 1,
                            elements, index, size - index - 1);
                size--;
                return true;
                }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (size==0) return true;
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] a = c.toArray();
//        elements=Arrays.copyOf(elements,elements.length+a.length);
        boolean det = true;
        boolean det1 = true;
        int oldSize = size;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < size; j++) {
                    if (elements[j]==a[i]) {
                        det = false;
                    }
                }
                if (det) {
                    elements = Arrays.copyOf(elements, elements.length + 1);
                    System.arraycopy(a, i, elements, size, 1);
                    size++;
                }
                det = true;
            }
//        }
        return size != oldSize;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] a = c.toArray();
        boolean[] check = new boolean[a.length];
        for (T element : elements) {
            for (int i = 0; i < a.length; i++) {
                if(element==a[i]) check[i]=true;
            }
        }
        for (boolean b : check) {
            if (b==false) return false;
        }
        return true;
    }

    //no impl

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
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
