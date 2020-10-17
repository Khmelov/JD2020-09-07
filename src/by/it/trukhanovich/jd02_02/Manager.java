package by.it.trukhanovich.jd02_02;

public class Manager implements Runnable{

    private String name;

    public Manager(String name) {
        this.name = name;
    }
    private volatile static int countActivCashiers=0;

    public static int getCountActivCashiers() {
        return countActivCashiers;
    }

    static synchronized void cashiersTurnOn(){
        countActivCashiers++;
    }
    static synchronized void cashiersTurnOff(){
        countActivCashiers--;
    }

    @Override
    public void run() {
        for (; ; ) {
            int sizeQUEUE_buyers = QueueBuyers.getSizeQUEUE_BUYERS();
            if (sizeQUEUE_buyers==0){
                activateCashier();
                Helper.mySleep(100);
            }
            if (sizeQUEUE_buyers>0&&sizeQUEUE_buyers<=5&&countActivCashiers!=1) {
                for (int i = 0; i < 1-countActivCashiers; i++) {
                    activateCashier();
                }
            }
            else if (sizeQUEUE_buyers>5&&sizeQUEUE_buyers<=10&countActivCashiers!=2) {
                for (int i = 0; i < 2-countActivCashiers; i++) {
                    activateCashier();
                }
            }
            else if (sizeQUEUE_buyers>10&&sizeQUEUE_buyers<=15&countActivCashiers!=3) {
                for (int i = 0; i < 3-countActivCashiers; i++) {
                    activateCashier();
                }
            }
            else if (sizeQUEUE_buyers>15&&sizeQUEUE_buyers<=20&countActivCashiers!=4) {
                for (int i = 0; i < 4-countActivCashiers; i++) {
                    activateCashier();
                }
            }
            else if (sizeQUEUE_buyers>20&countActivCashiers!=5) {
                for (int i = 0; i < 5-countActivCashiers; i++) {
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

//                Cashier cashier = QueueCashier.extract();
//                if (cashier != null) {
//                    synchronized (cashier) {
//                        cashier.setWait(false);
//                        cashier.notify();
//                    }
//                } else Helper.mySleep(1);
//            }
//
//    }

    @Override
    public String toString() {
        return name;
    }
}
