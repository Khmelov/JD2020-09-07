package by.it.stefankin.jd01_12;

import java.util.*;

public class TaskA2 {

    public static void main(String[] args) {

        Integer[] val1={7,8,6,4,5,7,12,4,3,2,8,1,9};
        List<Integer> integers1 = Arrays.asList(val1);
        Set<Integer> hashSet1 = new HashSet<>(integers1);

        Integer[] val2={1,2,3,4,5,6,7,8,9,10,11,13};
        List<Integer> integers2 = Arrays.asList(val2);
        Set<Integer> treeSet2 = new TreeSet<>(integers2);

        Set<Integer> union =getUnion(hashSet1,treeSet2);
        System.out.printf("hashset1=%s\ntreeset2=%s\nunion=%s\n",hashSet1,treeSet2,union);


        Set<Integer> cross =getCross(hashSet1,treeSet2);
        System.out.printf("hashset1=%s\ntreeset2=%s\ncross=%s\n",hashSet1,treeSet2,cross);
    }

    private static Set<Integer> getUnion(Set<Integer> hashSet1, Set<Integer> treeSet2) {
        Set<Integer> result =new HashSet<>(hashSet1);
        result.addAll(treeSet2);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> hashSet1, Set<Integer> treeSet2) {
        Set<Integer> result2 =new HashSet<>(hashSet1);
        result2.retainAll(treeSet2);
        return result2;
    }

}
