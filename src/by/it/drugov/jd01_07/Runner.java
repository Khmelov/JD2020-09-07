package by.it.drugov.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var num = new Scalar(3.1415);
        System.out.println(num);
        Var str = new Scalar("3.1415");
        System.out.println(str);
        Var arr = new Vector(new double[]{1.0, 2.0, 4.0});
        System.out.println(arr);
        Var strVector = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(strVector);
        Var matr = new Matrix(new double[][]{{1.0, 2.0}, {3.0, 4.0}});
        System.out.println(matr);
        Var strMatrix = new Matrix("{{67.89, 2.0}, {3.0, 4.0}}");
        System.out.println(strMatrix);

    }
}
