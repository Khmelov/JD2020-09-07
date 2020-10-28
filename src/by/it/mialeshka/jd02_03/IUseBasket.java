package by.it.mialeshka.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

interface IUseBasket {
    BlockingDeque<Boolean> OccupiedBaskets = new LinkedBlockingDeque<>(50);
    void takeBasket(); //взял корзину
    void putGoodsToBasket(); //положил выбранный товар в корзину
    void freeBaskets();
}
