package by.it.mialeshka.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TaskC {
    static Scanner scanner;

    static void readData() throws NumberFormatException, InterruptedException {
        int countErr = 0;
        String str;
        ArrayList arrayList = new ArrayList();

        while (countErr < 5)
        {
            str = scanner.next();
            try{
                double value = Double.parseDouble(str);
                arrayList.add(value);
            }
            catch (Exception e){
                countErr ++;
                Thread.sleep(100);


                for (int i = arrayList.size()-1; i >= 0; i--) {
                    System.out.print(arrayList.get(i) + " ");
                }
            }

        }
    }
    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);
        readData();
    }
}
