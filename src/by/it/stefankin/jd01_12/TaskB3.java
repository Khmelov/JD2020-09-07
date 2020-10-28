package by.it.stefankin.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> ps =new ArrayList<>();
        LinkedList<String> ll=new LinkedList<>();
        for (int i = 0; i < 4096; i++) {
            String val=String.valueOf(i);
            ps.add(val);
            ll.add(val);
       }

        /*  ArrayList почти в два раза дольше, т.к. он копирует значения элементов каждый раз при удалении,а Линкед перебрасывает ссылки с элемента на другой  */
        long t1 = System.nanoTime();
        process(ps);
        long t2 = System.nanoTime();
        System.out.println("time mks "+(t2-t1)/1000.0);
        long t3 = System.nanoTime();
        process(ll);
        long t4 = System.nanoTime();
        System.out.println("time mks "+(t4-t3)/1000.0);





    }
    static String process(ArrayList<String> peoples){
        int cnt = 1;
        while (peoples.size() > 1)
        {
            Iterator iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (cnt == 2) {
                    iterator.remove();
                    cnt=1;
                }
                else cnt++;
            }
        }
        String ret =  peoples.get(0);
        return  ret;



    }

    static String process(LinkedList<String> peoples){
        int cnt = 1;
        while (peoples.size() > 1)
        {Iterator iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (cnt == 2) {
                    iterator.remove();
                    cnt=1;
                }
                else cnt++;
            }
        }
        return  peoples.get(0);
    }



}


