package by.it.trukhanovich.jd02_02;

public class Cashier implements Runnable{

    private String name;



    public Cashier(int number) {
        name="\tCashier №"+number;
    }

    @Override
    public void run() {
        System.out.printf("%s opened\n", this);
            while (!Dispatcher.marketIsClosed()){
                Buyer buyer = QueueBuyers.extract();
                if (buyer!=null) {
                    System.out.printf("%s started to sevice %s\n", this, buyer);
                    System.out.printf("%s finished to sevice %s\n", this, buyer);
                    synchronized (buyer){
                        buyer.setWait(false);
                        buyer.notify();
                    }
                    Helper.mySleep(Helper.getRandom(2000,5000));

                }
                //TODO
                else Helper.mySleep(1);
            }
        System.out.printf("%s closed\n", this);
    }


    @Override
    public String toString() {
        return name;
    }
}
