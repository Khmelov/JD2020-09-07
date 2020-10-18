package by.it.adryneuski.jd01_13;

import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double summa = 0;
        for (; ;)  {
            String s = scanner.next();
            if (s.equals("END")) {
                break;
            }
            Double number = null;
            Double sqrt = null;
            try {
                number = Double.parseDouble(s);
                summa += number;
                sqrt = Math.sqrt(summa);
                if (Double.isNaN(sqrt)) {
                    throw new ArithmeticException("Error: ");
                }
            } catch (NumberFormatException |ArithmeticException e) {
                StackTraceElement[] stackTraceElements = e.getStackTrace();
                for (StackTraceElement element : stackTraceElements) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        System.out.printf(
                                " name: %s\n" +
                                        "class: %s\n" +
                                        " line: %d\n",
                                e.getClass().getName(), element.getClassName(),
                                element.getLineNumber());
                    }
                }
            }
            System.out.println(number);
            System.out.println(sqrt);
        }
    }
}
