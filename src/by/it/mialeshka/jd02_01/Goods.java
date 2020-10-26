package by.it.mialeshka.jd02_01;

import java.util.*;

public class Goods {
    static final Map<String, Double> goodList = new HashMap<>();
    {
        goodList.put("Bread", 1.12);
        goodList.put("Milk", 3.1);
        goodList.put("Eggs", 2.28);
        goodList.put("Meat", 12.9);
        goodList.put("Cookies", 7.0);
    }

    public String getRandomGood(){
        List<String> listKeys = new ArrayList<>(goodList.keySet());
        int index = Helper.getRandom(0, goodList.size()-1);
        return   listKeys.get(index) + " cost " + goodList.get(listKeys.get(index));
    }

}
