package by.it.trukhanovich.jd01_10;

public class Bean {
        @Param(a=22,b=5)
        double sum (int a, int b) {
            return a+b;
        }
        @Param(a=25,b=50)
        double max (int a, int b) {
            return a>b?a:b;
        }
    @Param(a=22,b=55)
    static double avg (int a, int b) {
            return (a+b)/2.0;
        }
//    @Param(a=22,b=55)
    static double min (int a, int b) {
        return a<b?a:b;
    }

}
