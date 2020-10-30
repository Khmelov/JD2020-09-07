package by.it.makovsky.jd02_01;



public class Buyer extends Thread implements IBuyer, IUseBasket{
    public Buyer(int number) {
        super("Покупатель №"+number);
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
        System.out.println(this+" вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" начал выбирать товар");
            int pause=Rnd.fromTo(500,2000);
            Rnd.mySleep(pause);
        System.out.println(this+" выбрал товар:");
        Basket.addGoods();
    }

    @Override
    public void goOut() {
        System.out.println(this+ " выбежал с корзиной из магазина");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        int pause=Rnd.fromTo(500,2000);
        Rnd.mySleep(pause);
        System.out.println(this+ " взял корзину");
    }

    @Override
    public void putGoodsToBasket() {
        int pause=Rnd.fromTo(500,2000);
        Rnd.mySleep(pause);
        System.out.println(this+ " положил выбранный товар в корзину");
    }
}
