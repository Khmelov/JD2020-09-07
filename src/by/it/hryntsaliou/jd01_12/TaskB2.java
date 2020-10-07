package by.it.hryntsaliou.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        LinkedList<String> names1 = new LinkedList<>();
        process(names);
        process(names1);
    }
    static String process(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        int size = peoples.size();
        while (iterator.hasNext()) {
            for (int i = 0; i < size; i++) {
                while (peoples.size()!=0) {
                    String names = iterator.next();
                    if ((i + 1) % 2 == 0) {
                        peoples.remove(i);
                        size--;
                        i++;
                    }
                }
            }
        }
        return null;
    }
    static String process(LinkedList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();

        return null;
    }
}
