package by.it.makovsky.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    private static Set<Integer> getCross(Set<Integer> one, Set<Integer> two){
        Set<Integer> result= new HashSet<>(one);
        result.retainAll(two);
        return result;
    }
    private static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two){
        Set<Integer> result= new HashSet<>(one);
        result.addAll(two);
        return result;
    }
    public static void main(String[] args) {
        Set<Integer> a=new HashSet<>(Arrays.asList(1,1,2,2,3,3,3,5,7,8,9,4));
        Set<Integer> b=new TreeSet<>(Arrays.asList(8,8,6,6,6,5,5,3,3,3,2,1));
        System.out.println(getCross(a,b));
        System.out.println(getUnion(a,b));
    }
}