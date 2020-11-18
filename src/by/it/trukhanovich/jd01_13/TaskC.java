package by.it.trukhanovich.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
    private static final ArrayList<Double> arrayList = new ArrayList<>();
    private static Scanner sc;
    static int i = 0;

    public static void main(String[] args) {
        TaskC.sc = new Scanner(System.in);
        for (int j = 0; j < 10000; j++) {
            readData();
        }
    }

    static void readData() {
        try {
            double v = Double.parseDouble(TaskC.sc.next());
            TaskC.arrayList.add(v);
        } catch (RuntimeException e) {
            if (i < 5) {
                sleep();
                for (int j = arrayList.size() - 1; j >= 0; j--) {
                    System.out.print(arrayList.get(j) + " ");
                }
                System.out.println();
                i++;
            } else
                throw e;
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
