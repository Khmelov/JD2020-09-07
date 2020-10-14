package by.it.mialeshka.jd01_12;

import java.net.Inet4Address;
import java.util.*;

public class TaskA2 {

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        Set<Integer> result = new HashSet<>(a);
        Iterator<Integer> iterator = b.iterator();
        while (iterator.hasNext()){
            Integer valueB = iterator.next();
            if(!a.contains(valueB))
                result.add(valueB);
        }
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b){
        Set<Integer> result = new HashSet<Integer>(){};
        Iterator<Integer> iterator = b.iterator();
        while (iterator.hasNext()){
            Integer valueB = iterator.next();
            if(a.contains(valueB) && !result.contains(valueB))
                result.add(valueB);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>(Arrays.asList(1,2,3,5,5,7,8,9,11));
        HashSet<Integer> hashSet = new HashSet<Integer>(Arrays.asList(4,12,65,10,5,5,7));
        System.out.println(getUnion(treeSet, hashSet));
        System.out.println(getCross(treeSet, hashSet));
    }
}
