package by.it.stefankin.jd01_13;

import by.it.stefankin.jd01_09.Var;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String vvod="";
        double sum=0;
       try {
           while (!(vvod = sc.nextLine()).equals("END")) {
               double number = Double.valueOf(vvod);
               if (number<0) throw new ArithmeticException();
               sum = sum + number;
               double sqrt = Math.sqrt(sum);
               System.out.println(number);
               System.out.println(sqrt);

           }
       } catch (ArithmeticException e){
               StackTraceElement[] stackTrace = e.getStackTrace();

               for (StackTraceElement element:stackTrace) {
                   if (TaskB.class.getName().equals(element.getClassName())) {
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
       catch (Exception e){
               StackTraceElement[] stackTrace = e.getStackTrace();
               for (StackTraceElement element:stackTrace) {
                   if (TaskB.class.getName().equals(element.getClassName())) {
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
