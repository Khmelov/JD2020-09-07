package by.it.yatsevich.jd02_02;


public class Cashier implements Runnable {

    static final Object MONITOR=new Object();

    private final String name;

    Cashier(int number) {
        name = "Cashier № " + number + ": ";
    }

    @Override
    public void run() {
        System.out.println(this + " worked");
        while (!Supervisor.planComplete()) {
            Buyer getBuyer = QueueBuyers.get();
            if (getBuyer != null) {
                System.out.println(this + " open");
                System.out.println(this + " start service" + getBuyer);
                int timer = Helper.getRandom(2000, 5000);
                Helper.sleep(timer);
                synchronized (getBuyer) {
                    getBuyer.notify();
                getUp();
                }

                System.out.println(this + " finished service" + getBuyer);
            } else {

                System.out.println(this + " close");
//                Helper.sleep(100);
                sleeper();
            }
        }

        System.out.println(this + " finish work");
    }

    private void sleeper() {
        synchronized (this) {
            QueueCashiers.add(this);
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void getUp() {
        int counter = QueueBuyers.getLength();
        if (counter >= 21) notifyAll();
        if (counter < 21 && counter >= 16) {
            for (int i = 1; i <= 4; i++) {
                this.notify();
            }
        }
        if (counter < 16 && counter >= 11) {
            for (int i = 1; i <= 3; i++) {
                this.notify();
            }
        }
        if (counter < 11 && counter >= 6) {
            for (int i = 1; i <= 2; i++) {
                this.notify();
            }
        }
        if (counter <= 5) this.notify();

    }

    @Override
    public String toString() {
        return name;
    }
}

