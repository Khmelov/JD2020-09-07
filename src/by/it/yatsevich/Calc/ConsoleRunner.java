package by.it.yatsevich.Calc;

import java.util.Scanner;

class ConsoleRunner {

    public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        try {
            Var.load();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        for (;;) {
            String expression = scanner.nextLine();
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
