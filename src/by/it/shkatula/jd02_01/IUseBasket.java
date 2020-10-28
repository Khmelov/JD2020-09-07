package by.it.shkatula.jd02_01;

import java.util.HashMap;

public interface IUseBasket extends IBuyer {
    HashMap<String, String> products = new HashMap<String, String>() {{
        put("1.0 $", "Apples");
        put("1.95 $", "Milk");
        put("1.20 $", "Chokolate");
        put("2.25 $", "Bread");
    }};

    void takeBasket();

    void putGoodsToBasket();
}
