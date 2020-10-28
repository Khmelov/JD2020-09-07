package by.it.stefankin.jd02_02;

public class Cashier implements Runnable {

    private String name;

    Cashier(int number) {
        name = "\tCashier №" + number;
    }

    private boolean isWait;

    public boolean isWait() {

        return isWait;
    }

    public void setWait(boolean wait) {

        isWait = wait;

    }




    @Override
    public void run() {

        System.out.printf("%s is opened\n", this);
        CashAdmin.countUp();
        if (CashAdmin.workOn) addToSQueue();
        while (CashAdmin.workOn) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.printf("%s started to sevice %s\n", this, buyer);
                Helper.mySleep(Helper.getRandom(2000, 5000));
                System.out.printf("%s finished to sevice %s\n", this, buyer);
                synchronized (buyer){
                    buyer.setWait(false);
                    buyer.notifyAll();
                }
                addToSQueue();
            }
            else{
                Helper.mySleep(1);

            }
        }

        System.out.printf("%s closed\n", this);


    }

    public void addToSQueue() {
        System.out.printf("%s go to SUBQueue\n", this);
        synchronized (this) {
            SubQfCash.add(this);
            CashAdmin.countDown();
            isWait = true;
            while (isWait) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

    public void stopToWork() {
        System.out.printf("%s job finished\n", this);
        synchronized (this) {
            CashAdmin.countDown();

        }


    }




    @Override
    public String toString() {

        return name;
    }
}
