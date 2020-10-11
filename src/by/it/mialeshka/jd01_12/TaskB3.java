package by.it.mialeshka.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB3 {

    public static void main(String[] args) {
        ArrayList<String> stringLIST = new ArrayList<String>(){};
        LinkedList<String> linkedList = new LinkedList<String>(){};
        for (int i = 0; i <= 4096; i++) {
            stringLIST.add("Вася"+i);
            linkedList.add("Вася"+i);
        }
        long startTime = System.nanoTime();
        System.out.println(process(stringLIST));
        long endTime = System.nanoTime();
        System.out.println((endTime-startTime)/1000000.0);
        startTime = System.nanoTime();
        System.out.println(process(linkedList));
        endTime = System.nanoTime();
        System.out.println((endTime-startTime)/1000000.0);

    }

    static String process(ArrayList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1)
        {
            Iterator iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count == 2) {
                    iterator.remove();
                    count=1;
                }
                else count++;
            }
        }
        return  peoples.get(0);

    }
    static String process(LinkedList<String> peoples){
        while (peoples.size() > 1)
        {
            peoples.addLast(peoples.getFirst());
            peoples.removeFirst();
            peoples.removeFirst();

        }
        return  peoples.get(0);
    }
}
