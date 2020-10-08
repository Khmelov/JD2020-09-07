package by.it.trukhanovich.jd01_12;

import java.util.*;

public class TaskC2 {
    public static void main(String[] args) {
        Set<Long> a = new HashSet<Long>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        Set<Long> b = new HashSet<Long>(Arrays.asList(4L, 5L, 6L, 7L, 8L, 9L));
        Set<Long> c = new HashSet<Long>(Arrays.asList(4L, 5L, 10L, 11L, 12L, 13L));
        Set<Double> d = new HashSet<Double>(Arrays.asList(4., 5., 20., 21.));

        System.out.printf("a=%s\n",a);
        System.out.printf("b=%s\n",b);
        System.out.printf("b=%s\n",c);
        System.out.printf("b=%s\n",d);
//        Comparator<Number> numberComparator = new Comparator<Number>() {
//            @Override
//            public int compare(Number o1, Number o2) {
//                if (o1.doubleValue()>o2.doubleValue()) return 1;
//                if (o1.doubleValue()<o2.doubleValue()) return -1;
//                if (o1.doubleValue()==o2.doubleValue()) return 0;
//                return -2;
//            }
//
//            @Override
//            public boolean equals(Object obj) {
//
//                return false;
//            }
//        };
        Set<Number> union = getUnion(d, a, b, c);
        Set<Number> cross = getCross(d, a, b, c);
        System.out.println(union);
        System.out.println(cross);

    }

//    private static Set<Number> getCross(Set<?extends Number>...args) {
//        HashSet result = new HashSet(args[0]);
//        for (int i = 1; i < args.length; i++) {
//            result.retainAll( args[i]);
//        }
//        return result;
//    }
//    private static Set<Number> getUnion(Comparator comparator, Set<?extends Number>...args) {
//        Set <Number>result = new TreeSet(comparator);
//        for (int i = 1; i < args.length; i++) {
//            result.addAll(args[i]);
//    }
//        return result;
//}
    private static Set<Number> getCross(Set<?extends Number>...args) {
        HashSet result = new HashSet();
        for (int i = 0; i < args.length; i++) {
            HashSet buffer = new HashSet <Double>();
            Iterator<? extends Number> it = args[i].iterator();
            while (it.hasNext()){
                double k= it.next().doubleValue();
                buffer.add(k);
                if (i==0) {result.add(k);}
            }
            result.retainAll( buffer);
            buffer.clear();
        }
        return result;
    }

    private static Set getUnion(Set<?extends Number>...args) {
        HashSet result = new HashSet <Double>();
        for (int i = 0; i < args.length; i++) {
            Iterator<? extends Number> it = args[i].iterator();
            while (it.hasNext()){
                double k= it.next().doubleValue();
                result.add(k);
            }
        }
        return result;
    }
}
