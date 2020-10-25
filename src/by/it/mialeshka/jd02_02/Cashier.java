package by.it.mialeshka.jd02_02;

import java.util.Map;

class Cashier implements Runnable{
    private final String name;
    private final int numberCashier;
    private int countServBuyer;
    public Cashier(int number) {
        name = "\tCashier №" + number;
        countServBuyer = 0;
        numberCashier = number;
        Manager.cashierStart();
    }

    @Override
    public void run() {
        while (!Manager.planComplate()){
            waitCashier();
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null){
                countServBuyer ++;
                synchronized (buyer){
                    System.out.println(this + " begin to service " + buyer);
                    System.out.print(printСheck(buyer));
                    buyer.notify();
                    System.out.println(this + " finish to service " + buyer);
                    System.out.flush();
                }
                int time = Helper.getRandom(2000, 5000);
                Helper.sleep(time);
            }
            else{
                Helper.sleep(100);
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }

    private void waitCashier(){
        synchronized (this){
            if((Manager.getWorkCashier()*5 > QueueBuyers.size() && QueueBuyers.size() > 0) || Manager.startWorkShop()){
                Manager.cashierStop();
                ListCashier.add(this);
                try {
                    if (this.countServBuyer > 0) System.out.println(this + " closed");
                    this.countServBuyer = 0;
                    this.wait();
                } catch (InterruptedException e) {
                    this.countServBuyer = 0;
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public String printСheck(Buyer buyer) {
        StringBuilder check = new StringBuilder();
        check.append(buyer.getName()).append("\n");
        check.append("Cashier 1             ")
                .append("Cashier 2             ")
                .append("Cashier 3             ")
                .append("Cashier 4             ")
                .append("Cashier 5             ")
                .append("QueueSize             ")
                .append("Total                 ")
                .append("\n");

        for (Map.Entry<String, Double> good: buyer.goods.entrySet()) {
            for (int i = 1; i <= Manager.PLAN_CASHIER; i++) {
                if (numberCashier == i){
                    check.append(String.format("%-22s", String.format("%s - %10.2f", good.getKey(), good.getValue())));
                    Manager.addPrice(good.getValue());
                }
                else{
                    check.append(String.format("%22s", ""));
                }
            }
            check.append(String.format("%-22d", QueueBuyers.size()));
            check.append(String.format("%-22.2f", Manager.TOTAL_SUMM)).append("\n");
        }
        return check.toString();
    }

}
