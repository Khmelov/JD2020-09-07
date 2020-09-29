package by.it.yatsevich.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var v1 = new Scalar(3.1415);
        System.out.println(v1);
        Var v2 = new Vector(new double[]{1,2,3});
        System.out.println(v2);
        Var v4 = new Matrix(new double[][]{ { 1.0, 2.0 }, { 5.0, 4.0 } , { 8.0, 7.0 } });
        System.out.println(v4);
        Var v5 = new Matrix("{ { 1.0, 2.0 } , { 3.0, 4.0 } }");
        System.out.println(v5);
    }
}
