package by.it.yatsevich.jd02_02;

public class Cashier implements Runnable {

    private final String name;

    Cashier(int number){
        name="Cashier № "+number+": ";
    }

    @Override
    public void run() {
        System.out.println(this+" opened");
        while (!Supervisor.planComplete()){
            Buyer getBuyer=Queue.get();
            if (getBuyer!=null){
                System.out.println(this+" start service"+getBuyer);
                int timer=Helper.getRandom(2000,5000);
                Helper.sleep(timer);
                synchronized (getBuyer){
                    getBuyer.notify();
                }
                System.out.println(this+" finished service"+getBuyer);
            }
            else {
                Helper.sleep(100);
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        }

        System.out.println(this+" closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
