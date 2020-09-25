package by.it.adryneuski.jd01_07;

public class Runner {
    public static void main(String[] args) {

        Var v = new Scalar(3.1415);
        System.out.println(v);

        Var str = new Scalar("3.1415");
        System.out.println(str);
        Var v2=new Vector(new double[]{1,2,3});
        System.out.println(v2);
//
//        Var arr = new Vector(new double[]{1.0, 2.0, 4.0});
//        System.out.println(arr);
//        Var strVector = new Vector("{1.0, 2.0, 4.0}");
//        System.out.println(strVector);
//
//        System.out.println(v2);


    }
}
