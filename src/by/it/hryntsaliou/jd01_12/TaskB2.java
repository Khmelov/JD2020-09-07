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
        int size;
            while (peoples.size() > 1) {
                if (peoples.size() % 2 != 0) {
                    int count = 0;
                    size = (peoples.size() - 1) / 2;
                    for (int i = 0; i < size; i++) {
                        peoples.remove(count + 1);
                        count++;
                    }
                    peoples.remove(0);
                }
                if (peoples.size() % 2 == 0) {
                    int count = 0;
                    size = peoples.size() / 2;
                    for (int i = 0; i < size; i++) {
                        peoples.remove(count + 1);
                        count++;
                    }
                }
            }
            return peoples.get(0);
    }


    static String process(LinkedList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size()>1) {
            while (iterator.hasNext()) {



            }

        }
        return peoples.get(0);
    }
}
