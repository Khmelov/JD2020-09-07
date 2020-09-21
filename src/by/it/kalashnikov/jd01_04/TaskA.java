package by.it.kalashnikov.jd01_04;

import java.util.Scanner;

 class TaskA {

    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        buildOneDimArray(str);
    }
    static void printMulTable(){
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <=9; j++) {
                System.out.printf("%1d*%1d=%-2d ",i,j,i*j);
            }
            System.out.println();
        }
    }

   static void buildOneDimArray(String line){
       double[] array = InOut.getArray(line);
       double st= array[0];
       double ls= array[array.length-1];
       InOut.printArray(array, "V",5);
       System.out.println();
       Helper.sort(array);
       InOut.printArray(array, "V",4);
       for (int i = 0; i < array.length; i++) {
           if (array[i]==st){
               System.out.println("Index of first element=" + i);
               break;
           }
       }
       for (int j = 0; j < array.length-1; j++) {
           if (array[j]==ls){
               System.out.println("Index of last element=" + j);
               break;
           }
       }
   }

}
