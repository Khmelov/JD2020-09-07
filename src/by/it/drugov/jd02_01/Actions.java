package by.it.drugov.jd02_01;

public class Actions implements IBuyer{
    @Override
    public void enterToMarket() {
        System.out.println("Покупатель зашёл");
    }

    @Override
    public void chooseGoods() {
        System.out.println("Покуптель выбрал товары");

    }

    @Override
    public void leaveMarket() {
        System.out.println("Покупатель вышел");

    }
}
