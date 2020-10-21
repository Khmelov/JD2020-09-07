package by.it.kalashnikov.jd02_03;

class Cashier implements Runnable {
    private final String name;

    private final Dispatcher dispatcher;

    Cashier(int number, Dispatcher dispatcher) {
        name = "\tCashier №" + number;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {

        System.out.printf("%s opened\n", this);
        System.out.flush();

        while (!dispatcher.marketIsClosed()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.printf("%s started to service %s\n", this, buyer);
                Helper.mySleep(Helper.getRandom(2000, 5000));
                System.out.printf("%s finished to service %s\n", this, buyer);
                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (buyer){
                    buyer.setWait(false);
                    buyer.notifyAll();
                }
            }
            else{
                //???????
                Helper.mySleep(1);
            }
        }

        System.out.printf("%s closed\n", this);


    }

    @Override
    public String toString() {
        return name;
    }
}
