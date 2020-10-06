package by.it.trukhanovich.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskC2 {
    public static void main(String[] args) {
        Set<Number> a = new HashSet<>(Arrays.asList(1,2,3,4,5,5,6,6));
        Set<Number> b = new HashSet<>(Arrays.asList(4,4,4,5,5,6,6,7,8,9));
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
