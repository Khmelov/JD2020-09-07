package by.it.stefankin.jd02_06.calc;

import by.it.stefankin.jd02_06.Logger;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line;
        Parser parser=new Parser();
        Printer printer=new Printer();
        CalcLogger logger = CalcLogger.GET;



        while (!(line=sc.nextLine()).equals("end")) {
            try {
                Var result =parser.calc(line);
                printer.print(result);
                String restolog=result.toString();
                logger.log(line);
                logger.log(restolog);
            }
               catch (CalcException e){
                   System.out.println(e.getMessage());
               }


        }

    }

}
