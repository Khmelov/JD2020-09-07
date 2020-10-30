package by.it.yatsevich.jd02_03;


import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cashier implements Runnable {

    private final String name;
    private final int number;

    Cashier(int number) {
        this.number = number;
        name = "Cashier №: " + number;
    }

    static boolean inWait = false;
    private static int checkCounter = 0;

    @Override
    public void run() {
        System.out.println(this + " worked");
        while (!Supervisor.planComplete()) {
            Buyer getPensioner = QueuePensioners.get();
            Buyer getBuyer = QueueBuyers.get();
            if (getPensioner != null) {
                servicePensioner(getPensioner);
            } else if (getBuyer != null) {
                serviceBuyer(getBuyer);
            } else {
                sleeper();
            }
        }

        System.out.println(this + " finish work");
    }

    private void serviceBuyer(Buyer getBuyer) {
        System.out.println(this + " start service" + getBuyer);
        int timer = Helper.getRandom(2000, 5000);
        synchronized (getBuyer) {
            getBuyer.notify();
            QueueBuyers.BUYERS_IN_QUEUE.getAndDecrement();
            printCheck(getBuyer);
        }
        Helper.sleep(timer);
        System.out.println(this + " finished service" + getBuyer);
    }

    private void printCheck(Buyer buyer) {
        checkCounter++;
        StringBuilder check = new StringBuilder();
        check.append("Check №:        ").append("Cashier №1:     ")
                .append("Cashier №2:     ")
                .append("Cashier №3:     ")
                .append("Cashier №4:     ")
                .append("Cashier №5:     ").append("Queue size:     ").append("Total sum:      \n");
        check.append(checkCounter).append("\n").append(buyer.getName()).append("\n");
        synchronized (this) {
            Set<Map.Entry<String, Integer>> entries = Basket.temp.entrySet();
            Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
                if (iterator.hasNext()) {
                    Map.Entry<String, Integer> entry = iterator.next();
                    check.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                }

            for (int i = 0; i < number; i++) {
                check.append("\t\t\t\t");
            }
            check.append("Check sum:").append(Basket.costOfGoods.get());
            for (int i = 0; i < 6 - number; i++) {
                check.append("\t\t\t\t");
            }
            check.append(QueueBuyers.BUYERS_IN_QUEUE.get()).append("\t\t\t\t").append(Basket.GLOBAL_SUM.get()).append("\n");
            System.out.flush();
            System.out.println(check);
        }
    }

    private void servicePensioner(Buyer getPensioner) {
        System.out.println(this + " start service" + getPensioner);
        int timer = Helper.getRandom(2000, 5000);
        synchronized (getPensioner) {
            getPensioner.notify();
            QueueBuyers.BUYERS_IN_QUEUE.getAndDecrement();
            printCheck(getPensioner);
        }
        Helper.sleep(timer);
        System.out.println(this + " finished service" + getPensioner);
    }

    private void sleeper() {
        synchronized (this) {
            QueueCashiers.add(this);
            inWait = true;
//          System.out.println(this+"Cashier close");
            try {
                this.wait();
                CashierManager.CASHIERS_COUNTER.getAndDecrement();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}

