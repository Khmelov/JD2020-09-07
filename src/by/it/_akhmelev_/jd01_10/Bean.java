package by.it._akhmelev_.jd01_10;

public class Bean {
    @Param(a=4,b=6)
    double sum(int a, int b) {
        return a + b;
    }

    static double max(int a, int b) {
        return a < b ? b : a;
    }
    @Param(a=40,b=60)
    static double min(int a, int b) {
        return a > b ? b : a;
    }

    @Param(a=44,b=66)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }

}
