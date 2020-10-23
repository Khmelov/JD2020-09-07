package by.it.shkatula.jd01_13;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        List<Double> arr = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String number;

        while (!(number = scanner.next()).equalsIgnoreCase("end")) {
            try {
                double valueDouble = Double.parseDouble(number);

                arr.add(valueDouble);

                System.out.println(valueDouble);
                double sum = getSum(arr);
                double sqrt = Math.sqrt(sum);
                if (Double.isNaN(sqrt)) {
                    throw new ArithmeticException();
                }
                System.out.println(sqrt);

            } catch (NumberFormatException | ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {

                    if (TaskB.class.getName().equals(stackTraceElement.getClassName())) {
                        String name = e.getClass().getName();
                        String className = stackTraceElement.getClassName();
                        int line = stackTraceElement.getLineNumber();
                        System.out.printf("  name:  %s\n" + " class:  %s\n" + "  line:  %d", name, className, line);
                        break;
                    }
                }

            }
        }
    }

    // list {1,2,3,4}
    private static double getSum(List<Double> list) {
        double sumElements = 0;
        for (Double element : list) {
            sumElements += element;
        }
        return sumElements;
    }
}
