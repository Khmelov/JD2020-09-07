package by.it.trukhanovich.jd01.jd01_05;

import java.util.Random;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        System.out.println("Step1");
        step1();
        System.out.println("Step2");
        step2();
    }

    private static void step2() {
        int[] a = new int[31];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (random() * 348 + 103);
            if (a[i] * 0.1 > i) j++;
            if (i==0) {System.out.printf("╔════════════╦════════════╦════════════╦════════════╦════════════╗\n");}
            if (((i + 1) % 5 == 0 && i > 0)) {
                System.out.printf("║ A[ %-2d]=%d ║\n", i, a[i]);
            if (i == a.length - 1) System.out.printf("║ A[ %-2d]=%d ║", i, a[i]);
                if (((i + 1) % 5 == 0 && i > 0)&&(i < a.length - 1))  {
                System.out.printf("╠════════════╬════════════╬════════════╬════════════╬════════════╣\n");}
                if (((i + 1) % 5 == 0 && i > 0) && i == a.length - 1) {
                    System.out.println();                }
            } else System.out.printf("║ A[ %-2d]=%d ", i, a[i]);
            if ((i == a.length-1 )&& (a.length%5==1)) {System.out.printf("║            ║            ║            ║            ║\n");}
//            if ((i == a.length-1 )&& (a.length%5==2)) {System.out.printf("║            ║            ║            ║\n");}
//            if ((i == a.length-1 )&& (a.length%5==3)) {System.out.printf("║            ║            ║\n");}
//            if ((i == a.length-1 )&& (a.length%5==4)) {System.out.printf("║            ║\n");}
            if (i==a.length-1) {System.out.printf("╚════════════╩════════════╩════════════╩════════════╩════════════╝\n");}
        }
        int[] b = new int[j];
        j = 0;
        for (int i = 0; i < a.length; i++) {
            if ((double)(a[i]) * 0.1 > i) {b[j] = a[i]; j++;}

        }
//        for (int i = 0; i < b.length; i++) {
//            if (((i + 1) % 5 == 0 && i > 0) || i == b.length - 1) {
//                System.out.printf("B[ %-2d]=%d\n", i, b[i]);
//            } else System.out.printf("B[ %-2d]=%d   ", i, b[i]);
//
//        }
        int leg=b.length/2+1;
        for (int i = 0; i < b.length/2; i++) {
            if (i==0) {System.out.printf("╔════════════╦════════════╗\n");}
            System.out.printf("║ B[ %-2d]=%d ║", i, b[i]);
            if ((i+1)==b.length/2&&leg==b.length) break;
            if (leg==b.length/2) break;
            System.out.printf(" B[ %-2d]=%d ║\n", leg, b[leg]);
            leg++;
            if ((i+1)<b.length/2&&leg<=b.length) System.out.printf("╠════════════╬════════════╣\n");
        }
        if (b.length%2==1) {System.out.printf("╚════════════╩════════════╝\n");}
        if (b.length%2==0) {System.out.printf("            ║\n");
            System.out.printf("╚════════════╩════════════╝\n");}

    }


    private static void step1() {
        int leg= (int) (random()*21+20);
        double [] array=new double[leg];
        double x=5.33;
        int j=0;
        for (int i = 0; i < array.length; i++) {
            if (x>9) break;
            array [i]= cbrt(x*x+4.5);
            if (((i+1)%5==0&&i>0)||i==array.length-1){System.out.printf("A[ %-2d]=%f\n", i, array[i]);}
            else System.out.printf("A[ %-2d]=%f   ", i, array[i]);
            if (array[i]>3.5) j++;
        }
        double [] arrayMore= new double[j];
        double geomSum=0;
        j=0;
        for (int i = 0; i < array.length; i++) {
            if (array [i]>3.5) {arrayMore[j]=array[i]; geomSum=geomSum*arrayMore[j]; j++;}
        }
    }
}

