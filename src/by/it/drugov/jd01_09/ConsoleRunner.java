package by.it.drugov.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        for (; ; ) {
            String line = scanner.nextLine();
            Var result = parser.calc(line);
            printer.print(result);
            if (line.equals("end"))
                break;
        }
    }
}
