package by.it.adryneuski.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        String[] name = new String[n];
        Scanner sc1 = new Scanner(System.in);

        for (int i = 0; i < n; i++)
        {
            name[i] = sc1.nextLine();

        }



        for (int i = 0; i < n; i++)
        {
            System.out.print (" " + name[i]);
        }
        System.out.println();
    }


  }

