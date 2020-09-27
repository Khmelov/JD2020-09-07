package by.it.kulik.jd01_08;


public class Runner {
    public static void main(String[] args) {
       Var num=new Scalar(3.1415);
        System.out.println(num);
        Var str=new Scalar("3.1415");
        System.out.println(str);
        Var arr=new Vector(new double[]{1,2,4});
        System.out.println(arr);
        Var strArr=new Vector("{1,2,4}");
        System.out.println(strArr);
        Var mulArr=new Matrix(new double[][]{{1,2},{3,4}});
        System.out.println(mulArr);
    }
}