package by.it.trukhanovich.jd02_03;

import java.util.List;
import java.util.Map;

public class Cashier implements Runnable{

    private final String name;

    private final Dispatcher dispatcher;

    private final int number;

    private boolean isWait;

    public void setWait(boolean wait) {
        isWait = wait;
    }

    public Cashier(int number, Dispatcher dispatcher) {
        name="\tCashier №"+number;
        this.number=number;
        this.dispatcher = dispatcher;
        isWait=false;
    }

    @Override
    public void run() {
        System.out.printf("%s opened\n", this);
            while (!dispatcher.marketIsClosed()){
                Buyer buyer;
                if (QueueBuyersPensioneer.getSizeQUEUE_BUYERS_PENSIONEER()!=0){
                    buyer= QueueBuyersPensioneer.extractPensioneer();
                }
                else buyer = QueueBuyers.extract();
                Manager.cashiersTurnOn();
                if (buyer!=null) {
                    System.out.printf("%s started to sevice %s\n", this, buyer);
                    checkBasket(buyer);
                    System.out.printf("%s finished to sevice %s\n", this, buyer);
                    //noinspection SynchronizationOnLocalVariableOrMethodParameter
                    synchronized (buyer){
                        buyer.setWait(false);
                        buyer.notify();
                    }
                    Helper.mySleep(Helper.getRandom(2000,5000));
                    goToQueueCashier();
                }
                else goToQueueCashier();

            }
        System.out.printf("%s closed\n", this);
    }

    private void checkBasket(Buyer buyer) {
        List<Map.Entry<String, Integer>> goodsInBasket = buyer.getGoodsInBasket();
        int sumInCheck=0;
        StringBuilder check= new StringBuilder();
        check.append("Check for ").append(buyer.getName()).append("\n");
        check.append("Cashier №1      ")
                .append("Cashier №2      ")
                .append("Cashier №3      ")
                .append("Cashier №4      ")
                .append("Cashier №5      ")
                .append("Queue size      ")
                .append("Total           \n");
        for (Map.Entry<String, Integer> good : goodsInBasket) {
            for (int i = 1; i <number; i++) {
                check.append("\t\t\t\t");
            }
            sumInCheck+=good.getValue();
            check.append(good.getKey()).append(": ").append(good.getValue()).append("\n");
        }
        for (int i = 1; i <number; i++) {
            check.append("\t\t\t\t");
        }
        check.append("Sum: ").append(sumInCheck).append("\n");

        MarketHelper.setSumForMarket(sumInCheck);

        for (int i = 1; i <6; i++) {
            check.append("\t\t\t\t");
        }
        check.append(QueueBuyers.getSizeQUEUE_BUYERS());
        if (QueueBuyers.getSizeQUEUE_BUYERS()<10) check.append("       \t\t");
        if (QueueBuyers.getSizeQUEUE_BUYERS()>10) check.append("      \t\t");
        check.append(MarketHelper.getSumForMarket()).append("\n");
        System.out.printf("%s",check);
    }

    public void goToQueueCashier() {
        synchronized (this){
            QueueCashier.add(this);
            isWait=true;
            Manager.cashiersTurnOff();
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
