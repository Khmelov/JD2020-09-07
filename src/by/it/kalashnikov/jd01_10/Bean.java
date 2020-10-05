package by.it.kalashnikov.jd01_10;

class Bean {

    @Param( a=12, b=12)
    static double sum (int a, int b){
        return a+b;
    }

    @Param(a=13,b=13)
     double max (int a, int b){
        return a>b ? a:b;
    }


    double min (int a, int b){
        return a<b?a:b;
    }

    @Param(a=15,b=15)
    static double avg (int a, int b){
        return (a+b)/2.0;
    }

}
