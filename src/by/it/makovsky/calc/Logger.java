package by.it.makovsky.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {
    private final String filename="log.txt";
    private static volatile Logger logger;

    private Logger() {
    }

    static Logger getInstance(){
        Logger localLogger=Logger.logger;
        if(localLogger==null){
            synchronized (Logger.class){
                localLogger=Logger.logger;
                if(localLogger==null) {
                    logger = localLogger = new Logger();
                }
            }
        }
        return localLogger;
    }

    public void log(String text) {
        String fn=getPath(Logger.class,this.filename);
        try (
            PrintWriter writer=new PrintWriter(new FileWriter(fn,true));
        ) {
            writer.println(text);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*private static String getPath(Class<?> aClass, String name) {
        String rootProject = System.getProperty("user.dir")+ File.separator + "src" + File.separator;
        rootProject = rootProject+aClass
                .getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject +name;
    }

     */
    private static String getPath(Class<?> taskAClass,String name) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskAClass
                .getName()
                .replace(taskAClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath+name;
    }

}
