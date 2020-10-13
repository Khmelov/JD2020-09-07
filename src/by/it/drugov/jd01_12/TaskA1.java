package by.it.drugov.jd01_12;

import java.util.*;

public class TaskA1 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int size = 10 + rnd.nextInt(20);
        List<Integer> grades = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            grades.add(1 + rnd.nextInt(10));
        }
        System.out.println(grades);
        new TaskA1().clearBad(grades);
        System.out.println(grades);
    }

    void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i < 4) {
                iterator.remove();
            }
        }
    }
}
