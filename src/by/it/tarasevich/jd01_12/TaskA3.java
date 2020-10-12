package by.it.tarasevich.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int posZero = 0;
        for (;; ) {
            String s = scanner.next();
            if (s.equals("end")){
                break;
            }
            Integer value = Integer.valueOf(s);
            if (value<0){list.add(value);}
            else if (value==0){list.add(posZero,value);}
            else{list.add(posZero++,value);}
        }
        System.out.println(list);
    }
}
