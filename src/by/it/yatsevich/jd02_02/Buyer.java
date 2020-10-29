package by.it.yatsevich.jd02_02;

class Buyer extends Thread implements IBayer, IUseBasket {

    private static boolean pensioner = false;

    static volatile int goods;

    public Buyer(int number) {
        super("Bayer №" + number);
        Supervisor.addBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();

        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.printf("%s enter to market\n", this);
    }

    @Override
    public void chooseGoods() {
        Supervisor.COUNTS_OF_GOODS=Helper.getRandom(1,4);
        if (Supervisor.BUYER_IN_THE_SHOP % 4 == 0) pensioner = true;
        int timeout;
        if (!pensioner) {
            System.out.printf("%s PENSIONER starting choose\n", this);
            timeout = Supervisor.COUNTS_OF_GOODS * (int) (Helper.getRandom(500, 2000) * 1.5);
        } else {
            System.out.printf("%s starting choose\n", this);
            timeout = Supervisor.COUNTS_OF_GOODS * Helper.getRandom(500, 2000);
        }
        Helper.sleep(timeout);

        System.out.printf("%s chose %d good\n", this, Supervisor.COUNTS_OF_GOODS);

    }

    @Override
    public void goOut() {
        synchronized (this) {
            System.out.printf("%s buyer go out\n", this);
            Supervisor.deleteBuyer();
            Supervisor.BUYER_IN_THE_SHOP--;
        }
    }

    @Override
    public void goToQueue() {
        synchronized (this) {
            if (pensioner) {
                QueuePensioners.add(this);
                QueueBuyers.BUYERS_IN_QUEUE++;
                try {
                    System.out.println(this + " add to QueuePensioners");
                    wait();
                    System.out.println(this + " leave the QueuePensioners");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            } else {
                QueueBuyers.add(this);
                QueueBuyers.BUYERS_IN_QUEUE++;
                try {
                    System.out.println(this + " add to queue");
                    wait();
                    System.out.println(this + " leave the queue");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.printf("%s buyer get basket\n", this);
    }

    @Override
    public void putGoodsToBasket() {
        System.out.printf("%s put %d goods to basket\n", this, Supervisor.COUNTS_OF_GOODS);
//        synchronized (Basket.temp) {
        Basket.putToBasket(Supervisor.COUNTS_OF_GOODS);
//            System.out.println(Basket.temp);
//            System.out.printf("%s Total purchase value : %3d$\n",this, goods);
//        }
        System.out.printf("%s finished choose\n", this);
    }
}
