package by.it.yatsevich.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
    }
    private static void step1(){
        double a=756.13;
        double x=0.3;
        double part1= cos(pow((x*x+PI/6),5));
        double part2= sqrt(x*pow(a,3));
        double part3=log(abs((a-1*x)/4));
    }
}
