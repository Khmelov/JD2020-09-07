package by.it.yatsevich.jd02_01;

class Buyer extends Thread implements IBayer, IUseBasket {

    private static boolean pensioner = false;

    public Buyer(int number) {
        super("Bayer №" + number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
        Supervisor.BUYER_IN_THE_SHOP--;
    }


    @Override
    public void enterToMarket() {
        System.out.printf("%s enter to market\n", this);
    }

    @Override
    public void chooseGoods() {

        Supervisor.COUNTS = Helper.getRandom(1, 4);
        if (Supervisor.BUYER_IN_THE_SHOP % 4 == 0) pensioner = true;
        int timeout;
        if (!pensioner) {
            System.out.printf("%s PENSIONER starting choose\n", this);
            timeout = Supervisor.COUNTS * Helper.getRandom((int) (500 * 1.5), (int) (2000 * 1.5));
        } else {
            System.out.printf("%s starting choose\n", this);
            timeout = Supervisor.COUNTS * Helper.getRandom(500, 2000);
        }
        Helper.buyerSleep(timeout);

        System.out.printf("%s chose %d good\n", this,Supervisor.COUNTS);

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
        System.out.printf("%s put %d goods to basket\n", this, Supervisor.COUNTS);
        Basket.putToBasket(Supervisor.COUNTS);
        System.out.println(Basket.temp);
        System.out.printf("Total purchase value : %3d$\n", Basket.costOfGoods);
        System.out.printf("%s finished choose\n", this);
    }
}
