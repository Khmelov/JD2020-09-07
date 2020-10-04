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
        if (contains(t)) return false;
//            for (int i = 0; i <size; i++) {
//            if (elements[i]==t) return false;
//            }

        if (size==elements.length)
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
            if (elements[index]==o) {
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
        boolean flag=false;
        for (Object o : c) {
            if (add((T) o)) flag=true;
        }
        return flag;
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

    @Override
    public boolean removeAll(Collection<?> c) {
        if (containsAll(c)&&c.containsAll(Arrays.asList(elements))) {clear(); return true;}
        if (c.isEmpty()) return false;
        boolean [] flags=new boolean[c.size()];
        int i=0;
        for (Object object : c) {
             if (remove(object)) flags[i++]=true;
        }
        for (boolean b : flags) {
                if (b==false) return true;
        }
        return true;

        //ПЕРВОНАЧАЛЬНЫЙ ВАРИАНТ
//        Object[] a = c.toArray();
//        boolean[] check = new boolean[a.length];
//        if (size==0) return false;
//        for (int index = 0; index < size; index++) {
//            for (int j = 0; j < a.length; j++) {
//                if (elements[index] == a[j]) {
//                    remove(a[j]);
//                    System.arraycopy(elements, index + 1,
//                            elements, index, size - index - 1);
//                    size--;
//                    check[j] = true;
//                    continue;
//                }
//            }
//        }
//        for (boolean b : check) {
//                if (b==false) return false;
//        }
//        return true;
    }

    //no impl

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
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
    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i]=null;
        }
        size=0;
    }
}
