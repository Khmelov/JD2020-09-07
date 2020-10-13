package by.it.trukhanovich.jd01_12;

import java.util.*;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List list = new ArrayList();
        int zeroPos=0;
        for(;;){
            String s= sc.next();
            if (s.equals("end")) break;
            Integer num=Integer.valueOf(s);
            if (num<0){
                list.add(num);
            }
            if(num==0){
                list.add(zeroPos,num);
            }
            if(num>0){
                list.add(zeroPos++, num);
            }
        }
        System.out.println(list);
    }
}
