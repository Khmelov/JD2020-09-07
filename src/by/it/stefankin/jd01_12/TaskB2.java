package by.it.stefankin.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> ps =new ArrayList<>();
        ps.add("Don");
        ps.add("Sancha");
        ps.add("Pokemon");
        ps.add("Farik");
        ps.add("Nurik");
        System.out.println(ps);

        LinkedList<String> ll=new LinkedList<>();
        ll.addAll(ps);
        System.out.println(ll);

        process(ps);
        process(ll);
        System.out.println(ps);
        System.out.println(ll);




    }
    static String process(ArrayList<String> peoples){
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
      String ret =  peoples.get(0);
        System.out.println(ret);
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
