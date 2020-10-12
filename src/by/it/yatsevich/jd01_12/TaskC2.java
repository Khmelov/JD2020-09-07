package by.it.yatsevich.jd01_12;

import java.util.*;

public class TaskC2 {

    static Set<?> getUnion(Set<?> one,Set<?> two,Set<?> tree){
        HashSet<Object> result = new HashSet<>(one);
        result.addAll(two);
        result.addAll(tree);
        return result;
    }
    static Set<?> getCross(Set<?> one,Set<?> two,Set<?> tree) {
        HashSet<Object> result = new HashSet<>(one);
        result.retainAll(two);
        result.retainAll(tree);
        return result;
    }

    public static void main(String[] args) {
        Set<Long> a= new TreeSet<>(Arrays.asList(1L, 1L, 2L, 2L, 3L, 3L, 4L, 4L, 5L, 5L, 5L, 6L, 6L, 7L));
        Set<Byte> b= new HashSet<>(Arrays.asList((byte)8,(byte) 8,(byte) 9,(byte) 9,(byte) 10,(byte) 3,(byte) 4,(byte) 4,(byte) 5,(byte) 5,(byte) 5,(byte) 6,(byte) 6,(byte) 7));
        Set<Float> c= new HashSet<>(Arrays.asList(8f, 8f, 9f, 9f, 1f, 3f, 4f, 4f, 5f, 5f, 5f, 6f,7f,11f,14f,15f,15f,17f,19f));
        System.out.println(getUnion(a,b,c));
        System.out.println(getCross(a,b,c));
    }

}
