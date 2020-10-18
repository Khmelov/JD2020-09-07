package by.it.makovsky.jd02_01;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Магазин открыт");
        ArrayList<Buyer> buyers = new ArrayList<>();
        int number = 0;
        for (int timeSecond = 1; timeSecond <= 120; timeSecond++) {
            int countBuyer = Rnd.getRandom(2);
            for (int i = 0; i < countBuyer; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                buyers.add(buyer);
                Dispatcher.BUYERS_IN_SHOP++;
            }
            Rnd.mySleep(1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Магазин закрыт");
    }
}
