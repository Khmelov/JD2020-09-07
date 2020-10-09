package by.it.yatsevich.jd01_13;

import java.util.*;

class TaskC {
    static int value = 0;
    static List<Double> temp = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);
        readData(scan);
    }

    private static void readData(Scanner scan) throws InterruptedException {
        while (value < 5) {
            try {
                System.out.println("value = "+value);
                String i = scan.next();
                System.out.println(i);
                Double j = Double.parseDouble(i);
                temp.add(j);

            } catch (NumberFormatException e) {
                Thread.sleep(100);
                Collections.reverse(temp);
                Iterator it=temp.iterator();
                while (it.hasNext()){
                    Object next = it.next();
                    System.out.print(" "+next);
                Collections.reverse(temp);
                }
                value++;
            }
        }
    }
}
