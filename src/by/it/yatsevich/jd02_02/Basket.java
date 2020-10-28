package by.it.yatsevich.jd02_02;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Basket {
    static final HashMap<String,Integer> temp = new HashMap<>();
    static volatile int costOfGoods;
    static volatile int GLOBAL_SUM=0;

    public static void putToBasket(int countsOfGoods) {
        temp.putAll(Good.goodsList);

//        Iterator<String> iterator = temp.keySet().iterator();
//        int counts;
//        if (countsOfGoods == 4) counts = 0;
//        else if (countsOfGoods == 3) counts = 1;
//        else if (countsOfGoods == 2) counts = 2;
//        else counts = 3;
//        for (int i = 0; i < counts; i++) {
//            if (iterator.hasNext()) {
//                iterator.next();
//                iterator.remove();
//            }
//        }
        getSum(countsOfGoods);

        //        System.out.println(temp);
    }
    static int getSum(int goods){
        int sum=0;
        for (int i = 0; i < goods; i++) {
        }
        costOfGoods=sum;
        GLOBAL_SUM+=costOfGoods;
        return sum;
    }
}

