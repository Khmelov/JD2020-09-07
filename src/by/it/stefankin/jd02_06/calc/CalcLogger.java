package by.it.stefankin.jd02_06.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

enum  CalcLogger {
 GET;

    private final String filename="Calclog.txt";

  /*
    private static volatile CalcLogger logger;

    private CalcLogger(){

    }

    static CalcLogger getInstance() {
        CalcLogger localLogger= CalcLogger.logger;
        if (localLogger==null) {
            synchronized (CalcLogger.class) {
                localLogger = CalcLogger.logger;
                if (localLogger == null) {
                    logger = localLogger = new CalcLogger();
                }
            }
        }
        return localLogger;
    }

*/
    public void log(String text) {
        String fn = getFileName(CalcLogger.class, this.filename);

        try (PrintWriter writer = new PrintWriter(
                    new FileWriter(fn,true))){
           // Date date=new Date();
           // String timeToPrint=date.toString();
            writer.println(text);
        } catch (IOException e) {
           throw new RuntimeException(e);
        }

    }


    private static String getFileName(Class<?> aClass,String simpleName){
        String path =System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        path=path+aClass.getName().replace(".",File.separator);
        path=path.replace(aClass.getSimpleName(),"");
        return path+simpleName;
    }


}
