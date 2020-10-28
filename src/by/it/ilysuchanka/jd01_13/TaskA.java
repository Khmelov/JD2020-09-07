package by.it.ilysuchanka.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main (String[] ergs){
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }
        catch (Exception e){
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            for (StackTraceElement element : stackTraceElements) {
                if (TaskA.class.getName().equals(element.getClassName())){
                    System.out.println(element);
                    String name = e.getClass().getName();
                    String clname = element.getClassName();
                    int number = element.getLineNumber();
                    System.out.printf(
                            "name: %s\n" +
                            "class: %s\n" +
                            "line: %d\n",
                            name,clname,number);
                }
            }
        }
    }
}
