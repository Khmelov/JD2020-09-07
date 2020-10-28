package by.it.drugov.jd02_04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();

        for (; ; ) {
            String line = scanner.nextLine();
            saveLogToTxt("log.txt", line);
            if (line.equals("end"))
                break;
            Var result = null;
            try {
                result = parser.calc(line);
                saveLogToTxt("log.txt", String.valueOf(result));
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                saveLogToTxt("log.txt",e.getMessage());
            }
            printer.print (result);
        }
    }

    private static void saveLogToTxt(String name, String log) throws CalcException {
        String path = getPath(ConsoleRunner.class) + name;
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
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
