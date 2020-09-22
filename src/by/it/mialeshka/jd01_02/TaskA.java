package by.it.mialeshka.jd01_02;

import java.util.Scanner;

public class TaskA {
   static void step1(int[] arr){
       int maxValue = arr[0];
       int minValue = arr[0];
       for(int arrEl : arr){
           if (arrEl < minValue)
               minValue = arrEl;

           if (arrEl > maxValue)
               maxValue = arrEl;
       }
       System.out.println(minValue + " " + maxValue);
   }

    static void step2(int[] arr) {
       double midValue = 0;

       for (int arrEl : arr){
           midValue +=arrEl;
       }
       midValue = midValue/arr.length;

       for(int arrEl : arr) {
           if (arrEl < midValue)
               System.out.print(arrEl + " ");
       }

   }
    static void step3(int[] arr) {
       int minValue = arr[0];
       for(int arrEl : arr){
           if (arrEl < minValue)
               minValue = arrEl;
       }

       for(int i = arr.length- 1; i >= 0; i--){
           if (arr[i] == minValue)
               System.out.print(i + " ");
       }
   }

   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int mass[] = new int[10];
       for(int i = 0; i < mass.length; i++){
           mass[i] = scanner.nextInt();
       }
       step1(mass);
       step2(mass);
       step3(mass);
   }
}
