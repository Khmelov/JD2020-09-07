package by.it.mialeshka.jd01_05;

import java.util.Scanner;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {

        for (int i = 20; i < 41; i++) {
            step1(i);
        }
    }

    private static void step1(int n) {
      double d = (9-5.33)/(n-1);
      double[] arr = new double[n];

      int ia = 0;
      for (double x = 5.33; x<=9; x=x+d){
         arr[ia] = cbrt(x*x+4.5);
         ia++;
      }

      printArr(arr, "Массив A[]", "A");

      String str = "";
      double mArr = 1;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > 3.5)
            {
                str = str + arr[i] + " ";
                mArr = mArr*arr[i];
            }
        }

        double[] arrB = getArray(str);

        printArr(arrB, "Массив B[] из элементов массива A > 3.5", "B");

        mArr = pow(mArr, 1.0/arrB.length);

        System.out.println(mArr);

    }


    static double[] getArray(String line) {
        line = line.trim();
        String[] strArr = line.split(" ");
        double[] res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
        return res;
    }

    static void printArr(double[] arr, String head, String arrName){
        System.out.println(head);
        for(int i = 0; i < arr.length; i++) {
            if (i < 10) System.out.printf("%s[% -2d ] = %g    ", arrName, i, arr[i]);
            else System.out.printf("%s[% -2d] = %g    ", arrName, i, arr[i]);
            if ((i+1) % 5 == 0 || i + 1 == arr.length) {
                System.out.println();
            }
        }
    }


}
