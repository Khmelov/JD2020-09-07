package by.it.stefankin.jd02_02;

import static by.it.stefankin.jd02_02.SubQfCash.*;

public class CashAdmin implements Runnable {

   static private int countCashierActive =0;

   public static boolean workOn = true;

    public static synchronized void  countDown(){
         countCashierActive--;
    }

    public static synchronized void  countUp(){
        countCashierActive++;
    }


    @Override
    public void run() {
        System.out.println("ADMIN");
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            thread.start();
            Market.threads.add(thread);
            Helper.mySleep(1000);

        }
        while (!Dispatcher.marketIsClosed()) {

                Helper.mySleep(500);
                System.out.println("Cashiers on " + countCashierActive);
                int numbOfBuyers = QueueBuyers.getNumber();
                System.out.println(numbOfBuyers);
                /*if (numbOfBuyers == 0) {
                    pushCashier();
                } else*/
                    if (numbOfBuyers > 0 && numbOfBuyers <= 5 && countCashierActive != 1) {
                    for (int i = 0; i < 1 - countCashierActive; i++) {
                        pushCashier();
                    }
                } else if (numbOfBuyers > 5 && numbOfBuyers <= 10 && countCashierActive != 1) {
                    for (int i = 0; i < 2 - countCashierActive; i++) {
                        pushCashier();
                    }
                } else if (numbOfBuyers > 10 && numbOfBuyers <= 15 && countCashierActive != 1) {
                    for (int i = 0; i < 3 - countCashierActive; i++) {
                        pushCashier();
                    }
                } else if (numbOfBuyers > 15 && numbOfBuyers <= 20 && countCashierActive != 1) {
                    for (int i = 0; i < 4 - countCashierActive; i++) {
                        pushCashier();
                    }
                } else if (numbOfBuyers > 20 && countCashierActive != 5) {
                    for (int i = 0; i < 5 - countCashierActive; i++) {
                        pushCashier();
                    }
                }

            }
        System.out.println("цикл админа кассиров отработал");
        System.out.println(SubQfCash.getSubQueueSize());
        shotDownCashiers();
        System.out.println(SubQfCash.getSubQueueSize());
    }

    private void pushCashier(){

        Cashier cashier = SubQfCash.extract();

        if (cashier != null) {
            System.out.printf("Go to work! %s\n", cashier);
            CashAdmin.countUp();
            synchronized (cashier) {
                cashier.setWait(false);
                cashier.notifyAll();
            }
            Helper.mySleep(1000);
        }

    }
    private void shotDownCashiers(){
        workOn=false;

        for (int i = 0; i < 5; i++) {

            Cashier cashier = SubQfCash.extract();

            if (cashier != null) {
                System.out.printf("What is your name? %s\n", cashier);
                   synchronized (cashier) {
                       cashier.setWait(false);
                       cashier.notify();

                }
                Helper.mySleep(1000);
            }
        }
    }



}
