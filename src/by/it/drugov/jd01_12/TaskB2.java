package by.it.drugov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        LinkedList<String> linkedList = new LinkedList<>();
        System.out.println(process(arrayList));
        System.out.println(process(linkedList));
    }

    static String process(LinkedList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.next();
            iterator.remove();
        }
        return peoples.toString();
    }

    static String process(ArrayList<String> peoples) {

        return peoples.toString();
    }
}
