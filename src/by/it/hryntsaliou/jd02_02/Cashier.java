package by.it.hryntsaliou.jd02_02;

class Cashier implements Runnable {

    private String name;

    Cashier(int number) {
        name = "\tCashier №" + number;
        isWait = false;
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
        System.out.printf("%s opened\n", this);
        while (!Dispatcher.marketIsClosed()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.printf("%s started to sevice %s\n", this, buyer);
                Helper.mySleep(Helper.getRandom(2000, 5000));
                System.out.printf("%s finished to sevice %s\n", this, buyer);
                synchronized (buyer) {
                    buyer.setWait(false);
                    buyer.notifyAll();
                }

            } else {
                //???????
                Helper.mySleep(1);
            }
        }


        System.out.printf("%s closed\n", this);


    }

    @Override
    public String toString() {
        return name;
    }
}
