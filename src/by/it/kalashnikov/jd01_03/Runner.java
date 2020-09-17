package by.it.kalashnikov.jd01_03;

import java.util.Scanner;

import static by.it.kalashnikov.jd01_03.Helper.sort;

 class Runner {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        double[] array = InOut.getArray(str);

        InOut.printArray(array);
        InOut.printArray(array,"V",4);
        System.out.println();

        System.out.print("Min: ");
        double hmin =Helper.findMin(array);
        System.out.print(hmin);
        System.out.println();
        System.out.print("Max: ");
        double hmax = Helper.findMax(array);
        System.out.print(hmax);

        System.out.println();

        System.out.print("Sort arrays: ");
        sort(array);
        for (double v : array) {
            System.out.print(v + "  ");
        }
        System.out.println();


    }
}
