package by.it.tarasevich.jd01_07;

public class Ranner {

    public static void main(String[] args) {
        Var v1 = new Scalar(3.1452);
        Var v2 = new Scalar("3.1452");
        System.out.println(v1);
        System.out.println(v2);

        Vector v3 = new Vector(new double[]{1.0, 2.0, 4.0});
        Vector v4  = new Vector(new String("{1.1, 2.1, 4.1}"));
        System.out.println(v3);
        System.out.println(v4);
    }
}
