package by.it.yatsevich.jd02_02;

import java.util.*;

class Basket {
    static final HashMap<String,Integer> temp = new HashMap<>();
    static volatile int costOfGoods;
    static volatile int GLOBAL_SUM=0;

    static synchronized void putToBasket(int countsOfGoods) {
        temp.putAll(Good.goodsList);
        Iterator<Integer> iterator = temp.values().iterator();
        int counts;
        if (countsOfGoods == 4) counts = 0;
        else if (countsOfGoods == 3) counts = 1;
        else if (countsOfGoods == 2) counts = 2;
        else counts = 3;
        int sum=0;
        for (int i = 0; i < counts; i++) {
            if (iterator.hasNext()) {
                Integer val = iterator.next();
                sum+=val;
            }
        }
        costOfGoods=sum;
        GLOBAL_SUM = GLOBAL_SUM + costOfGoods;
    }
}

