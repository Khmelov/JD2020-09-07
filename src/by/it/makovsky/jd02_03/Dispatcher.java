package by.it.makovsky.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    private final int totalBuyersCount;

    public Dispatcher(int totalBuyersCount) {
        this.totalBuyersCount = totalBuyersCount;
    }

    private final AtomicInteger countEntersMarket = new AtomicInteger(0);
    private final AtomicInteger countLeavesMarket = new AtomicInteger(0);

    void buyerEntersMarket() {
        countEntersMarket.getAndIncrement();
    }

    void buyerLeavesMarket() {
        countLeavesMarket.getAndIncrement();
    }

    boolean marketIsOpenedForBuyers(){
        return countEntersMarket.get()!= totalBuyersCount;
    }

    boolean marketIsClosed(){
        return countLeavesMarket.get()== totalBuyersCount;
    }



}
