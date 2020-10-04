package by.it.hryntsaliou.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T t) {
        if(contains(t)) return false;
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int index = 0; index < size; index++) {
            if (elements[index] == o) {
                System.arraycopy(elements, index + 1, elements, index, size - index - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (T element : elements) {
            if(element == o) return true;
        }
        return false;
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
    public boolean addAll(Collection<? extends T> c) {
        int count = 0;
        for (T element : c) {
            if(add(element)) count++;
        }
        if(count<=c.size()) return true;
        else return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int count = 0;
        for (Object element : c) {
            if(contains(element)) count++;
        }
        if(count<=c.size()) return true;
        else return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int count = 0;
        for (Object element : c) {
            if(remove(element)) count++;
        }
        if(count<=c.size()) return true;
        else return false;
    }

    @Override
    public void clear() {
        size = 0;
        Arrays.fill(elements, null);
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
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
