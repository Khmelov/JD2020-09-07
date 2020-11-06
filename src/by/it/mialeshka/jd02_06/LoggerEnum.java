package by.it.mialeshka.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public enum LoggerEnum {
    LOGG;
    private final String filename = "logEnum.txt";
    private static volatile LoggerEnum logger;


    private static String dir(Class<?> clName, String simpleName){
        String path = System.getProperty("user.dir")+ File.separator + "src" + File.separator;
        path = path + clName.getName().replace(clName.getSimpleName(), "").replace(".", File.separator);
        return path+simpleName;
    }

    public void print(String text, boolean irRewrite) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(dir(LoggerEnum.class, filename), irRewrite))) {
            Date date = new Date();
            printWriter.printf("%2td %2tB %2tY %2tH:%2tM:%2tS %s", date, date, date, date, date, date, text);
            printWriter.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
