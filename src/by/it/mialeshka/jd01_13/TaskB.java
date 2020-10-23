package by.it.mialeshka.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        double sum = 0.0;
        try
        {
            while (!(str=scanner.next()).equalsIgnoreCase("end")){
                double element = Double.parseDouble(str);
                sum = sum + element;
                double sqrt = Math.sqrt(sum);
                if(Double.isNaN(sqrt)){
                    throw new ArithmeticException("Err");
                }
                System.out.println(element);
                System.out.println(sqrt);
            }
        }
        catch (NumberFormatException | ArithmeticException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element:stackTrace) {
                if (TaskB.class.getName().equals(element.getClassName())){
                    String name = e.getClass().getName();
                    String clName = element.getClassName();
                    int strNumber = element.getLineNumber();
                    System.out.printf("name: %s\nclass: %s\nline: %d", name, clName, strNumber);
                }
            }
        }
    }
}
