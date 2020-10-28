package by.it.yatsevich.jd02_02;


public class CashierManager implements Runnable {

    static volatile int CASHIERS_COUNTER =0;
    @Override
    public void run() {
        for(;;)getCashiers();
    }

    private void getCashiers() {
        int counter;
            if (QueueBuyers.BUYERS_IN_QUEUE >= 21&&CASHIERS_COUNTER!=5){
//                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWorked all Cashiers");
                counter=5;
                getUp(counter);
            }
            if (QueueBuyers.BUYERS_IN_QUEUE < 21 && QueueBuyers.BUYERS_IN_QUEUE >= 16 &&CASHIERS_COUNTER!=4) {
//                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWorked 4 Cashiers");
                counter=4;
                getUp(counter);
            }
            if (QueueBuyers.BUYERS_IN_QUEUE < 16 && QueueBuyers.BUYERS_IN_QUEUE >= 11&&CASHIERS_COUNTER!=3) {
//                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWorked 3 Cashiers");
                counter=3;
                getUp(counter);
            }
            if (QueueBuyers.BUYERS_IN_QUEUE < 11 && QueueBuyers.BUYERS_IN_QUEUE >= 6&&CASHIERS_COUNTER!=2) {
//                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWorked 2 Cashiers");
                counter=2;
                getUp(counter);
            }
            if (QueueBuyers.BUYERS_IN_QUEUE <= 5 &&CASHIERS_COUNTER!=1) {
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
                    CASHIERS_COUNTER++;
                }
            }
        }
        else{
            Helper.sleep(1);}
    }
}
