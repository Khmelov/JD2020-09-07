package by.it.tarasevich.jd01_03;



public class InOut {

    static double[] getArray(String line) {
        String[] lineArray = line.split(" ");
        double[] res = new double[lineArray.length];
        for (int i = 0; i < lineArray.length; i++) {
            res[i] = Double.parseDouble(lineArray[i]);
        }
        return res;
    }

    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.print("\n");


    }

    static void printArray(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i <= arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == arr.length) {
                System.out.println();

            }
        }

    }

    public static void MassivFilling(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 5) - 5;
        }
    }

    public static void MassivFilling(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {


                arr[i][j] = (int) (Math.random() * 5) - 5;
            }
        }
    }

}