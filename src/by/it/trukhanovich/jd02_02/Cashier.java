package by.it.trukhanovich.jd02_02;

import java.util.List;
import java.util.Map;

public class Cashier implements Runnable{

    private String name;

    private boolean isWait;

    public void setWait(boolean wait) {
        isWait = wait;
    }

    public Cashier(int number) {
        name="\tCashier №"+number;
        isWait=false;
    }

    @Override
    public void run() {
        System.out.printf("%s opened\n", this);
            while (!Dispatcher.marketIsClosed()){
                Buyer buyer = QueueBuyers.extract();
                if (buyer!=null) {
                    StringBuilder coutnThread= new StringBuilder();
                    coutnThread.append("\t\t\t\t\t\t\t\t\t\t\t\tРаботало кассиров "
                            +Market.cashiers.activeCount()+". Размер очереди "
                            +QueueBuyers.getSizeQUEUE_BUYERS());
                    System.out.println(coutnThread);
                    System.out.printf("%s started to sevice %s\n", this, buyer);
                    checkBasket(buyer);
                    System.out.printf("%s finished to sevice %s\n", this, buyer);
                    synchronized (buyer){
                        buyer.setWait(false);
                        buyer.notify();
                    }
                    Helper.mySleep(Helper.getRandom(2000,5000));
                    goToQueueCashier();
                }
                //TODO
                else goToQueueCashier();

            }
        System.out.printf("%s closed\n", this);
    }

    private void checkBasket(Buyer buyer) {
        List<Map.Entry<String, Integer>> goodsInBasket = buyer.getGoodsInBasket();
        int sumInCheck=0;
        StringBuilder check= new StringBuilder();
        check.append("Check for " + buyer.getName() +"\n");
        for (Map.Entry<String, Integer> good : goodsInBasket) {
            sumInCheck+=good.getValue();
            check.append(good.getKey()+": "+good.getValue()+"\n");
        }
        check.append("Total: "+sumInCheck+"\n");
        System.out.printf("%s",check);
    }

    public void goToQueueCashier() {
//        System.out.printf("%s go to queue\n", this);
        synchronized (this){
            QueueCashier.add(this);
            isWait=true;
            while (isWait){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
