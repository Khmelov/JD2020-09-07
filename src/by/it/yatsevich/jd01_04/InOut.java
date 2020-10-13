package by.it.yatsevich.jd01_04;

class InOut {
    static double[ ] getArray(String line){
        String[] arrayString = line.split(" ");
        double[] result = new double[arrayString.length];
        for (int i = 0; i < result.length; i++) {
            result[i]=Double.parseDouble(arrayString[i]);
        }
        return result;
    }

    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    static void printArray(double[] arr, String name, int columnCount){
        System.out.println("Array " + name);
        for (int i = 0; i < arr.length; i++) {
            double element= arr[i];
            System.out.printf("%s[% -3d]=%-10.4f ",name,i,element);
            if ((i+1)%  columnCount == 0
                    ||
                    i== arr.length-1)
                System.out.println();
        }
    }
}
