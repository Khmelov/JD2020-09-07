package by.it.makovsky.jd02_03;

import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private final Dispatcher dispatcher;

    public Buyer(int number, Dispatcher dispatcher) {
        super("Покупатель №"+number);
        this.dispatcher=dispatcher;
        dispatcher.buyerEntersMarket();
        isWait = false;
    }
    private boolean isWait;

    public boolean isWait() {
        return isWait;
    }

    public void setWait(boolean wait) {
        isWait = wait;
    }
    private final Semaphore semaphore =new Semaphore(20);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            enterToMarket();
            takeBasket();
            chooseGoods();
            putGoodsToBasket();
            goToQue();
            goOut();
            dispatcher.buyerLeavesMarket();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    private void goToQue() {
        System.out.println(this+" становится в очередь");
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
    public void enterToMarket() {
        System.out.println(this+" вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" начал выбирать товар");
            int pause= Rnd.fromTo(500,2000);
            Rnd.mySleep(pause);
        System.out.println(this+" выбрал товар: "+ Basket.addGoods());

    }

    @Override
    public void goOut() {
        System.out.println(this+ " вышел из магазина");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        int pause= Rnd.fromTo(500,2000);
        Rnd.mySleep(pause);
        System.out.println(this+ " взял корзину");
    }

    @Override
    public void putGoodsToBasket() {
        int pause= Rnd.fromTo(500,2000);
        Rnd.mySleep(pause);
        System.out.println(this+ " положил выбранный товар в корзину");
    }
}
