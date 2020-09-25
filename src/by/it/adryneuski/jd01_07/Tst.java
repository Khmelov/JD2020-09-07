package by.it.adryneuski.jd01_07;

import java.util.Arrays;

public class Tst {
    public static void main(String[] args) {


  String strVector = "1 2 4";

  double[] value1 = Arrays.stream(strVector.split(" ")).mapToDouble(Double::parseDouble).toArray();
        System.out.println(value1);
    }
}