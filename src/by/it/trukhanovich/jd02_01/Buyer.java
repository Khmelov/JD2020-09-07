package by.it.trukhanovich.jd02_01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    public Buyer(int number) {
        super("Buyer №"+number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        int numberOfGoods=Helper.getRandom(1,4);
        for (int i = 1; i <= numberOfGoods; i++) {
            chooseGoods();
            putGoodsToBasket();
        }
        goOut();
        Dispatcher.BUYERS_IN_SHOP--;
    }

    @Override
    public void enterToMarket() {
        System.out.printf("%s enter to market\n",this);
    }

    @Override
    public void chooseGoods() {
        System.out.printf("%s started to choose\n",this);
        int goodInPrice=MarketHelper.priceGood.size();
        int numberGood=Helper.getRandom(1,goodInPrice);
        if(numberGood==1) {
            System.out.printf("%s take Bread for a price %d$\n",this, MarketHelper.priceGood.get("Bread"));
        }
        if(numberGood==2) {
            System.out.printf("%s take Milk for a price %d$\n",this, MarketHelper.priceGood.get("Milk"));
        }
        if(numberGood==3) {
            System.out.printf("%s take Eggs for a price %d$\n",this, MarketHelper.priceGood.get("Eggs"));
        }
        if(numberGood==4) {
            System.out.printf("%s take Sugar for a price %d$\n",this, MarketHelper.priceGood.get("Sugar"));
        }
        int timeout=Helper.getRandom(500,2000);
        Helper.mySleep(timeout);
        System.out.printf("%s finished to choose\n",this);
    }

    @Override
    public void goOut() {
        System.out.printf("%s left market\n",this);
    }

    @Override
    public void takeBasket() {
        System.out.printf("%s take basket\n",this);
        int timeout=Helper.getRandom(500,2000);
        Helper.mySleep(timeout);
    }

    @Override
    public void putGoodsToBasket() {
        System.out.printf("%s put good to basket\n",this);
        int timeout=Helper.getRandom(500,2000);
        Helper.mySleep(timeout);
    }

    @Override
    public String toString() {
        return (this.getName());
    }
}
