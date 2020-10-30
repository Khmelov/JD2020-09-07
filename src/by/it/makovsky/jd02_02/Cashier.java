package by.it.makovsky.jd02_02;

public class Cashier implements Runnable {

    private String name;

    Cashier(int number) {
        name = "\tКассир №" + number;
    }

    @Override
    public void run() {

        System.out.println(this+" открылся");

        while (!Dispatcher.marketIsClosed()) {
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
