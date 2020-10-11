package by.it.adryneuski.jd01_07;

public class Runner {
    public static void main(String[] args) {


        Var v = new Scalar(3.1415);
        System.out.println(v);

        Var v1 = new Scalar((Scalar) v);
        System.out.println(v1);

        Var v2 = new Scalar("3.1415");
        System.out.println(v2);


    }
}