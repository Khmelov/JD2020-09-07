package by.it.tarasevich.jd01_03;

public class Main {

    public static void main(String[] args) {




        String line = "12,54,67,245,967,34,12,567,23";
        double[] v = InOut.getArray(line);


        System.out.println( " Массив V ");
        InOut.printArray(v,"v", 5);

        Utils.sortIntArray(v,true);
        System.out.println("Массив v отсортированный по возрастанию");
        InOut.printArray(v, "v", 5);

        Utils.sortIntArray(v,false);
        System.out.println("Массив v отсортированный по убыванию");
        InOut.printArray(v, "v", 5);

        System.out.println("Максимум массива Max = "+Utils.MaxIntArray(v));
        System.out.println("Максимум массива Max = "+Utils.MinIntArray(v));
        System.out.println("Сортировка массива ");


    }


}
