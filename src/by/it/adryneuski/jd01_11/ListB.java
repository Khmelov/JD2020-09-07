package by.it.adryneuski.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T t) {
        if(size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);;
        }
        elements[size++] = t;
        return true;
    }

    @Override
    public T remove(int index) {
        T deleted = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return deleted;
    }

    @Override
    public int indexOf(Object o) {
        if (Objects.isNull(o))
            return -1;
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i]))
                return i;
        }
        return -1;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if(index > -1) remove(index);
        return (index > -1);
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public void add(int index, T element) {
        if(size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        System.arraycopy(elements, index, elements, index+1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public T set(int index, T element) {
        T deleted = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        if(size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        System.arraycopy(elements, index, elements, index+1, size - index);
        elements[index] = element;
        size++;
        return deleted;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T element : c) {
            if(size == elements.length) {
                elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
            }
            elements[size++] = element;
        }
        return true;
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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if(i>0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
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
