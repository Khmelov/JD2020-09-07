package by.it.yatsevich.jd01_03;

import java.util.Scanner;

import static by.it.yatsevich.jd01_03.InOut.printArray;

class Runner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line = scanner.nextLine();
        double [] array = InOut.getArray(line);
        printArray(array);
        printArray(array,"Smth",4);
        System.out.println(Helper.findMax(array));
        System.out.println(Helper.findMin(array));
    }
}
