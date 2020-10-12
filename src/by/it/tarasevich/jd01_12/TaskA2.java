package by.it.tarasevich.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1,2,3,4,5,6,8));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5,6,7,8,9));
        System.out.printf("a=%s\nb=%s\n",a,b);
        Set<Integer> union = getUnion(a,b);
        System.out.println(union);

        Set<Integer> cross = getCross(a,b);
        System.out.println(cross);

    }



    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {

        HashSet<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }
    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

}
