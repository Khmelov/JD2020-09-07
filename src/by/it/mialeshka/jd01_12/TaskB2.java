package by.it.mialeshka.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {

    public static void main(String[] args) {
        ArrayList<String> stringLIST = new ArrayList<String>(){};
        stringLIST.add("Вася");
        stringLIST.add("Петя");
        stringLIST.add("Дима");
        stringLIST.add("Лена");
        stringLIST.add("Саша");
        System.out.println(process(stringLIST));

        LinkedList<String> linkedList = new LinkedList<String>(){};
        linkedList.add("Вася");
        linkedList.add("Петя");
        linkedList.add("Дима");
        linkedList.add("Лена");
        linkedList.add("Саша");
        System.out.println(process(linkedList));

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
}
