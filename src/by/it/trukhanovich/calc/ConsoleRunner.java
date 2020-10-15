package by.it.trukhanovich.calc;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Scanner sc=new Scanner(System.in);
        Parser parser=new Parser();
        Printer printer=new Printer();
        try {
            Var.load();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        for (;;){
         String expression= sc.nextLine();
         if (expression.equals("printvar")){
             System.out.println(Var.vars);
         }
         if (expression.equals("sortvar")){
             System.out.println(Var.sortMap());
         }
         if (expression.equals("end")){
             break;
         }
         Var result=null;
         try {

             result=parser.calc(expression);
         } catch (CalcException e) {
             System.out.println(e.getMessage());
             saveLogToTxt("log.txt",e.getMessage());
         }
            printer.print (result);
        }

    }
    private static void saveLogToTxt (String name, String log) throws CalcException {
        String path=getPath(ConsoleRunner.class)+name;
        try (PrintWriter writer = new PrintWriter(new FileWriter(path,true)))
        {
            writer.println(log);

        } catch (IOException e) {
            throw new CalcException(e);
        }
    }
    private static String getPath(Class<?> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskAClass
                .getName()
                .replace(taskAClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }
}
