package by.it.tarasevich.jd01_10;

public class Bean {
    @Param(a = 4, b = 6)
    static double sum( int a, int b){return (a+b);}

     double max (int a , int b){
        return (Math.max(a, b));
    }
    @Param(a= 30 , b =60)
     double min (int a, int b){
        return (Math.min(a, b));
    }
    @Param(a = 25 , b = 59)
     static double avg (int a , int b){
        return (a+b)/2.0;
    }
}
