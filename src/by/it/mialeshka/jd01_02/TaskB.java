package by.it.mialeshka.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int monathnumber = scanner.nextInt();
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        step1();
        step2(monathnumber);
        step3(a, b, c);

    }
     static void step1(){
        for(int i = 0; i < 5; i++){
            for(int j = 1; j <= 5; j++){
                int r = i*5 + j;
                System.out.print(r + " ");
            }
            System.out.print("\n");
        }
    }
     static void step2(int monath){
        String monathname;
        switch (monath){
        case 1 : {
            monathname = "январь";
            break;
        }
            case 2 :{
                monathname = "февраль";
                break;
            }
            case 3 :{
                monathname = "март";
                break;
            }
            case 4 :{
                monathname = "апрель";
                break;
            }
            case 5 :{
                monathname = "май";
                break;
            }
            case 6 :{
                monathname = "июнь";
                break;
            }
            case 7 :{
                monathname = "июль";
                break;
            }
            case 8 :{
                monathname = "август";
                break;
            }
            case 9 :{
                monathname = "сентябрь";
                break;
            }
            case 10 :{
                monathname = "октябрь";
                break;
            }
            case 11 :{
                monathname = "ноябрь";
                break;
            }
            case 12 :{
                monathname = "декабрь";
                break;
            }
            default: {
                monathname = "нет такого месяца";
            }
        }
        System.out.println(monathname);
    }
     static void step3(double a, double b, double c) {
      double d = b*b - 4*a*c;
      double x1, x2;
      if (d > 0){
        x1 =(-b + Math.sqrt(d))/(2*a);
        x2 = (-b - Math.sqrt(d)) /(2*a);
        System.out.print(x1 + " " + x2);
      }
     if(d < 0){
         System.out.println("корней нет");
     }

    if(d == 0){
        x1 = (-b)/(2*a);
        System.out.println(x1);
    }
    }
}
