package by.it.stefankin.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kol = sc.nextInt();
        String[] fam = new String[kol];
        for (int i = 0; i < fam.length; i++) {
            fam[i] = sc.next();
        }
        int[][] zp = new int [kol][4];
        for (int i=0; i<4;i++) {
             for (int j=0;j<kol;j++) {
                System.out.println("Введите зарплату для " + fam[j] + ":");
            String vvzp =sc.nextLine();
            vvzp.trim();
                String[] strzp = vvzp.split(" ");
                System.out.println(vvzp);

            //zp[i][j]= Integer.parseInt(strzp[j]);
               // System.out.println(strzp[0],strzp[1],strzp[2],strzp[3]);
            }
        }



    }

}
