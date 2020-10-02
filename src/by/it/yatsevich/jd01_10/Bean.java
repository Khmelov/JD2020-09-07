package by.it.yatsevich.jd01_10;

public class Bean {

    @Param(a=5,b=9)
    static double sum (int a,int b){
        return a+b;
    }

    @Param(a=50,b=91)
    static double avg (int a,int b){
        return (a+b)/2.0;
    }


    double min(int a,int b){
        return Math.min(a, b);
    }

    @Param(a=58,b=19)
    double max(int a,int b){
        return Math.max(a,b);
    }

}

