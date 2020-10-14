package by.it.drugov.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int pos = 0;
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String element = scanner.next();
            if (element.equals("end")) {
                break;
            }
            Integer value = Integer.valueOf(element);
            if (value > 0) {
                list.add(pos++, value);
            } else if (value == 0) {
                list.add(pos, value);
            } else {
                list.add(value);
            }

        }
        System.out.println(list);
    }
}
