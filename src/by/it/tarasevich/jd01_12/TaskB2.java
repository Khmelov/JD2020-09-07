package by.it.tarasevich.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TaskB2 {
    public static void main(String[] args) {
        int n=10;
        List<String> strings1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strings1.add(String.valueOf(i+1));
        }
        List<String> strings2 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            strings2.add(String.valueOf(i+1));
        }
        String s1 = new String(process((ArrayList<String>) strings1));
        String s2 = new String(process((LinkedList<String>) strings2));

        System.out.println(s1);
        System.out.println(s2);
    }
    static String process(ArrayList<String> peoples) {
        ArrayList<String> strings = new ArrayList<>(peoples);
        int element=1;
        while (strings.size()>1) {
            for (int i = 0; i < strings.size(); ) {
                if (element==1) {element=2;i++; continue;}
                strings.remove(i);
                element=1;
            }
        }
        String s= strings.get(0);
        return s;

    }
    static String process(LinkedList<String> peoples) {
        List<String> strings = new LinkedList<>(peoples);
        int element=1;
        while (strings.size()>1) {
            ListIterator<String> stringListIterator = strings.listIterator();
            while (stringListIterator.hasNext()){
                stringListIterator.next();
                if (element==1) {element=2;stringListIterator.hasNext();continue;}
                stringListIterator.remove();
                element=1;

            }
        }
        String s= strings.get(0);
        return s;
    }
}
