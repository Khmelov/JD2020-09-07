package by.it.mialeshka.jd02_06;

public class Runner {
    static class ThreadTest extends Thread{

        public ThreadTest(String name) {
            super(name);
        }


        public void run(){
            Logger logger = Logger.getInstance();
            LoggerEnum logg = LoggerEnum.LOGG;
            logger.print(getName());
            logg.print(getName(), true);
        }
    }
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        LoggerEnum logg = LoggerEnum.LOGG;
        logger.print("first");
        logg.print("first", true);
        for (int i = 0; i < 10; i++) {
            new ThreadTest("th"+i).start();
        }
    }
}
