package by.it.hryntsaliou.jd01_12;

import java.util.*;

class TaskA1 {
    void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i<4) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = 10 + random.nextInt(20);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(1+random.nextInt(10));
        }
        new TaskA1().clearBad(list);
        System.out.println(list);
    }
}
