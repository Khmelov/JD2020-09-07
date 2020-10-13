package by.it.kalashnikov.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class TaskB2 {
    public static void main(String[] args) {
        int n = 20;
        ArrayList<String> string1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            string1.add(String.valueOf(i + 1));
        }
        LinkedList<String> string2 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            string2.add(String.valueOf(i + 1));
        }
        String s1 = process(string1);
        String s2 = process(string2);

        System.out.println(s1);
        System.out.println(s2);
    }

    static String process(ArrayList<String> peoples) {
        ArrayList<String> s = new ArrayList<>(peoples);
        int element = 1;
        while (s.size() > 1) {
            for (int i = 0; i < s.size(); ) {
                if (element == 1) {
                    element = 2;
                    i++;
                    continue;
                }
                s.remove(i);
                element = 1;
            }
        }
        return s.get(0);
    }

    static String process(LinkedList<String> peoples) {
        List<String> strings = new LinkedList<>(peoples);
        int element = 1;
        while (strings.size() > 1) {
            ListIterator<String> listIterator = strings.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next();
                if (element == 1) {
                    element = 2;
                    listIterator.hasNext();
                    continue;
                }
                listIterator.remove();
                element = 1;
            }
        }
        return strings.get(0);
    }
}
