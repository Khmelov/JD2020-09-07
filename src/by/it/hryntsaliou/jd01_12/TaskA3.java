package by.it.hryntsaliou.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

class TaskA3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int posZero = 0;
        for(;;) {
            String line = scanner.next();
            if (line.equals("end")) {
                break;
            }
            Integer value = Integer.valueOf(line);
            if (value < 0) {
                list.add(value);
            } else if (value == 0) {
                list.add(posZero, value);
            } else if (value > 0) {
                list.add(posZero++, value);
            }
        }
        System.out.println(list);
    }
}
