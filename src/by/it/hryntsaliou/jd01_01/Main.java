package by.it.hryntsaliou.jd01_01;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.printslogan();
        hello.setSlogan("Hello world!!!!!!!");
        hello.printslogan();
        Args argObject = new Args(args);
        argObject.printargs();
        Scanner sc = new Scanner(System.in);
    }
}