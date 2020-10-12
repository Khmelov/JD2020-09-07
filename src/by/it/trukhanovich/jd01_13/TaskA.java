package by.it.trukhanovich.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {

            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
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
}
