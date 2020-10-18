package by.it.yatsevich.jd02_01;

class Buyer extends Thread implements IBayer, IUseBasket {

    public Buyer(int number) {
        super("Bayer №" + number);


    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        Supervisor.COUNTS_OF_GOODS = Helper.getRandom(1, 4);
        chooseGoods();
        putGoodsToBasket();
        goOut();
        Supervisor.COUNTS_OF_BUYERS--;
        Supervisor.BUYER_IN_THE_SHOP--;
    }

    @Override
    public void enterToMarket() {
        System.out.printf("%s enter to market\n", this);
    }

    @Override
    public void chooseGoods() {
        if (Supervisor.BUYER_IN_THE_SHOP % 4 == 0) Helper.pensioner = true;
        int timeout;
        if (Helper.pensioner==true) {
            System.out.printf("%s PENSIONER starting choose\n", this);
            timeout = Supervisor.COUNTS_OF_GOODS *
                    Helper.getRandom((int) (Helper.start * Helper.pensionValue), (int) (Helper.stop * Helper.pensionValue));
        } else {
            System.out.printf("%s starting choose\n", this);
            timeout = Supervisor.COUNTS_OF_GOODS * Helper.getRandom(Helper.start, Helper.stop);
        }
        Helper.buyerSleep(timeout);

        System.out.printf("%s wonna %d good\n", this, Supervisor.COUNTS_OF_GOODS);

    }

    @Override
    public void goOut() {
        System.out.printf("%s buyer go out\n", this);
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
        Basket.putToBasket(Supervisor.COUNTS_OF_GOODS);
        System.out.println(Basket.temp);
        System.out.printf("Total purchase value : %3d$\n", Basket.costOfGoods);
        System.out.printf("%s finished choose\n", this);
    }
}
