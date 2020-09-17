package by.it.kulik.jd01_05;

public class TaskA {
    public static void main(String[] args) {
        double z, x=0.3, a=756.13;
        z=Math.cos(Math.pow((x*x+Math.PI/6), 5))-Math.sqrt(x*a*a*a)-Math.log(Math.abs((a-1.12)/4));
        double c = Math.cos(Math.pow((x*x+Math.PI/6), 5));
        double s = Math.sqrt(x*a*a*a);
        double l = Math.log(Math.abs((a-1.12)/4));
        z=c-s-l;
    }
}
