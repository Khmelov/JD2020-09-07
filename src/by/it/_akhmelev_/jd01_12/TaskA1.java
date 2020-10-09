package by.it._akhmelev_.jd01_12;

import java.util.*;

public class TaskA1 {

    void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i < 4) {
                iterator.remove();
            }
        }
        grades.removeAll(Arrays.asList(1, 2, 3));
    }

    public static void main(String[] args) {
        Random rnd = new Random();

        int n=10 + rnd.nextInt(20);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(1+rnd.nextInt(10));
        }
        System.out.println(list);
        new TaskA1().clearBad(list);
        System.out.println(list);

    }
}
