package by.it.mialeshka.jd01_04;

class InOut {
    /**
     * @author mialeshka
     * @param line
     * @return double
     * my method to get the array
     */
    static double[] getArray(String line) {
        String[] strArr = line.split(" ");
        double[] res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
        return res;
    }

    /**
     * @author mialeshka
     * @param arr
     * my simple method to output an array
     */
    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * @author mialeshka
     * @param arr
     * @param name
     * @param columnCount
     * my method to output an array
     */
    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%-3d]=%-10.4f ", name, i ,arr[i]);
            if((i+1)%columnCount == 0 || i+1 == arr.length) {
                System.out.println();
            }
        }
        System.out.println();
    }

}
