package by.it.yatsevich.jd02_02;

import java.util.HashMap;
import java.util.Iterator;

class Basket {
    static HashMap<String,Integer> temp = new HashMap<>();
    static int costOfGoods;

    public static void putToBasket(int countsOfGoods) {
        temp.putAll(Good.goodsList);
        Iterator<String> iterator = temp.keySet().iterator();
        int counts;
        if (countsOfGoods==4)counts=0;
        else if (countsOfGoods==3)counts=1;
        else if (countsOfGoods==2)counts=2;
        else counts=3;
        for (int i = 0; i < counts; i++) {
            if (iterator.hasNext()){
                iterator.next();
                iterator.remove();
            }
        }
        int sum=0;
        for (Integer value : temp.values()) {
            sum+=value;
        }
        costOfGoods=sum;
        //        System.out.println(temp);
    }
}

