package by.it.tarasevich.jd01_05;
import static java.lang.Math.*;
public class TaskC {

    public static void main(String[] args) {

        TackC1();
        TaskC2();
    }

    private static void TackC1() {
        int elem = (int)(Math.random() * 20) + 40;
        int arr[] = new int[elem];

        for (int i = 0; i <= arr.length;i++  ) {
            double x = (double)Math.random()+9-3.67;
            if (x >=5.33|| x<=9 ) {
                double z  = cbrt(x*x+4.5);
                System.out.println("Индекс"+" Число");
                System.out.printf("i = %6.2d z  f=%g\n",i,z);
                if (z > 3.5) {
                    //как передать в массив
//                    int array[] = new int[];
                    //как сформировать массив с нужным размеров за ранее не зная его


                }
            }

        }
    }

    private static void TaskC2() {
    }
}
