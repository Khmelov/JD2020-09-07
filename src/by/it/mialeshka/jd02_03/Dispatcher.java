package by.it.mialeshka.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class Dispatcher {
    static final int K_SPEED = 10;
    static final double K_SPEED_PENSIONNER = 1.5;
    static final int PLAN = 100;
    static final int PLAN_CASHIER = 5;
    static AtomicInteger IN_COUNT = new AtomicInteger(0);
    static AtomicInteger OUT_COUNT = new AtomicInteger(0);
    static AtomicInteger WORK_CASHIER = new AtomicInteger(0);
    static AtomicReference<Double> TOTAL_SUMM = new AtomicReference<>(0.0);

    static void cashierStart() {
            WORK_CASHIER.incrementAndGet();
    }

    static void addPrice(double price) {
        TOTAL_SUMM.set(TOTAL_SUMM.get() + price);
    }

    static void cashierStop() {
            WORK_CASHIER.decrementAndGet();
    }

    static int getWorkCashier() {
        return WORK_CASHIER.get();
    }

    static boolean shopOpened() {
        return IN_COUNT.get() < PLAN;
    }

    static boolean planComplate() {
        return OUT_COUNT.get() == PLAN;
    }

    static boolean startWorkShop() {
        return IN_COUNT.get() == 0;
    }

    static void buyerAddToShop() {
            IN_COUNT.incrementAndGet();
    }

    static void buyerLeaveShop() {
            OUT_COUNT.incrementAndGet();
    }
}
