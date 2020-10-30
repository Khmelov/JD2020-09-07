package by.it.yatsevich.jd02_03;


import java.util.concurrent.atomic.AtomicInteger;

public class CashierManager implements Runnable {

    static AtomicInteger CASHIERS_COUNTER = new AtomicInteger(0);
    @Override
    public void run() {
        for(;;)getCashiers();
    }

    private void getCashiers() {
        int counter;
        int qByr=QueueBuyers.BUYERS_IN_QUEUE.get();
            if ( qByr>= 21&&CASHIERS_COUNTER.get()!=5){
//                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWorked all Cashiers");
                counter=5;
                getUp(counter);
            }
            if (qByr < 21 && qByr >= 16 &&CASHIERS_COUNTER.get()!=4) {
//                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWorked 4 Cashiers");
                counter=4;
                getUp(counter);
            }
            if (qByr < 16 && qByr >= 11&&CASHIERS_COUNTER.get()!=3) {
//                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWorked 3 Cashiers");
                counter=3;
                getUp(counter);
            }
            if (qByr < 11 && qByr >= 6&&CASHIERS_COUNTER.get() !=2) {
//                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWorked 2 Cashiers");
                counter=2;
                getUp(counter);
            }
            if (qByr <= 5 &&CASHIERS_COUNTER.get()!=1) {
//                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWorked 1 Cashier");
                counter=1;
                getUp(counter);
            }
    }





    private void getUp(int counter) {
    Cashier cashier = QueueCashiers.get();
        if (cashier != null) {
            synchronized (cashier) {
                for (int j = 0; j <counter ; j++) {
                    cashier.notify();
//                    System.out.println(cashier+"awaken");
                    CASHIERS_COUNTER.getAndIncrement();
                }
            }
        }
        else{
            Helper.sleep(1);}
    }
}
