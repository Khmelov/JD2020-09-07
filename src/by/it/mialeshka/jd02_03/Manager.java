package by.it.mialeshka.jd02_03;

class Manager implements Runnable{
    @Override
    public void run() {
        while (!Dispatcher.planComplate()) {
            while (Dispatcher.getWorkCashier()*5 <= QueueBuyers.size()){
                Cashier cashier = ListCashier.extract();
                if(cashier != null){
                    synchronized (cashier){
                        System.out.println(cashier + " open");
                        Dispatcher.cashierStart();
                        cashier.notify();
                    }
                }
                {
                    Helper.sleep(100);
                }
            }
        }
        while (ListCashier.size() > 0){
            Cashier cashier = ListCashier.extract();
            if(cashier != null){
                synchronized (cashier){
                    Dispatcher.cashierStart();
                    cashier.notify();

                }
            }
            {
                Helper.sleep(100);
            }
        }
    }
}

