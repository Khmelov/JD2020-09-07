package by.it.mialeshka.jd02_02;

class Dispatcher {
    static final Object MONITOR = new Object();
    static final Object MONITOR1 = new Object();
    static final Object MONITOR2 = new Object();
    static final int K_SPEED = 10;
    static final double K_SPEED_PENSIONNER = 1.5;
    static final int PLAN = 100;
    static final int PLAN_CASHIER = 5;
    static volatile int IN_COUNT = 0;
    static volatile int OUT_COUNT = 0;
    static volatile int WORK_CASHIER = 0;
    static volatile double TOTAL_SUMM = 0.0;

    static void cashierStart() {
        synchronized (MONITOR1) {
            WORK_CASHIER++;
        }
    }

    static void addPrice(double price) {
        synchronized (MONITOR2) {
            TOTAL_SUMM = TOTAL_SUMM + price;
        }
    }

    static void cashierStop() {
        synchronized (MONITOR1) {
            WORK_CASHIER--;
        }
    }

    static int getWorkCashier() {
        return WORK_CASHIER;
    }

    static boolean shopOpened() {
        return IN_COUNT < PLAN;
    }

    static boolean planComplate() {
        return OUT_COUNT == PLAN;
    }

    static boolean startWorkShop() {
        return IN_COUNT == 0;
    }

    static void buyerAddToShop() {
        synchronized (MONITOR) {
            IN_COUNT++;
        }
    }

    static void buyerLeaveShop() {
        synchronized (MONITOR) {
            OUT_COUNT++;
        }
    }
}
