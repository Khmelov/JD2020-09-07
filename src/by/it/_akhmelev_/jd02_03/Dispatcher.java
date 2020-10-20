package by.it._akhmelev_.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    private final int totalBuyersCount;

    public Dispatcher(int totalBuyersCount) {
        this.totalBuyersCount = totalBuyersCount;
    }

    private final AtomicInteger countEnterToMarket = new AtomicInteger(0);
    private final AtomicInteger countOutFromMarket = new AtomicInteger(0);

    void buyerEnterToMarket() {
        countEnterToMarket.getAndIncrement();
    }

    void buyerLeaveMarket() {
        countOutFromMarket.getAndIncrement();
    }

    boolean marketIsOpenedForNewBuyer(){
        return countEnterToMarket.get()!= totalBuyersCount;
    }

    boolean marketIsClosed(){
        return countOutFromMarket.get()== totalBuyersCount;
    }



}
