package by.it.trukhanovich.jd01_07;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Var v1= new Scalar(3.1415);
        Var v2 = new Scalar("3.1415");
        System.out.println(v1);
        System.out.println(v2);
        Var v3=new Vector(new double[]{1.0, 2.0, 4.0});
        Var v4= new Vector (new String("{1.1, 2.1, 4.1}"));
        System.out.println(v3);
        System.out.println(v4);
        Var v5=new Matrix (new double[][] {{1.5, 2.5}, {3.5,4.5}});
        System.out.println(v5);
        Var v6=new Matrix ("{{1,2}, {3,4}}");
        System.out.println(v6);

    }
}
