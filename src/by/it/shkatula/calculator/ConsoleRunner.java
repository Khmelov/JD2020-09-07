package by.it.shkatula.calculator;


import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        VarCreator varCreator = new VarCreator();
        Scanner scanner = new Scanner(System.in);
        String line;

        Parser parser = new Parser(varCreator);
        Printer printer = new Printer();
        while (!(line=scanner.nextLine()).equals("end")) {
            try {
                Var result = parser.calc(line);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());;
            }

        }
    }

}
