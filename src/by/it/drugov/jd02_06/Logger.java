package by.it.drugov.jd02_06;

import java.io.*;

public class Logger {

    private String filename = "log.txt";
    private static volatile Logger logger;
    private Logger() {

    }

    static Logger getInstance(){
        Logger localLogger = Logger.logger;
        if(localLogger==null) {
            synchronized (Logger.class) {
                localLogger = Logger.logger;
                if(localLogger==null){
                    logger = localLogger = new Logger();
                }
            }
        }
        return localLogger;
    }


    private static String dir(Class<?> cl,String simpleName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classDir+simpleName;
    }

    public void log(String line) {
        String fileName = dir(Logger.class,this.filename);
        try(PrintWriter writer =  new PrintWriter(
                new FileWriter(fileName,true))
        ) {
            writer.println(line);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
