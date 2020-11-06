package by.it.mialeshka.calc;


import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();

            for (; ; ) {
                String expression = scanner.nextLine();
                if (expression.equals("end")) {
                    break;
                }

                if (expression.equals("printvar")) {
                    Var.printMap();
                }

                if (expression.equals("sortvar")) {
                    Var.printSortMap();
                }

                if(expression.equals("en") || expression.equals("ru") || expression.equals("be")){
                    ErrMesages.res.setLocale(expression);
                }
                else{
                    try {
                        Var result = parser.calc(expression);
                        printer.print(result);
                    }
                    catch (CalcException e){
                        System.out.println(e.getMessage());
                        Logs.saveLog(e.getMessage());
                    }
                }
            }
    }
}
