package by.it.hryshanovich.jd01_03;

import java.util.Scanner;

public class Runner {
    public Runner() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array, "V", 4);
        System.out.println();
        System.out.print("Min: ");
        double hmin = Helper.findMin(array);
        System.out.print(hmin);
        System.out.println();
        System.out.print("Max: ");
        double hmax = Helper.findMax(array);
        System.out.print(hmax);
        System.out.println();
        System.out.print("Sort arrays: ");
        Helper.sort(array);
        double[] var8 = array;
        int var9 = array.length;

        for(int var10 = 0; var10 < var9; ++var10) {
            double v = var8[var10];
            System.out.print(v + "  ");
        }

        System.out.println();
    }
}