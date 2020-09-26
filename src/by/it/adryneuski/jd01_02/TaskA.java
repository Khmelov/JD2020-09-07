package by.it.adryneuski.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        for (int i=0; i<arr.length; i++)
            arr[i] = sc.nextInt();

        step1(arr);
        System.out.println();
        step2(arr);
        System.out.println();
        step3(arr);
    }
    static void step1(int[ ] arr)
    {
       int min=arr[0];
       int max=arr[0];

        for (int value : arr) {
            if (value < min) min = value;
            if (value > max) max = value;
        }
         System.out.print(min + " "+max);


    }
    static void step2(int[ ] arr)
    {
        double avg = 0;
        for (int value : arr)
        {
             avg+=value;
     }
            avg=avg/arr.length;

        for (int value : arr)
        {
            if (value<avg)

                System.out.print(value+ " ");
        }

    }

    static void step3(int[ ] arr)
    {
        int min=arr[0];

        for (int value : arr)
        {
            if (value<min)
                min=value;
        }
        for (int i=arr.length-1; i>=0; i--){

            if (arr[i]==min)
                System.out.print(i+" " );
        }


    }
}
