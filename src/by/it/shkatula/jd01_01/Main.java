package by.it.shkatula.jd01_01;

public class Main {

    public static void main(String[] args) {

        Hello hello=new Hello();
        hello.printSlogan();
        hello.setSlogan("Bye world!");
        hello.printSlogan();

        Args argSomething=new Args(args);
        argSomething.printArgs();

    }
}
