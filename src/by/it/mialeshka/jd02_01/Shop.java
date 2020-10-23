package by.it.mialeshka.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    static List<Buyer> buyers = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Shop opened");
        int isP = 0;
        int nBuyer = 0;
        int minuteCount = 1;
        do {
            for (int i = 1; i <= 60; i++) {
                int count = getCountBuyers(i);
                for (int j = 1; j <= count; j++) {
                    isP++;
                    Buyer byer;
                    if (isP % 4 == 0) byer = new Buyer(++nBuyer, true);
                    else byer = new Buyer(++nBuyer, false);
                    byer.start();
                    buyers.add(byer);
                }
                Helper.sleep(1000);
            }
            minuteCount++;
        } while (minuteCount < 3);

        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Shop closed");
    }

    private static int getCountBuyers(int time) {
        int res;
            int countActive = 0;
            for (Buyer buyer : buyers) {
                if (buyer.isAlive()) countActive++;
            }

            if (time == 1)
                return 10;

            if (time < 30) {
                    return time+10-countActive;
            }
            else{
                return  40+30-time - countActive;
            }
    }
}
