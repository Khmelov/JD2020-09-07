package by.it.trukhanovich.jd02_02;

public class Manager implements Runnable{

    private final String name;

    public Manager(String name) {
        this.name = name;
    }
    private volatile static int countActivCashiers=0;

    static synchronized void cashiersTurnOn(){
        countActivCashiers++;
    }
    static synchronized void cashiersTurnOff(){
        countActivCashiers--;
    }

    @Override
    public void run() {
        for (; ; ) {

                int sizeQueue = QueueBuyers.getSizeQUEUE_BUYERS()
                        + QueueBuyersPensioneer.getSizeQUEUE_BUYERS_PENSIONEER();
                if (sizeQueue == 0) {
                    activateCashier();
//                    Helper.mySleep(1);
                }
                if (sizeQueue > 0 && sizeQueue <= 5 && countActivCashiers != 1) {
                    for (int i = 0; i < 1 - countActivCashiers; i++) {
                        activateCashier();
                    }
                } else if (sizeQueue > 5 && sizeQueue <= 10 & countActivCashiers != 2) {
                    for (int i = 0; i < 2 - countActivCashiers; i++) {
                        activateCashier();
                    }
                } else if (sizeQueue > 10 && sizeQueue <= 15 & countActivCashiers != 3) {
                    for (int i = 0; i < 3 - countActivCashiers; i++) {
                        activateCashier();
                    }
                } else if (sizeQueue > 15 && sizeQueue <= 20 & countActivCashiers != 4) {
                    for (int i = 0; i < 4 - countActivCashiers; i++) {
                        activateCashier();
                    }
                } else if (sizeQueue > 20 & countActivCashiers != 5) {
                    for (int i = 0; i < 5 - countActivCashiers; i++) {
                        activateCashier();
                    }
                }
        }
    }

    private void activateCashier() {
         Cashier cashier = QueueCashier.extract();
         if (cashier != null) {
            synchronized (cashier) {
                cashier.setWait(false);
                cashier.notify();
            }
         }
         else{
            Helper.mySleep(1);}

    }


    @Override
    public String toString() {
        return name;
    }
}
