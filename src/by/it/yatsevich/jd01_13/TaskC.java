package by.it.yatsevich.jd01_13;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class TaskC {
    static int value = 0;
    static List<Double> temp = new LinkedList<>();
    static String s;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        while (value < 5) {
            try {
                s = scan.next();
                readData();
            } catch (NumberFormatException e) {
                Thread.sleep(100);
                for (int i = temp.size() - 1; i >= 0; i--) {
                    System.out.print(" " + temp.get(i));
                }System.out.println();
                value++;
            }
        }
    }


    static void readData() {
        System.out.println(s);
        Double j = Double.parseDouble(s);
        temp.add(j);
    }
}


