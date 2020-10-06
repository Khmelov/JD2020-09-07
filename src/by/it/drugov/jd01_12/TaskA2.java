package by.it.drugov.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new TreeSet<>();
        Set<Integer> crossResult = getCross(setA,setB);
        Set<Integer> unionResult = getUnion(setA,setB);

    }

    private static Set<Integer> getUnion(Set<Integer> setA,Set<Integer> setB) {
        Set<Integer> result = new HashSet<>(setA);
        result.addAll(setB);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> setA,Set<Integer> setB) {
        Set<Integer> result = new HashSet<>(setA);
        result.retainAll(setB);
        return result;
    }
}
