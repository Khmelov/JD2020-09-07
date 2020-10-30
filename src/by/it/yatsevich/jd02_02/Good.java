package by.it.yatsevich.jd02_02;

import java.util.HashMap;

class Good {
    static final HashMap<String, Integer> goodsList = new HashMap<>();
    static {
        goodsList.put("Good #1", 1);
        goodsList.put("Good #2", 3);
        goodsList.put("Good #3", 5);
        goodsList.put("Good #4", 10);
    }
}

