package by.it.mialeshka.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBasket{
    private final boolean pensioneer;

    public Buyer(int number, boolean isPensioneer) {
        super("Buyer №" + number + (isPensioneer?" pensioneer":""));
        pensioneer = isPensioneer;
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
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
    public void goOut() {
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
        if (pensioneer) timeout = (int) Math.ceil(timeout * Manager.K_SPEED_PENSIONNER);
        Helper.sleep(timeout);
        System.out.println(this + " put in the basket " + (new Goods()).getRandomGood());
    }
}
