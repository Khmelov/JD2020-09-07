package by.it.yatsevich.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;


class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(i, "name" + i);
            linkedList.add(i, "name" + i);
        }
        System.out.println(process(arrayList));
        System.out.println(process(linkedList));
    }

    static String process(ArrayList<String> peoples) {
        int i;
        int size;
        while (peoples.size() > 1) {
            if (peoples.size() % 2 != 0) {
                i = 0;
                size = peoples.size() / 2;
                for (int j = 0; j < size; j++) {
                    peoples.remove(i + 1);
                    i++;
                }
                peoples.remove(0);
            } else {
                i = 0;
                size = peoples.size() / 2;
                for (int j = 0; j < size; j++) {
                    peoples.remove(i + 1);
                    i++;
                }
            }
        }
//        System.out.println(peoples.get(0));
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        int i;
        int size;
        while (peoples.size() > 1) {
            if (peoples.size() % 2 != 0) {
                i = 0;
                size = peoples.size() / 2;
                for (int j = 0; j < size; j++) {
                    peoples.remove(i + 1);
                    i++;
                }
                peoples.remove(0);
            } else {
                i = 0;
                size = peoples.size() / 2;
                for (int j = 0; j < size; j++) {
                    peoples.remove(i + 1);
                    i++;
                }
            }
        }
//        System.out.println(peoples.getLast());
        return peoples.getLast();
    }
}
