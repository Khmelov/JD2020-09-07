package by.it.tarasevich.calculator;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        try {
            Var.load();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        for(;;){
            String expression = sc.nextLine();
            if (expression.equals("end")){
                break;
            }
            Var result = null;
            try {
                result = parser.calc(expression);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
            printer.print(result);
        }
    }
}
