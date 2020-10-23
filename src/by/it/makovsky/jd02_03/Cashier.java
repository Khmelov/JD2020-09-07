package by.it.makovsky.jd02_03;

public class Cashier implements Runnable {

    private String name;
    private final Dispatcher dispatcher;

    Cashier(int number, Dispatcher dispatcher) {
        name = "\tКассир №" + number;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {

        System.out.println(this+" открылся");

        while (!dispatcher.marketIsClosed()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.printf("%s начал обслуживать %s\n", this, buyer);
                Rnd.mySleep(Rnd.fromTo(2000, 5000));
                System.out.printf("%s закончил обслуживать %s\n", this, buyer);
                synchronized (buyer){
                    buyer.setWait(false);
                    buyer.notifyAll();
                }
            }
            else{
                Rnd.mySleep(1);
            }
        }

        System.out.printf("%s закрылся\n", this);


    }

    @Override
    public String toString() {
        return name;
    }
}
