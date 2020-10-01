package by.it.hryntsaliou.jd01_10;

class Bean {

    @Param(a = 1, b = 2)
    static double sum(int a, int b) {
        return a+b;
    }
    @Param(a = 3, b = 4)
    static double max(int a, int b) {
        return a > b ? a : b;
    }
    @Param(a = 5, b = 6)
    double min(int a, int b) {
        return a < b ? a : b;
    }
    double avg(int a, int b) {
        return (a+b) / 2.0;
    }

}