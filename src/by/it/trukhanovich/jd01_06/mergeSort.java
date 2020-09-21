package by.it.trukhanovich.jd01_06;

public class mergeSort {

    public static void mergeSort (String[] array)
    {

        int left = 0;
        int right = array.length;
        int middle = 0;
        if (array.length < 2) {
            return;
        }

        if (left < right) {
            middle = (left + right) / 2;
        }
        String[] part1 = new String [middle];
        String [] part2 = new String [right - middle];
        for (int i = 0; i < middle; i++) {
            part1[i] = array[i];
        }

        for (int j = middle; j < right; j++) {
            part2[j - middle] = array[j];
        }

        mergeSort(part1);
        mergeSort(part2);
        String array1[]=new String[array.length];
        array1 = merge(part1, part2);
        for (int i = 0; i < array.length; i++) {
            array[i]=array1[i];
        }
//        System.out.println("array111");
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i]+" ");
//        }
        return;

    }


//        private static void mergeSort (String [ ] array)
//        {
//
//            int left = 0;
//            int right = array.length;
//            int middle = 0;
//            if (array.length < 2) {
//                return;
//            }
//
//            if (left < right) {
//                middle = (left + right) / 2;
//            }
//            String[] part1 = new String [middle];
//            String [] part2 = new String [right - middle];
//            for (int i = 0; i < middle; i++) {
//                part1[i] = array[i];
//            }
//
//            for (int j = middle; j < right; j++) {
//                part2[j - middle] = array[j];
//            }
//
//            mergeSort(part1);
//            mergeSort(part2);
//            String array1[]=new String[array.length];
//            array1 = merge(part1, part2);
//            for (int i = 0; i < array.length; i++) {
//                array[i]=array1[i];
//            }
//        }
    private static String[] merge(String[] part1, String[] part2) {
        String[] array = new String[part1.length + part2.length];
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        for (int i3 = 0; i3 < array.length; i3++) {
            if (i1==part1.length) {array[i3]=part2[i2]; i2++; continue;}
            else if (i2==part2.length) {array[i3]=part1[i1]; i1++; continue;}
                else if (part1[i1].length() < part2[i2].length()) {array[i3]=part1[i1]; i1++; continue;}
                    else if (part1[i1].length() > part2[i2].length()) {array[i3]=part2[i2]; i2++; continue;}
                    }
            return array;
        }
}

