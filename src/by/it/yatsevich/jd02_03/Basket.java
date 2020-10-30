package by.it.yatsevich.jd02_03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

class Basket {
    private static final HashMap<String, Integer> goodsList = new HashMap<>();
    static {
        goodsList.put("Good #1", 1);
        goodsList.put("Good #2", 3);
        goodsList.put("Good #3", 5);
        goodsList.put("Good #4", 10);
    }

    static final HashMap<String,Integer> temp = new HashMap<>();
    static AtomicInteger costOfGoods=new AtomicInteger(0);
    static AtomicInteger GLOBAL_SUM=new AtomicInteger(0);

    static synchronized void putToBasket(int countsOfGoods) {
        Set<Map.Entry<String, Integer>> entries = goodsList.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        int counts;
//        if (countsOfGoods == 4) counts = 0;
//        else if (countsOfGoods == 3) counts = 1;
//        else if (countsOfGoods == 2) counts = 2;
//        else counts = 3;
        int sum=0;
        for (int i = 0; i < countsOfGoods; i++) {
            if (iterator.hasNext()) {
                Map.Entry<String, Integer> next = iterator.next();
                temp.put(next.getKey(),next.getValue());
                sum+=next.getValue();
            }
        }
        costOfGoods.getAndSet(sum);
        GLOBAL_SUM.addAndGet(costOfGoods.get());
    }
}

