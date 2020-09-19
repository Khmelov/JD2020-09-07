package by.it.makovsky.jd01_04;

public class InOut {
    static double[ ] getArray(String line){
        String[] elemline=line.split(" ");
        double[] arr=new double[elemline.length];
        for (int i = 0; i < elemline.length; i++) {
            arr[i]=Double.parseDouble(elemline[i]);
        }
        return arr;
    }

    static void printArray(double[ ] arr){
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }
    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-7.3f ",name,i,arr[i]);
            if ((i+1)%columnCount==0 || i+1== arr.length){
                System.out.println();
            }
        }
    }

}
