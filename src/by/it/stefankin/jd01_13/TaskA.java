package by.it.stefankin.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {

        try {

            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }
        catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element:stackTrace) {
                if (TaskA.class.getName().equals(element.getClassName())) {
                  //  System.out.println(element);
                    String name = e.getClass().getName();
                    String cls = element.getClassName();
                    int line=element.getLineNumber();
                    System.out.println("name: "+name);
                    System.out.println("class: "+cls);
                    System.out.println("line: "+line);

                    break;

                }



            }


        }
    }


}
