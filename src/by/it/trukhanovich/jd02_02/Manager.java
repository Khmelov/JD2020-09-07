package by.it.trukhanovich.jd02_02;

public class Manager implements Runnable{

    private String name;

    public Manager(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (; ; ) {
            int sizeQUEUE_buyers = QueueBuyers.getSizeQUEUE_BUYERS();
            if (sizeQUEUE_buyers==0){
                activateCashier();
            }
            if (sizeQUEUE_buyers>0&&sizeQUEUE_buyers<=5) {
                int activCashiers = Market.cashiers.activeCount();
                for (int i = 0; i < 1; i++) {
                    activateCashier();
                }
            }
            else if (sizeQUEUE_buyers>5&&sizeQUEUE_buyers<=10) {
                int activCashiers = Market.cashiers.activeCount();
                for (int i = 0; i < 2; i++) {
                    activateCashier();
                }
            }
            else if (sizeQUEUE_buyers>10&&sizeQUEUE_buyers<=15) {
                int activCashiers = Market.cashiers.activeCount();
                for (int i = 0; i < 3; i++) {
                    activateCashier();
                }
            }
            else if (sizeQUEUE_buyers>15&&sizeQUEUE_buyers<=20) {
                int activCashiers = Market.cashiers.activeCount();
                for (int i = 0; i < 4; i++) {
                    activateCashier();
                }
            }
            else if (sizeQUEUE_buyers>20) {
                int activCashiers = Market.cashiers.activeCount();
                for (int i = 0; i < 5; i++) {
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
         } else{ System.out.println("\t\t\t\t\t\t\t\t\t\t\t Очередь"+QueueBuyers.getSizeQUEUE_BUYERS()+" но больше касс нет");
         Helper.mySleep(1000);}

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
