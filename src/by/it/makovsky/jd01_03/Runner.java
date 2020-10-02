package by.it.makovsky.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String masline=sc.nextLine();
        double[] array = InOut.getArray(masline);
        InOut.printArray(array);
        InOut.printArray(array,"a",2);
        System.out.println("Минимальный элемент: "+Helper.findMin(array));
        System.out.println("Максимальный элемент: "+Helper.findMax(array));
        Helper.sort(array);
        InOut.printArray(array);
        }
}
