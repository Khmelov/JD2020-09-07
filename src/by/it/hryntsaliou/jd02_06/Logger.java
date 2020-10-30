package by.it.hryntsaliou.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class Logger {
    private final String filename = "log.txt";
    private static volatile Logger logger;

    private Logger() {
    }

    static Logger getInstance() {
        Logger localLogger = Logger.logger;
        if (localLogger == null) {
            synchronized (Logger.class) {
                localLogger = Logger.logger;
                if (localLogger == null) {
                    logger = localLogger = new Logger();
                }
            }
        }
        return localLogger;
    }

    private static String getData() {
        Locale locale = new Locale("en", "UK");
        Date date = new Date();
        DateFormat simpleDateFormat = SimpleDateFormat.getDateInstance(SimpleDateFormat.FULL, locale);
        DateFormat simpleTimeFormat = SimpleDateFormat.getTimeInstance(SimpleDateFormat.DEFAULT, locale);
        return simpleDateFormat.format(date) + " " + simpleTimeFormat.format(date);
    }

    public void log(String text) {
        String newFilename = getName(Logger.class, this.filename);
        try (PrintWriter writer = new PrintWriter(new FileWriter(newFilename, true))) {
            writer.println(text + " : " + getData());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getName(Class<?> aClass, String simpleName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = aClass.getName().replace(aClass.getSimpleName(), "").replace(".", File.separator);
        return path + classDir + simpleName;
    }

}
