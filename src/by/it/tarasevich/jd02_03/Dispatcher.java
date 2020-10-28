package by.it.tarasevich.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {
    private final AtomicInteger countEnterMarket = new AtomicInteger(0);
    private final AtomicInteger countOutFromMarket = new AtomicInteger(0);
    private final int totalBuyerCount;

    public Dispatcher( int totalBuyerCount) {
        this.totalBuyerCount = totalBuyerCount;
    }

     void buyerEnterToMarket() {
        countEnterMarket.getAndIncrement();
    }
     void buyerOutToMarket() {
        countOutFromMarket.getAndIncrement();
    }

       boolean marketIsOpenForNewBuyer(){return countEnterMarket.get()!= totalBuyerCount ;}

     boolean marketIsCloused(){return countOutFromMarket.get()==totalBuyerCount;}
}
