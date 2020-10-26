package by.it.mialeshka.jd02_02;

import java.util.HashMap;
import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBasket {
    public final boolean pensioneer;
    public final Map<String, Double> goods = new HashMap<>();


    public Buyer(int number, boolean isPensioneer) {
        super("Buyer №" + number + (isPensioneer?" pensioneer":""));
        pensioneer = isPensioneer;
        Dispatcher.buyerAddToShop();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to shop");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " start to choose goods");
        int countGoods = Helper.getRandom(1, 4);
        for (int i = 0; i < countGoods; i++) {
            putGoodsToBasket();
        }
        System.out.println(this + " finish to choose goods");
    }

    @Override
    public void goToQueue() {
        synchronized (this){
            QueueBuyers.add(this);
            try {
                System.out.println(this + " added to queue");
                wait();
                System.out.println(this + " leave to queue");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void goOut() {
        Dispatcher.buyerLeaveShop();
        System.out.println(this + " exit shop");
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void takeBasket() {
        System.out.println(this + " took a basket");
    }

    @Override
    public void putGoodsToBasket() {
        int timeout = Helper.getRandom(500, 2000);
        if (pensioneer) timeout = (int) Math.ceil(timeout * Dispatcher.K_SPEED_PENSIONNER);
        (new Goods()).addRandomGood(goods);
        Helper.sleep(timeout);
    }

}
