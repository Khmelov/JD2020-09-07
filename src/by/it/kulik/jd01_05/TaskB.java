package by.it.kulik.jd01_05;



public class TaskB {
    public static void main(String[] args) {
        double y;

        for (int x = 0; x < 7; x++) {
            for (double a = 0; a <= 2 ; a=a+0.2) {
                y=Math.pow(7, a) - Math.cos(x);
                System.out.printf("При а=%6.2f Сумма y=%g\n", a, y);
            }

        }
            }

        }

