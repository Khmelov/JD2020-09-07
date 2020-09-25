package by.it.trukhanovich.jd01_06;

public class TaskC2 {
    public static void main(String[] args) {
        String text="привет ";
        long startSlow=System.nanoTime();
        String resultSlow = slow(text);
        long finishSlow=System.nanoTime();
        long durationSlow=(finishSlow-startSlow)/1000000;
        System.out.printf("Длинна resultSlow=%d символа;",resultSlow.length());
        System.out.printf("Время выполнения resultSlow=%d мс;\n",durationSlow);
        System.out.println(resultSlow);
        long startFast=System.nanoTime();
        String resultFast= fast(text);
        long finishFast=System.nanoTime();
        long durationFast=(finishFast-startFast)/1000000;
        System.out.printf("Длинна resultFast=%d символа;" ,resultFast.length());
        System.out.printf("Время выполнения resultFast=%d мс;",durationFast);
        System.out.println(resultFast);
    }

    private static String fast(String text) {
        StringBuilder s=new StringBuilder ("привет ");
        do {
            s=s.append(text);
        } while (s.length()<=100000);
        String fast=s.toString();
         return fast;
    }

    private static String slow(String text) {
        String s=new String("привет ");
        do {
            s=s.concat(text);
        } while (s.length()<=100000);
        return s;
    }
}
