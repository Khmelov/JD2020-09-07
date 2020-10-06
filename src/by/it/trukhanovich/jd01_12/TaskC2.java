package by.it.trukhanovich.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskC2 {
    public static void main(String[] args) {
        Set<Number> a = new HashSet<Number>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        Set<Number> b = new HashSet<Number>(Arrays.asList(4L, 5L, 6L, 7L, 8L, 9L));
        Set<Number> c = new HashSet<Number>(Arrays.asList(8L, 9L, 10L, 11L, 12L, 13L));
        Set<Number> d = new HashSet<Number>(Arrays.asList(2., 3., 4., 9.));
        System.out.printf("a=%s\n",a);
        System.out.printf("b=%s\n",b);
        Set<Number> union = getUnion(a, b);
        Set<Number> cross = getCross(a, b);
        System.out.println(union);
        System.out.println(cross);
    }

    private static Set<Number> getCross(Set<Number> a, Set<Number> b) {
        HashSet result = new HashSet(a);
        result.retainAll(b);
        return result;
    }

    private static Set<Number> getUnion(Set<Number> a, Set<Number> b) {
        HashSet result = new HashSet(a);
        result.addAll(b);
        return result;

    }
}
