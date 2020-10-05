package by.it.stefankin.jd01_07;

public class Runner {

    public static void main(String[] args) {

        Scalar a=new Scalar(5.5);
        System.out.println(a);
        Scalar b=new Scalar(a);
        System.out.println(b);
        String fc="45";
        Scalar c=new Scalar(fc);
        System.out.println(c);
        System.out.println(b.toString());


        double[] fov = {1.2,5.4,7.6};
        Vector av=new Vector(fov);
        System.out.println(av.toString());
        Vector bv=new Vector(av);
        System.out.println(bv.toString());
        Vector cv =new Vector("5.5,8,8.4");
        System.out.println(cv.toString());







    }

}
