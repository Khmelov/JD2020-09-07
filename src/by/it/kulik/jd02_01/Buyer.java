package by.it.kulik.jd02_01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
        Map<String, Integer> basket = new HashMap<>();
        basket.put("milk", 1);
        basket.put("bread", 2);
        basket.put("meat", 3);
        basket.put("chocolate", 4);
        Set<String >keys=basket.keySet();
        Iterator<String> iterator=keys.iterator();
        while (iterator.hasNext()){
            String s= iterator.next();
            System.out.printf("%s put %s in basket\n",this,s);
        }
    }
}


