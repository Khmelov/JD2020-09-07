package by.it.kulik.jd01_05;


public class TaskB {
    public static void main(String[] args) {
        for (double a = 0; a <= 2; a += 0.2d) {
            
            for (int x = 1; x <= 6; x++) {

                double y = Math.pow(7, a) - Math.cos(x);
                System.out.printf("При а=%6.2f Сумма y=%g\n", a, y);
            }

        }
    }

}

