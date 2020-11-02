package by.it.mialeshka.jd02_05.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logs {
    private static int i = 0;
    static void saveLog(String massage){
        if(i==51)
            i = 0;
       boolean isAddM = i==0?false:true;
       try(PrintWriter log = new PrintWriter(new FileWriter(System.getProperty("user.dir") + File.separator + "src" + File.separator
               + Logs.class.getName().replace(Logs.class.getSimpleName(), "").replace(".", File.separator) + File.separator + "log.txt.", isAddM))){
           log.println(massage);
           i++;
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
