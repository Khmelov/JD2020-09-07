package by.it.kalashnikov.jd01_13;

//TaskB. В классе TaskB напишите цикл, который:
//         считывает данные из консоли построчно и закрывается при вводе в консоль слова END;
//         переводит каждую строку в вещественное число и выводит в консоль данное число и
//        корень из суммы всех
//        ранее введенных чисел, включая введенное;
//         если перевести ввод в число невозможно, то программа перехватывает
//        полученную ошибку и показывает сообщение в консоли, такого же формата,
//        как в предыдущем задании
//         если невозможно извлечь корень, то обработка аналогична,
//        но тип ошибки - ArithmeticException

import java.util.*;

class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double summa = 0;
        for (; ; ) {
            String s = scanner.next();
            if (s.equals("END")) {
                break;
            }
            Double number = null;
            Double sqrt = null;
            try {
                number = Double.parseDouble(s);
                summa += number;
                sqrt = Math.sqrt(summa);
                if (Double.isNaN(sqrt)) {
                    throw new ArithmeticException("Error: ");
                }
            } catch (NumberFormatException |ArithmeticException e) {
                StackTraceElement[] stackTraceElements = e.getStackTrace();
                for (StackTraceElement element : stackTraceElements) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        System.out.printf(
                                " name: %s\n" +
                                "class: %s\n" +
                                " line: %d\n",
                                e.getClass().getName(), element.getClassName(),
                                element.getLineNumber());
                    }
                }
            }
            System.out.println(number);
            System.out.println(sqrt);
        }
    }
}