package by.it.tarasevich.jd02_01;

public class Buyer extends Thread implements IBuyer {
    public Buyer(int number) {
        super("Buyer №" + number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseSomfing();
        goOut();
        Dispatcher.BUYERS_IN_SHOP--;
    }

    @Override
    public void enterToMarket() {
        System.out.printf("%s enter market\n",this);
    }

    @Override
    public void chooseSomfing() {
        System.out.printf("%s sterted to choose\n",this);
        int timeout = Helper.getRandom(500,2000);
        Helper.mySleep(timeout);
        System.out.printf("%s finished to choose\n",this);
    }

    @Override
    public void goOut() {
        System.out.printf("%s leaved market\n",this);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
