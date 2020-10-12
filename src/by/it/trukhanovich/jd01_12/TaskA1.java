package by.it.trukhanovich.jd01_12;


import java.util.*;

public class TaskA1 {
    void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            if (next<=3){
                iterator.remove();
            }

        }

    }
    public static void main(String[] args) {
        Random rnd = new Random ();
        List<Integer> list = new ArrayList<>();
        int n=10+ rnd.nextInt(20);
        for (int i = 0; i < n; i++) {
            list.add(1+ rnd.nextInt(10));
        }
        System.out.println(list);
        new TaskA1().clearBad(list);
        System.out.println(list);

    }
}
