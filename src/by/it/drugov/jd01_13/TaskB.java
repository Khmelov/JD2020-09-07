package by.it.drugov.jd01_13;

import java.util.Scanner;

public class TaskB {

    static double getRoot(double num) throws ArithmeticException {
        double result = Math.sqrt(num);
        if(Double.isNaN(result))
            throw new ArithmeticException("ERROR");
        return result;
    }

    static double getDouble(String line) throws Exception {
        return Double.parseDouble(line);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        for (; ; ) {
            String line = scanner.next();
            if (line.equals("END")) {
                break;
            }
            Double num = null;
            try {
                num = getDouble(line);
                sum += num;
            } catch (Exception e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (int i = 0; i < stackTrace.length; i++) {
                    if (TaskB.class.getName().equals(stackTrace[i].getClassName())) {
                        System.out.println("  name: " + e.getClass().getSimpleName());
                        System.out.println(" class: " + stackTrace[i].getClassName());
                        System.out.println("  line: " + stackTrace[i].getLineNumber());
                    }
                }
            }
            Double root = null;
            try {
                root = getRoot(sum);
            } catch (ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (int i = 0; i < stackTrace.length; i++) {
                    if (TaskB.class.getName().equals(stackTrace[i].getClassName())) {
                        System.out.println("  name: " + e.getClass().getSimpleName());
                        System.out.println(" class: " + stackTrace[i].getClassName());
                        System.out.println("  line: " + stackTrace[i].getLineNumber());
                    }
                }
            }
            System.out.printf("%-3.2f\n%-3.2f\n", num, root);
        }
    }
}

