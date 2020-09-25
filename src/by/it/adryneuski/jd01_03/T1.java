package by.it.adryneuski.jd01_03;

public class T1 {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
            int counter=0;
            for (int j = i; j < n+1 ; j++) {
               // System.out.println("j="+j);
                counter+=j;
            }
                System.out.println(counter);
            }



    }
}
