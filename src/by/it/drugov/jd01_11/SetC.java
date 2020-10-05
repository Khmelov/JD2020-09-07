package by.it.drugov.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            line.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        line.append(']');
        return line.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (T element : elements) {
            if (element == o)
                return true;
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
        if (contains(t))
            return false;
        if (size == elements.length)
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        elements[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean flag = false;
        Object[] element = c.toArray();
        for (int i = 0; i < c.size(); i++) {
            if(contains(element[i]))
                flag = true;
        }
        return flag?true:false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T element : c) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] element = c.toArray();
        for (int i = 0; i < c.size(); i++) {
            if(contains(element[i]))
                remove(element[i]);
        }
        return true;
    }

    @Override
    public void clear() {
        removeAll(Arrays.asList(elements));
    }
}
