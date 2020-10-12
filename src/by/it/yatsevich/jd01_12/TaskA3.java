package by.it.yatsevich.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        Scanner scan= new Scanner(System.in);
        String s1;
        int pos=0;
        while (!(s1=scan.next()).equals("end")){
            Integer value = Integer.valueOf(s1);
            if (value>0) array.add(pos++,value);
            else if (value==0) array.add(pos,value);
            else array.add(value);
        }
        System.out.println(array);
    }
}
