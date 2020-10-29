package by.it.ilysuchanka.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {
        int n = 262144;
        ArrayList<String> strings1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strings1.add(String.valueOf(i + 1));
        }
        LinkedList<String> strings2 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            strings2.add(String.valueOf(i + 1));
        }
        Long t = System.nanoTime();
        String s1 = new String(process((ArrayList<String>) strings1));
        Long tA = System.nanoTime() - t;
        Long l = System.nanoTime();
        String s2 = new String(process((LinkedList<String>) strings2));
        Long tL = System.nanoTime() - l;
        System.out.println(" Время работы для  ArrayList=" + tA / 1000 + " мкс.");
        System.out.println(" Время работы для LinkedList=" + tL / 1000 + " мкс.");

    }

    static String process(ArrayList<String> peoples) {
        ArrayList<String> strings = new ArrayList<>(peoples);
        int check = 1;
        for (; strings.size() > 1; ) {
            for (int i = 0; i < strings.size(); ) {
                if (check == 1) {
                    check = 2;
                    i++;
                    continue;
                }
                if (check == 2) {
                    strings.remove(i);
                    check = 1;
                }
            }
        }
        String s = strings.get(0);
        return s;
    }

    static String process(LinkedList<String> peoples) {
        int check = 1;
        for (; peoples.size() > 1; ) {
            if (check == 1) {
                peoples.addLast(peoples.pollFirst());
                check = 2;
            }
            if (check == 2) {
                peoples.removeFirst();
                check = 1;
            }
        }
        return peoples.getFirst();
    }
}