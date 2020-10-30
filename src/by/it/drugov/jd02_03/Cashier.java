package by.it.drugov.jd02_03;

public class Cashier implements Runnable {
    private final String name;
    private final Dispatcher dispatcher;
    Cashier(int number, Dispatcher dispatcher) {
        name = "\tCashier №" + number;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
     /*   if(Dispatcher.countBuyersInQueue>25) {
            System.out.println("------------aaa");
            startWorking();
        } */
        System.out.printf("%s opened\n", this);
        System.out.flush();
        while (!dispatcher.marketIsClosed()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.printf("%s started to service %s\n", this, buyer);
                Helper.mySleep(Helper.getRandom(2000, 5000));
                System.out.printf("%s finished to service %s\n", this, buyer);
                if(Dispatcher.countBuyersInQueue > 0 ) {
                    Dispatcher.decreaseCountBuyersInQueue();
                    System.out.println("\t\tAmount of buyers in queue : "+Dispatcher.countBuyersInQueue);
                }
                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (buyer) {
                    buyer.setWait(false);
                    buyer.notifyAll();
                }
            } else {
                Helper.mySleep(1);
            }
        }
        System.out.printf("%s closed\n", this);
     //   goToQueue();

    }

 /*   public void startWorking() {

    }
    public void goToQueue() {
        synchronized (this) {
            QueueCashiers.add(this);
            isWait = true;
            while (isWait) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    } */

    @Override
    public String toString() {
        return name;
    }
}
