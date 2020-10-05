package by.it.drugov.jd01_10;

class Bean {
    @Param(a = 5, b = 8)
    static double sum(int a, int b) {
        System.out.println(a+b);
        return a + b;
    }

    @Param(a = 333, b = 666)
    static double max(int a, int b) {
        return a > b ? a : b;
    }

    @Param(a = 345, b = 456)
    double min(int a, int b) {
        return a < b ? a : b;
    }

    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
