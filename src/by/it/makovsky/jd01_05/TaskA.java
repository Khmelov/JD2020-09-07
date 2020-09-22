package by.it.makovsky.jd01_05;

import static java.lang.Math.*;

public class TaskA {

    public static void main(String[] args) {
        stage1();
        stage2();
        stage3();
    }
    private static void stage1(){
        double a= 756.13;
        double x= 0.3;
        double z= cos(pow(x*x+PI/6,5));
        z= z-sqrt(x*pow(a,3));
        z=z-log(abs((a-1.12*x)/4));
        System.out.println("z = "+z);
    }

    private static void stage2(){
        double a= 1.21;
        double b= 0.371;
        double one= tan((a+b)*(a+b));
        double two= cbrt(a+1.5);
        double three= a*pow(b,5);
        double four= b/log(a*a);
        double z= one-two+three-four;
        System.out.println(z);
    }

    private static void stage3(){
        double x= 12.1;
        for (double a = -5; a <=12 ; a=a+3.75) {
            double f=pow(E,a*x)-3.45*a;
            System.out.println("при a равном "+a+" f равно "+f);
        }
    }

}