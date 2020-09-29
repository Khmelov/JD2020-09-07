package by.it._akhmelev_.jd01_07;

public class Runner {

    public static void main(String[] args) {
        Var v=new Scalar(123.456);
        System.out.println(v);
        Var v2=new Scalar((Scalar) v);
        System.out.println(v2);
        Var v3=new Scalar("123.321");
        System.out.println(v3);
    }
}
