package by.it.stefankin.jd01_03;

public class InOut {

    public static void main(String[] args) {
        String vvod = new String("1 2 3 4 5 6 7 8");
        String name = new String("MAS");

        double[] mas = getArray(vvod);
        printArray(mas);
        printArray(mas,name,4);




    }
    static double[ ] getArray(String line){

        line= line.trim();
        String[] str = line.split(" ");

        double[] dmas= new double[str.length];
        for (int i=0; i< dmas.length;i++){
        dmas[i]=Double.parseDouble(str[i]);
        }
        return dmas;
    }


    static void printArray(double[ ] arr) {
        for (double x:arr){
            System.out.print(x);
        }
        System.out.println("\n");
    }

    static void printArray(double[ ] arr, String name, int columnCount) {
    int c = 0;
    for (int j=0; j< arr.length;j++) {
        System.out.printf("%-5s=%-4.2f",name,arr[j]);
        c++;
        if ((0==c%columnCount) || (j== arr.length-1)) {
            System.out.println("");
        }

     }


    }


}
