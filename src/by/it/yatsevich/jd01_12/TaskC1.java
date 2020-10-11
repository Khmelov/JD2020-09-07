package by.it.yatsevich.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> temp = new ArrayList<>();
        Map<Long, String> longStringMap;
        String str;
        scan.useDelimiter("[/\\s\\.—,:;?(){}]");
        while (!(str=scan.nextLine()).equals("end")){
            temp.add(str);
        }

    }
}
