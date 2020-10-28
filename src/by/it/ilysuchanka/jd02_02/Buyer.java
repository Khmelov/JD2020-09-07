package by.it.ilysuchanka.jd02_02;

import java.util.Map;

class Buyer extends Thread implements IUseBasket {

    Buyer(int number) {
        super("Buyer №"+number);
        isWait = false;
        Dispatcher.buyerEnterToMarket();
    }

    private boolean isWait;

    public boolean isWait() {
        return isWait;
    }

    public void setWait(boolean wait) {
        isWait = wait;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
        Dispatcher.buyerLeaveMarket();
    }

    @Override
    public void enterToMarket() {
        System.out.printf("%s enter to market \n",this);
    }

    @Override
    public void takeBasket() {
        int timeout = Helper.getRandom(500, 2000);
        Helper.mySleep(timeout);
        System.out.printf("%s took basket\n", this);
    }

    @Override
    public void chooseGoods() {
        System.out.printf("%s started to choose \n",this);
        int timeout = Helper.getRandom(500, 2000);
        Helper.mySleep(timeout);
        System.out.printf("%s finished to choose \n",this);
    }

    @Override
    public void goToQueue() {
        System.out.printf("%s go to queue\n", this);
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
    public void putGoodsToBasket() {
        System.out.printf("%s started to put things into basket \n", this);
        int numberOfGoods = 0;
        int varietyOfGoods = Helper.getRandom(1, 4);
        for (Map.Entry<String, String> entry : Products.productList().entrySet()) {
            if(varietyOfGoods == numberOfGoods){
                break;
            }
            System.out.printf("%s put %s that costs %s into his basket\n",
                    this,
                    entry.getKey(),
                    entry.getValue());
            numberOfGoods++;
        }
        Helper.mySleep(Helper.getRandom(500, 2000));
        System.out.printf("%s finished putting goods into basket\n", this);
    }

    @Override
    public void goOut() {
        System.out.printf("%s left market \n",this);

    }

    @Override
    public String toString() {
        return this.getName();
    }
}
