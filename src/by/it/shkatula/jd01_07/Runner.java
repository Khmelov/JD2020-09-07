package by.it.shkatula.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var v1= new Scalar(3.1415);
        System.out.println(new Matrix("{{1.0,2.0},{3.0,4.0}}").toString());
        System.out.println(new Matrix("[[1.0,2.0],[3.0,4.0]]").toString());
    }
}
