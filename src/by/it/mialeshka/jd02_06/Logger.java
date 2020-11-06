package by.it.mialeshka.jd02_06;

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

    static Logger getInstance(){
        Logger localLogger = Logger.logger;
        if(localLogger == null){
            synchronized (Logger.class){
                localLogger = Logger.logger;
                if(localLogger == null)
                    logger = localLogger = new Logger();
            }
        }
        return localLogger;
    }

    private static String dir(Class<?> clName, String simpleName){
        String path = System.getProperty("user.dir")+ File.separator + "src" + File.separator;
        path = path + clName.getName().replace(clName.getSimpleName(), "").replace(".", File.separator);
        return path+simpleName;
    }

    public void print(String text) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(dir(Logger.class, filename), true))) {
            Date date = new Date();
            printWriter.printf("%2td %2tB %2tY %2tH:%2tM:%2tS %s", date, date, date, date, date, date, text);
            printWriter.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
