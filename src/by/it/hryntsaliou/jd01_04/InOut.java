package by.it.hryntsaliou.jd01_04;

class InOut {
    static double[] getArray(String line) {
        String[] stringsArray = line.split(" ");
        double[] result = new double[stringsArray.length];
        for (int i = 0; i < stringsArray.length; i++) {
            result[i] = Double.parseDouble(stringsArray[i]);
        }
        return result;
    }

    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-8.5f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || (i + 1) == arr.length)
                System.out.println();
        }
    }
}

