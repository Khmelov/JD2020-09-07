package by.it.shkatula.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {

    private final String filename = "log.txt";
    private static volatile Logger logger;

    private Logger() {

    }

    static Logger getInstance() {
        Logger localLoger = Logger.logger;
        if (logger == null) {
            synchronized (Logger.class) {
                localLoger = Logger.logger;
                if (localLoger == null){
                logger = localLoger = new Logger();
            }}
        }
        return localLoger;

    }


    private static String getPath(Class<?> taskAClass, String simpleName) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskAClass
                .getName()
                .replace(taskAClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath + File.separator+ simpleName;
    }

    public void log(String text) {
        Date date = new Date();
        try (
            PrintWriter writer = new PrintWriter(
                    new FileWriter(getPath(Logger.class, this.filename), true));
        ){    writer.println(text + " - " +date);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
