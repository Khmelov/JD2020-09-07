package by.it.yatsevich.jd01_07;

class Runner {
    public static void main(String[] args) {
        Var v1 = new Scalar(3.1415);
        Var v2 = new Vector(new double[]{1,2,3});
        System.out.println(v1);
        System.out.println(v2);
    }
}
