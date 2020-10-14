package by.it.hryntsaliou.jd01_12;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TaskA2 {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new TreeSet<>();
        Set<Integer> union = getUnion(a, b);
        System.out.println(union);
        Set<Integer> cross = getCross(a, b);
        System.out.println(cross);
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }
}
