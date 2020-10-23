package by.it.makovsky.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            double sum=0;
            for(;;){
                String str= sc.nextLine();
                if (str.equals("END")){break;}
                double var = Double.parseDouble(str);
                System.out.println(var);
                sum=sum+var;
                if (sum<=0){
                    throw new ArithmeticException();
                }
                double root;
                root=Math.sqrt(sum);
                System.out.println(root);
            }
        } catch (NumberFormatException | ArithmeticException e) {
            printException(e);
        }
    }



    private static void printException(Exception e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        String nameException = e.getClass().getName();
        for (StackTraceElement element : stackTrace) {
            String methodName = element.getMethodName();
            if (methodName.equals("main")) {
                String className = element.getClassName();
                int lineNumber = element.getLineNumber();
                System.out.printf("  name: %s\n class: %s\n  line: %d", nameException, className, lineNumber);
                break;
            }
        }
    }
}
