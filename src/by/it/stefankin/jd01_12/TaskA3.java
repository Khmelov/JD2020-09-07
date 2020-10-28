package by.it.stefankin.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> res=new ArrayList<>();
        int zeroPos=0;
        for (; ; ) {
            String input = sc.next();
            if (input.equals("end")) {
                break;
            }
            Integer value=Integer.valueOf(input);
            if (value<0) res.add(value);
            else if (value==0) res.add(zeroPos,value);
            else res.add(zeroPos++,value);

        }
        System.out.println(res);
    }

}
