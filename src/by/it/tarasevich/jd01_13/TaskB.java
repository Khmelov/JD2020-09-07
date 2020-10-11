package by.it.tarasevich.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        for (; ; ) {
            String line = scanner.next();
            if (line.equals("END")) {
                break;
            }
            Double number = null;
            try {
                number = Double.parseDouble(line);
                sum += number;
            } catch (Exception exception) {
                StackTraceElement[] stackTraceElements = exception.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTraceElements) {
                    if (TaskB.class.getName().equals(stackTraceElement.getClassName())) {
                        System.out.printf("name: %s\n" + "class: %s\n" + "line: %d\n",
                                exception.getClass().getName(), stackTraceElement.getClassName(),
                                stackTraceElement.getLineNumber());

                    }

                }
            }
            Double sqrt = null;
            try {
                sqrt = Math.sqrt(sum);
                if (Double.isNaN(sqrt)) {
                    throw new ArithmeticException("Error");
                }
            } catch (ArithmeticException e) {
                StackTraceElement[] stackTraceElements = e.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTraceElements) {
                    if (TaskB.class.getName().equals(stackTraceElement.getClassName())) {
                        System.out.printf("name: %s\n" + "class: %s\n" + "line: %d\n",
                                e.getClass().getName(), stackTraceElement.getClassName(),
                                stackTraceElement.getLineNumber());

                    }
                }

            }
            System.out.println(number + " " + sqrt);
        }
    }
}
