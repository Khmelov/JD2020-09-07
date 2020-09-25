package by.it.hryntsaliou.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var num = new Scalar(3.1415);
        System.out.println(num);
        Var str = new Scalar("3.1415");
        System.out.println(str);
        Var vector = new Vector(new double[]{1.0, 2.0, 4.0});
        System.out.println(vector);
        Var strVector = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(strVector);
        Var matrix = new Matrix(new double[][]{{1.0, 2.0}, {3.0, 4.0}});
        System.out.println(matrix);
        Var strMatrix = new Matrix("{{1.0, 2.0}, {3.0, 4.0}}");
        System.out.println(strMatrix);
    }
}
