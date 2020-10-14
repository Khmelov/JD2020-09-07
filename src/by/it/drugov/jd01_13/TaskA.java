package by.it.drugov.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (int i = 0; i < stackTrace.length; i++) {
                if (TaskA.class.getName().equals(stackTrace[i].getClassName())) {
                    System.out.println("  name: " + e.getClass().getName());
                    System.out.println(" class: " + stackTrace[i].getClassName());
                    System.out.println("  line: " + stackTrace[i].getLineNumber());
                }
            }
        }
    }
}
