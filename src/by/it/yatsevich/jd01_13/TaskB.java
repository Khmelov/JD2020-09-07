package by.it.yatsevich.jd01_13;

import java.util.Scanner;

class TaskB {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        double result = 0;
        try {
        while (!(line= scan.nextLine()).equals("END")){
            double value = Double.parseDouble(line);
            System.out.println(value);
            result += value;
            double res =Math.sqrt(result);
            if (Double.isNaN(res)) throw  new ArithmeticException();
            System.out.println(res);
            }
        }catch (ArithmeticException | NumberFormatException e){
            String exeptionName = e.getClass().getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                String methodName = element.getMethodName();
                if (methodName.equals("main")){
                    String className = element.getClassName();
                    int lineNumber = element.getLineNumber();
                    System.out.printf("  name: %s\n class: %s\n  line: %d\n",exeptionName,className,lineNumber);
                    break;
                }
            }
        }
    }
}
