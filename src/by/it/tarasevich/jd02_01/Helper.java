package by.it.tarasevich.jd02_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Helper {

    private static final Random random = new Random();
    static int getRandom(int start ,int stop) {
         return start+random.nextInt(stop-start + 1);
    }
    static int getRandom(int max){
        return getRandom(0,max);
    }
    static void mySleep(int millis){
        try {
            Thread.sleep(millis/Dispatcher.K_SPEED);
        }catch (InterruptedException e){
            throw new RuntimeException("something not good",e);
        }
    }
    private static final HashMap<String,Integer> priceGood=new HashMap<>();

    void getGoodToPrice (){
        priceGood.put("Mlechko", 1);
        priceGood.put("Hlebci", 2);
        priceGood.put("Jaiki", 3);
        priceGood.put("Cuker", 4);

    }

    static public Map.Entry<String, Integer> takeOneRandomGood(int number) {
        Set<Map.Entry<String, Integer>> entries = priceGood.entrySet();
        int numberInPrice=1;
        for (Map.Entry<String, Integer> entry : entries) {
            if (number==numberInPrice) {
                return entry;
            }
            numberInPrice++;
        }
        throw new RuntimeException();

    }

    public Helper() {
        System.out.println("Market have price");
    }

    public static int priceGoodSize (){
        return priceGood.size();
    }
}
