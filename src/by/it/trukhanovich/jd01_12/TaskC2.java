package by.it.trukhanovich.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskC2 {
    public static void main(String[] args) {
        Set<Long> a = new HashSet<Long>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        Set<Long> b = new HashSet<Long>(Arrays.asList(4L, 5L, 6L, 7L, 8L, 9L));
        Set<Long> c = new HashSet<Long>(Arrays.asList(4L, 5L, 10L, 11L, 12L, 13L));
        Set<Double> d = new HashSet<Double>(Arrays.asList(4., 5., 20., 21.));

        System.out.printf("a=%s\n",a);
        System.out.printf("b=%s\n",b);
        Set<Number> union = getUnion(a, b, c,d);
        Set<Number> cross = getCross(a, b,c,d);
        System.out.println(union);
        System.out.println(cross);
        Number x=10;
        Number y=10.0;
        if (x.doubleValue()== y.doubleValue()) System.out.println("ДА doubleValue");
        if (x.equals(y)) System.out.println("да equals");
        if ((Number) x==(Number) y) System.out.println("да==");
    }

    private static Set<Number> getCross(Set<?extends Number>...args) {
        HashSet result = new HashSet(args[0]);
        for (int i = 1; i < args.length; i++) {
            result.retainAll( args[i]);
        }
        return result;
    }

    private static Set<Number> getUnion(Set<?extends Number>...args) {

        HashSet result = new HashSet(args[0]);
        for (int i = 1; i < args.length; i++) {

            result.addAll(args[i]);
        }
        return result;

    }

}
