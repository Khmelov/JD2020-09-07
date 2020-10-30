package by.it.hryntsaliou.jd02_06;

class Runner {
    static class Th extends Thread {
        public Th(String name) {
            super(name);
        }

        @Override
        public void run() {
            Logger logger = Logger.getInstance();
            logger.log(getName());
        }
    }

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("<begin>");
        for (int i = 0; i < 100; i++) {
            new Th("th" + i).start();
        }
    }
}
