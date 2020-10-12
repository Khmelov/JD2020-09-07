package by.it.shkatula.jd01_10;

public class Bean {
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 5, b = 6)
    static double max(int a, int b) {

        return Math.max(a, b);
    }

    @Param(a = 5, b = 6)
    double min(int a, int b) {
        return Math.min(a, b);
    }
    @Param(a = 5, b = 6)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
