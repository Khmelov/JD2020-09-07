package by.it.kalashnikov.jd02_03;

class Buyer extends Thread implements IBuyer {
    private final Dispatcher dispatcher;

    Buyer(int number, Dispatcher dispatcher) {
        super("Buyer №" + number);
        this.dispatcher = dispatcher;
        dispatcher.buyerEnterToMarket();
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
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
        dispatcher.buyerLeaveMarket();
    }

    @Override
    public void enterToMarket() {
        System.out.printf("%s enter to market", this);
    }

    @Override
    public void chooseGoods() {
        System.out.printf("%s started to choose\n", this);
        int timeout = Helper.getRandom(500, 2000);
        Helper.mySleep(timeout);
        System.out.printf("%s finished to choose\n", this);
    }

    @Override
    public void goToQueue() {
        System.out.printf("%s go to queue\n", this);
        synchronized (this) {
            QueueBuyers.add(this);
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

    @Override
    public void goOut() {
        System.out.printf("%s leaved market\n", this);

    }

    @Override
    public String toString() {
        return this.getName();
    }
}
