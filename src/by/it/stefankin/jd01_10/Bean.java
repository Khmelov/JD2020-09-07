package by.it.stefankin.jd01_10;

public class Bean {
    @Param(a=2,b=3)
    public static double sum (int a, int b) {
        return (double) a+b;

    }
    @Param(a=2,b=3)
    public static double max (int a, int b) {
     if (a>b) return (double) a;
     else return (double) b;

    }
    @Param(a=2,b=3)
    public double min (int a, int b) {
        if (a<b) return (double) a;
        else return (double) b;

    }
    public double avg (int a, int b) {
        return (double) (a+b)/2.0;

    }
}
