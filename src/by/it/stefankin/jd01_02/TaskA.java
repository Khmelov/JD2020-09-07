package by.it.stefankin.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i]= sc.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }

    private static void step1(int[] mas) {
        int min=mas[0];
        int max=mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (min>mas[i]) min=mas[i];
            if (max<mas[i]) max=mas[i];
            }
        System.out.println(min+" "+max);
    }

    static void step2(int[] mas) {
        double sredn = 0;
        for (double sr:mas) {
            sredn=sredn+sr;
        }
        sredn = sredn/mas.length;

        for (int i:mas) {
            if (i<sredn)
                System.out.print(" "+i);
        }
      System.out.println("\n"+"__");

    }
    static void step3(int[] mas) {
        int min=mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (min>mas[i]) min=mas[i];
            }
        for (int i=mas.length-1; i>=0;i--) {
            if (mas[i] == min) {
         System.out.print(" " + i);
            }
        }

    }


}
