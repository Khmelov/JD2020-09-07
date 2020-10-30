package by.it.hryntsaliou.jd02_02;

class Cashiers implements Runnable {

    private String name;

    Cashiers(int number) {
        name = "\tCashier №" + number;
        isWait = false;
    }

    private boolean isWait;

    public boolean isWait() {
        return isWait;
    }

    public void setWait(boolean wait) {
        isWait = wait;
    }

    private volatile static int countCashiers = 0;

    private void newCashier() {
        Cashier cashier = QueueCashiers.extract();
        if (cashier != null) {
            synchronized (cashier) {
                cashier.setWait(false);
                cashier.notifyAll();
            }
        }
        else {
            Helper.mySleep(1);
        }
    }

    static synchronized void addCashier() {
        countCashiers++;
    }

    static synchronized void removeCashier() {
        countCashiers--;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        for(;;) {
            int queueSize = QueueBuyers.getQueueSize();
            if(queueSize == 0) {
                newCashier();
            }
            if (queueSize > 0 && queueSize <= 5 && countCashiers != 1) {
                    newCashier();
            } else if (queueSize > 5 && queueSize <= 10 & countCashiers != 2) {
                    newCashier();
            } else if (queueSize > 10 && queueSize <= 15 & countCashiers != 3) {
                    newCashier();
            } else if (queueSize > 15 && queueSize <= 20 & countCashiers != 4) {
                    newCashier();
            } else if (queueSize > 20 & countCashiers != 5) {
                    newCashier();
            }
        }



    }
}
