package by.it.kulik.jd02_02;

public class Cashier implements Runnable {
    private String name;

    @Override
    public String toString() {
        return name;
    }

    Cashier(int number) {
        name = "\tCashier № " + number + ": ";
    }

    @Override
    public void run() {
        System.out.println(this + " opened");
        while (!Manager.planCompleted()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.println(this + " begin to service " + buyer);
                int t = Helper.getRandom(2000, 5000);
                Helper.mySleep(t);
                System.out.println(this + " finished to service " + buyer);
synchronized (buyer){
    buyer.notify();
    System.out.flush();
}

            }
            else {
                Helper.mySleep(1);
            }
        }
        System.out.println(this + " closed");
    }
}
