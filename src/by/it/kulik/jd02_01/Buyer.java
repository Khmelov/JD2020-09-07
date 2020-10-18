package by.it.kulik.jd02_01;

import java.util.HashMap;
import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBasket {

    public Buyer(int number) {
        super("Buyer №" + number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToTheBasket();
        goOut();
        Dispatcher.BUYERS_IN_SHOP--;
    }

    @Override
    public void enterToMarket() {
        System.out.printf("%s enter to market\n", this);
    }

    @Override
    public void chooseGoods() {
        System.out.printf("%s started to choose\n", this);
        int timeout = Helper.getRandom(500, 2000);
        Thread.yield();
        Helper.mySleep(timeout);
        System.out.printf("%s finished to choose\n", this);
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
        System.out.printf("%s took basket\n", this);
    }

    @Override
    public void putGoodsToTheBasket() {
        int goodsAmount = Helper.getRandom(0, 4);
        int count=0;
        Map<String, Integer> assort = new HashMap<>();
        assort.put("milk", 1);
        assort.put("bread", 2);
        assort.put("meat", 3);
        assort.put("chocolate", 4);
        for(Map.Entry<String,Integer>entry:assort.entrySet()) {
            if (count==goodsAmount)
                break;
            System.out.printf("%s put %s in basket\n",this,entry.getKey());
            count++;
        }
        Helper.mySleep(Helper.getRandom(500, 2000));
    }
}


