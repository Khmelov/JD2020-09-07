package by.it.trukhanovich.jd02_01;

import java.util.HashMap;

class MarketHelper {
    static HashMap<String,Integer> priceGood=new HashMap<>();

    void getGoodToPrice (){
        priceGood.put("Bread", 1);
        priceGood.put("Milk", 2);
        priceGood.put("Eggs", 3);
        priceGood.put("Sugar", 4);

    }

    public MarketHelper() {
        System.out.println("Market have price");
    }

}
