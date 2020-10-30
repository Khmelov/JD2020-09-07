package by.it.kulik.jd01_13;

import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        for (; ; ) {
            String line = scanner.next();
            if (line.equals("end")) {
                break;
            }
            Double number=null;
            try {
                number = Double.parseDouble(line);
                sum =sum + number;
            } catch (Exception e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (int i = 0; i < stackTrace.length; i++) {
                    if (TaskB.class.getName().equals(stackTrace[i].getClassName())) {
                        System.out.printf(" name: %s\n" +
                                        "class: %s\n" +
                                        " line: %d\n",
                                e.getClass().getName(),
                                stackTrace[i].getClassName(),
                                stackTrace[i].getLineNumber());
                    }
                }
            }
            Double sqrt = null;
            try {
                sqrt = Math.sqrt(sum);
                if(Double.isNaN(sqrt)) {
                    throw new ArithmeticException("ERROR");
                }
            } catch (ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (int i = 0; i < stackTrace.length; i++) {
                    if (TaskB.class.getName().equals(stackTrace[i].getClassName())) {
                        System.out.printf(" name: %s\n" +
                                        "class: %s\n" +
                                        " line: %d\n",
                                e.getClass().getName(),
                                stackTrace[i].getClassName(),
                                stackTrace[i].getLineNumber());
                    }
                }
            }
            System.out.println(number + " " + sqrt);
        }
    }
}
