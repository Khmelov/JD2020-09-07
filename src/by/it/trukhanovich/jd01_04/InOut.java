package by.it.trukhanovich.jd01_04;

/**
 * класс ввода и вывода данных
 */
 class InOut {
    /**
     *
     * @param line входящая строка
     * @return double массив цифр
     */
    static double[ ] getArray(String line){
        String[] Array = line.split(" ");
        double [] result=new double[Array.length];
        for (int i = 0; i < Array.length; i++) {
            result [i]=Double.parseDouble(Array[i]);
            }
        return result;
    }

    /**
     *
     * @param arr входящий одномерный массив, выводимый на печать
     */
    static void printArray (double[] arr){
    for (double element : arr) {
        System.out.print( element + " ");
        }
    System.out.println();

}

    /**
     *
     * @param arr входящий двумерный массив выводимый на печать
     */
    static void printArray (double[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr [i][j]+" " );
            }
            System.out.println();
        }

    }

    /**
     *
     * @param arr входящий одномерный массив выводимый на печать
     * @param name имя ячеек
     * @param columnCount количество столбцов выводимоно на печать массива
     */
    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf( "%s[% -3d]=%-10.4f", name, i , arr[i]);
            if ((i+1)%columnCount==0||i+1==arr.length)
            System.out.println();
        }
    }

    /**
     *
     * @param arr входящий одномерный массив, заоплняемый Math.random в промежутке [-5;5)
     */
    public static void MassivFilling(double[] arr ) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 5)-5;
            }
    }

    /**
     *
     * @param arr входящий двумерный массив, заоплняемый Math.random в промежутке [-5;5)
     */
    public static void MassivFilling(double[][] arr ) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 5) - 5;
            }
        }
        System.out.println();


    }
}