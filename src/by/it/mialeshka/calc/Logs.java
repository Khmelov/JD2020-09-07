package by.it.mialeshka.calc;

import by.it.mialeshka.jd02_06.LoggerEnum;

public class Logs {
    private static int i;
    static void saveLog(String massage){
        if(i==51)
            i = 0;
        boolean isAddM = i==0?false:true;
        LoggerEnum.LOGG.print(massage, isAddM);
        i++;
    }
}
