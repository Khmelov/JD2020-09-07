package by.it.stefankin.jd02_02;

import by.it.stefankin.jd02_01.Goods;

import java.util.HashMap;

class Buyer extends Thread implements IBuyer, IUseBasket {

    Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.buyerEnterToMarket();
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
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
        Dispatcher.buyerLeaveMarket();
    }

    @Override
    public void enterToMarket() {

        System.out.printf("%s has entered to market", this);
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

    @Override
    public void takeBasket() {
        Helper.mySleep(Helper.getRandom(500,2000));
        System.out.println("I've took the BASKET");
    }

    @Override
    public void putGoodsToBasket() {
        int quont = Helper.getRandom(4);
        HashMap<String, Integer> gds = new HashMap<String, Integer>();
        int total=0;
        for (int i = 0; i <= quont; i++) {
            int pos= Helper.getRandom(6);
            gds.put(Goods.goods[pos],Goods.prices[pos]);
            total=total+Goods.prices[pos].intValue();
        }
        Helper.mySleep(Helper.getRandom(500,2000));
        System.out.println(gds);
        System.out.println("Сумма чека ="+total);

    }
}
