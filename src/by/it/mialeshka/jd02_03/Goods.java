package by.it.mialeshka.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Goods {
    static final Map<String, Double> goodList = new HashMap<>();
    {
        goodList.put("Bread", 1.12);
        goodList.put("Milk", 3.1);
        goodList.put("Eggs", 2.28);
        goodList.put("Meat", 12.9);
        goodList.put("Cookies", 7.0);
    }

    public void addRandomGood(Map<String, Double> clGoods){
        List<String> listKeys = new ArrayList<>(goodList.keySet());
        int index = Helper.getRandom(0, goodList.size()-1);
        clGoods.put(listKeys.get(index), goodList.get(listKeys.get(index)));
    }

}
