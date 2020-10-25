package by.it.yatsevich.jd02_02;

import by.it.trukhanovich.jd02_02.QueueCashier;

class Buyer extends Thread implements IBayer, IUseBasket {

    public Buyer(int number) {
        super("Bayer №"+number);
        Supervisor.addBuyer();
    }

    static final Object MONITOR=new Object();
    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        Supervisor.COUNTS_OF_GOODS= Helper.getRandomGoods();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
        Supervisor.BUYER_IN_THE_SHOP--;
    }

    @Override
    public void enterToMarket() {
        System.out.printf("%s enter to market\n",this);
    }

    @Override
    public void chooseGoods() {
        System.out.printf("%s starting choose\n",this);
//        Supervisor.COUNTS_OF_GOODS=Helper.getRandomGoods();
        int timeout= Supervisor.COUNTS_OF_GOODS * Helper.getRandom(500,2000);
        Helper.sleep(timeout);
        System.out.printf("%s want %d good\n",this, Supervisor.COUNTS_OF_GOODS);
    }

    @Override
    public void goOut() {
        System.out.printf("%s buyer go out\n",this);
        Supervisor.deleteBuyer();
    }

    @Override
    public void goToQueue(){
        synchronized (this) {
            QueueBuyers.add(this);
            try {
                System.out.println(this+" add to queue");
                wait();
                QueueCashiers.get().notify();
                System.out.println(this+" leave the queue");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.printf("%s buyer get basket\n",this);
    }

    @Override
    public void putGoodsToBasket() {
        System.out.printf("%s put %d goods to basket\n",this, Supervisor.COUNTS_OF_GOODS);
        synchronized (Basket.temp){
        Basket.putToBasket(Supervisor.COUNTS_OF_GOODS);
        System.out.println(Basket.temp);
        System.out.printf("Total purchase value : %3d$\n", Basket.costOfGoods);}
        System.out.printf("%s finished choose\n",this);
    }
}
