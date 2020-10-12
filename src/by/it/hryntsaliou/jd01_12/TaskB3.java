package by.it.hryntsaliou.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;

class TaskB3 {
    private static void prn(Object o){
        System.out.println(o.toString());}
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        LinkedList<String> names1 = new LinkedList<>();
        for (int i = 0; i < 4096; i++) {
            names.add("5"+i);
            names1.add("5"+i);
        }
        process(names);
        process(names1);
    }

    static String process (ArrayList<String> peoples) {
        Timer t = new Timer();
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
        prn(t + " ArrayList");
        return peoples.get(0);
    }


    static String process(LinkedList<String> peoples) {
        Timer t = new Timer();
        while (peoples.size()>1) {
            peoples.addLast(peoples.getFirst());
            peoples.removeFirst();
            peoples.removeFirst();
        }
        prn(t + " LinkedList");
        return peoples.getFirst();
    }

    static class Timer {
        private long iniTime;
        private Double Delta;
        public Timer() {
            iniTime = System.nanoTime();
        }
        public String toString() {
            Delta = (double) (System.nanoTime() - iniTime)/1000;
            iniTime = System.nanoTime();
            return "Прошло " + Delta.toString()+ " микросекунд";
        }
    }
}
