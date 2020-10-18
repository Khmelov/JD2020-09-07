package by.it.kulik.jd02_01;

import java.util.ArrayDeque;
import java.util.Queue;

public class runner {
    static int countBuyers=0;

    public static void main(String[] args) throws InterruptedException {
        Queue<Buyer> queue=new ArrayDeque<>();
        while (countBuyers<10){
            Thread.sleep(random.fromTo(500, 2000));
            int count=random.fromTo(0,2);
            for (int i = 0; i <=count; i++) {
                countBuyers++;
                if (countBuyers<11) {
                    Buyer buyer = new Buyer(countBuyers);
                    queue.add(buyer);
                }
            }
        }
    }
}
