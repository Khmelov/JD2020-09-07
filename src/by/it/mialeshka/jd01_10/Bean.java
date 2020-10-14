package by.it.mialeshka.jd01_10;

class Bean {
    @Param(a = 1, b = 3)
    static double sum(int a, int b){
        double result = a + b;
        return result;
    }

    @Param(a=1, b=2)
    static double max(int a, int b){
       return a > b ? a : b;
    }

    @Param(a = 1, b = 3)
    double min(int a, int b){
        return a > b ? b : a;
    }

    double avg(int a, int b){
        double result = (a + b)/2.0;
        return result;
    }
}
