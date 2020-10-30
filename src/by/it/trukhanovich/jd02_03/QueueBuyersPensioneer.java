package by.it.trukhanovich.jd02_03;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyersPensioneer {
    private QueueBuyersPensioneer() {
    }
    private final static BlockingDeque<Buyer> QUEUE_BUYERS_PENSIONEER =new LinkedBlockingDeque<>(30);

        static void addPensioneer (Buyer buyer) {
            try {
                QUEUE_BUYERS_PENSIONEER.putLast(buyer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    static Buyer extractPensioneer () {
            return QUEUE_BUYERS_PENSIONEER.pollFirst();
    }

    public static int getSizeQUEUE_BUYERS_PENSIONEER() {
        return QUEUE_BUYERS_PENSIONEER.size();
    }
}
