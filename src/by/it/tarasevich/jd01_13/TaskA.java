package by.it.tarasevich.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try{
            if (Math.random() > 0.5)
                new HashMap<String,String>(null);
            else Integer.parseInt("HI");

        }catch (Exception exception){
            StackTraceElement[] stackTraceElements = exception.getStackTrace();
            for (int i = 0; i < stackTraceElements.length; i++) {
                if (TaskA.class.getName().equals(stackTraceElements[i].getClassName())) {
                    System.out.printf("name: %s\n" + "class: %s\n"+ "line: %d\n",
                            exception.getClass().getName(),stackTraceElements[i].getClassName(),
                            stackTraceElements[i].getLineNumber());

                }

            }
        }
    }
}
