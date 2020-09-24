package by.it.adryneuski.jd01_02;

public class PrintF {
    public static void main(String[] args) {

        //System.out.printf("%1$-16.8g", Math.PI);
       // System.out.printf("%-5s%-12s%-25s%-10s%n", "Код", "За единиц", "Валюты", "Бел. рублей");
        for (int i = 0; i < 16; i++) {
            final String bin = String

                    .format("%4s", Integer.toBinaryString(i))
                    .replace(' ', '0');

            System.out.printf("DEC:%1$03d OCT:%1$03o HEX:%1$03x BIN:%2$2s %n", i, bin);
        }
    }
}


