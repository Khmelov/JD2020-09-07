package by.it.yatsevich.jd01_12;

import java.util.*;

class TaskA1 {
    public static void main(String[] args) {
        Random random = new Random();
        int n = 10 + random.nextInt(20);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(1+ random.nextInt(10));
        }
        System.out.println(list);
        new TaskA1().clearBad(list);
        System.out.println(list);
    }

    void clearBad(List<Integer> grades) {
        Iterator<Integer> it = grades.iterator();
        while (it.hasNext()){
            Integer i = it.next();
            if (i<4) it.remove();
        }
    }
}
