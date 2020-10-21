package by.it.shkatula.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;



public class TaskA2 {

    private static Set<Integer> getCross(Set<Integer> one, Set<Integer> two) {
       Set<Integer> result = new HashSet<>(one);
       result.retainAll(two);
       return result;
    }
    private static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two) {
        Set<Integer> result = new HashSet<>(one);
        result.addAll(two);
        return result;
    }

    public static void main(String[] args) {
        HashSet<Integer> a = new HashSet<>(Arrays.asList(1,2,3,4,5,5,6,6,7));
        TreeSet<Integer> b = new TreeSet<>(Arrays.asList(9,8,7,6,6,4,5,5));
        System.out.println(getUnion(a,b));
        System.out.println(getCross(a,b));
    }
}
