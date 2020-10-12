package by.it.trukhanovich.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1,2,3,4,5,5,6,6));
        Set<Integer> b = new HashSet<>(Arrays.asList(4,4,4,5,5,6,6,7,8,9));
        System.out.printf("a=%s\n",a);
        System.out.printf("b=%s\n",b);
        Set<Integer> union = getUnion(a, b);
        Set<Integer> cross = getCross(a, b);
        System.out.println(union);
        System.out.println(cross);
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        HashSet result = new HashSet(a);
        result.retainAll(b);
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        HashSet result = new HashSet(a);
        result.addAll(b);
        return result;

    }
}
