package by.it.trukhanovich.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Scanner sc=new Scanner(System.in);
        Parser parser=new Parser();
        Printer printer=new Printer();
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
         }
            printer.print (result);
        }

    }
}
