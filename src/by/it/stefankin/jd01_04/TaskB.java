package by.it.stefankin.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int kol = sc.nextInt();
        String[] fam = new String[kol];
        int kvart = 4;
        int[][] zp = new int [kol][kvart];
        int itogov =0;
        double sredn=0.0;


        for (int i = 0; i < fam.length; i++) {
            fam[i] = sc.next();
        }


        for (int i=0; i<kol;i++) {
          System.out.println("Введите зарплату для " + fam[i] + ":");
                  for (int n=0; n<kvart;n++) {
                          zp[i][n] = sc.nextInt();

                           }
           }
        System.out.println("__________________________________________________________________________");
        System.out.println("Фамилия      Квартал1      Квартал2      Квартал3      Квартал4      Итого");
        System.out.println("__________________________________________________________________________");
            for (int k=0; k<kol;k++){
                int itog=0;
                System.out.printf("%-15s  ",fam[k]);
                    for (int po=0;po<kvart;po++) {
                        System.out.printf("%-13d",zp[k][po] );
                         itog+=zp[k][po];
                         itogov+=zp[k][po];
                    }
                System.out.printf("%-13d",itog);
                System.out.println();
            }
        System.out.println("__________________________________________________________________________");
        System.out.println("ИТОГО      "+itogov);
        double kol1=(double)kol;
        double kv1=(double)kvart;
        double itogov1=(double)itogov;
        sredn=(itogov1/kol1)/kv1;

        System.out.println("Средняя зп "+sredn);



    }

}
