package by.it.hryntsaliou.jd01_03;

import java.util.Scanner;

class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array, "A", 3);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        double[][] matArray = new double[3][3];
        for (int i = 0; i < matArray.length; i++) {
            for (int j = 0; j < matArray[0].length; j++) {
                matArray[i][j] = (int) (Math.random() * 20 - 10);
            }
        }

        double[] vector = new double[3];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 20 - 10);
        }
        Helper.mul(matArray, vector);
        /*Helper.mul();  Я не дописывал код этого метода, так как в условии точно не сказано,
                         как нужно задавать значения и размерности матриц, при необходимости
                         без проблем допишу этот кусок кода         */
    }
}
