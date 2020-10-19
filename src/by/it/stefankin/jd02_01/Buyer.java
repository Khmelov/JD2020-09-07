package by.it.stefankin.jd02_01;


import java.util.HashMap;

class Buyer extends Thread implements IBuyer, by.it.stefankin.jd02_01.IUseBasket {

    public Buyer(int number) {

        super("Buyer №"+number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
        Dispatcher.BUYERS_IN_SHOP--;
    }

    @Override
    public void enterToMarket() {

        System.out.printf("%s enter to market",this);
    }

    @Override
    public void chooseGoods() {
        System.out.printf("%s started to choose\n",this);
        int timeout = Helper.getRandom(500, 2000);
        Helper.mySleep(timeout);
        System.out.printf("%s finished to choose\n",this);
    }

    @Override
    public void goOut() {
        System.out.printf("%s has left the market\n",this);

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
        for (int i = 0; i <= quont; i++) {
          int pos=Helper.getRandom(6);
          gds.put(Goods.goods[pos],Goods.prices[pos]);
        }
        Helper.mySleep(Helper.getRandom(500,2000));
        System.out.println(gds);
    }
}
