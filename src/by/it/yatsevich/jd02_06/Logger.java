package by.it.yatsevich.jd02_06;

import by.it.yatsevich.jd01_14.TaskA;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {

    private static String filename="log.txt";
    private static volatile Logger logger;

    private Logger(){}

    static Logger getInstance() {
        Logger localLogger = Logger.logger;
        if (Logger.logger != null) {
            synchronized (Logger.class) {
             localLogger=Logger.logger;
             if (localLogger!=null){
                logger = localLogger = new Logger();
                }
            }
        }
        return localLogger;
    }


    private static String getPath() {
        String projectDir = System.getProperty("user.dir");
        String relativePath = Logger.class.getName()
                .replace(Logger.class.getSimpleName(), "")
                .replace(".", File.separator);
        return projectDir + File.separator + "src" + File.separator + relativePath+filename;
    }

    public static void log(String text) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(getPath()), true)) {
            Date date= new Date();
            writer.println(date.toString() + " "+text);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
