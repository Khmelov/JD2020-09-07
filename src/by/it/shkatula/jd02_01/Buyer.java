package by.it.shkatula.jd02_01;

import java.util.Map;

public class Buyer extends Thread implements IUseBasket {
    public Buyer(int number) {
        super("Buyer " + number);
    }

    @Override
    public void run() {
        enterStore();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        leaveStore();
        Dispatcher.BUYERS_IN_SHOP--;
    }

    @Override
    public void enterStore() {
        System.out.printf("%s entered the store\n", this);
    }

    @Override
    public void chooseGoods() {
        System.out.printf("%s started to choose the goods\n", this);
        Helper.mySleep(Helper.getRandom(500, 2000));
        System.out.printf("%s finished choosing the goods\n", this);
    }

    @Override
    public void leaveStore() {
        System.out.printf("%s leave the store\n", this);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        Helper.mySleep(Helper.getRandom(500, 2000));
        System.out.printf("%s take basket\n", this);
    }

    @Override
    public void putGoodsToBasket() {
        System.out.printf("%s started to put goods to the basket\n", this);
        int count = 0;
        int amountOfGoods = Helper.getRandom(1, 4);
        for (Map.Entry<String, String> entry : products.entrySet()) {
            if (count == amountOfGoods) {
                break;
            }
            System.out.printf("%s put %s with price %s to his basket\n", this, entry.getValue(), entry.getKey());
            count++;
        }

        Helper.mySleep(Helper.getRandom(500, 2000));
        System.out.printf("%s finished putting goods to the basket\n", this);
    }
}
