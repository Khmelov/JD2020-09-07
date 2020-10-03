package by.it.makovsky.jd01_10;

public class Bean {

    @Param(a=2,b=5)
    public static double sum (int a,int b){
        return a+b;
    }

    @Param(a=2,b=5)
    public static double min (int a,int b){
        return Math.min(a, b);
    }

    @Param(a=2,b=5)
    public double max (int a,int b){
        return Math.max(a, b);
    }
    public double avg (int a,int b){
        return (a+b)/2.0;
    }
}
