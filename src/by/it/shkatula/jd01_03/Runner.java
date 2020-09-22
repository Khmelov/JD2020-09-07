package by.it.shkatula.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String taskA = scanner.nextLine();
        double[] array = InOut.getArray(taskA);
        InOut.printArray(array);
        InOut.printArray(array,"V",3);
        Helper.sort(array);
        System.out.println(Helper.findMin(array));
        System.out.println(Helper.findMax(array));
    }


}
