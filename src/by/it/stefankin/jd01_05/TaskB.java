package by.it.stefankin.jd01_05;
import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }
     private static void step1() {
        for (double a=0; a <= 2; a = a+0.20) {
            double sum=0;
            for (double x =1; x <=6; x++)  {
                double z = pow(7, a) - cos(x);
                sum = sum + z;
             }
            System.out.println("При a= "+a+"Сумма y= " + sum);
        }
    }
    private static void step2() {
     for (double x=-5.5;x<2;x=x+0.5) {
         double varb =0;
        if(-2<x/2 && x/2<=-1){
           varb = sin(x*x);
       }
       if(-1<x/2 && x/2<0.2){
           varb = cos(x*x);
       }
       if(x/2==0.2){
           varb =1/(tan(x*x));
       }
         double alfa=log10(varb+2.74);
         System.out.println("alfa= "+alfa+"x= "+x);
     }

    }




}
