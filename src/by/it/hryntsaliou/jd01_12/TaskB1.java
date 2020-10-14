package by.it.hryntsaliou.jd01_12;

import java.util.*;

class TaskB1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> formattedList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String line = scanner.next();
            if (line.equals("end")) {
                break;
            }
            if (line.equals("isn't")) {
                list.add("don't");
            }
            list.add(line);
        }

        Map<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            String formattedLine = list.get(i).replaceAll("[,.:;\\s\\n]", "");
            formattedList.add(formattedLine);
        }
        //System.out.println(formattedList);

        for (int i = 0; i < formattedList.size(); i++) {
            hashMap.put(formattedList.get(i), 0);
        }

        Set<Map.Entry<String, Integer>> set = hashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            for (int i = 0; i < formattedList.size(); i++) {
                if (entry.getKey().equals(formattedList.get(i))) {
                    int value = entry.getValue();
                    value++;
                    hashMap.put(entry.getKey(), value);
                }
            }
            System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());
        }
    }
}