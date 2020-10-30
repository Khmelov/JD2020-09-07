package by.it.hryntsaliou.jd02_05;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

class Runner {
    public static void main(String[] args) {
        Language manager = Language.RB;
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            manager.setLocale(locale);
        }
        Scanner scanner = new Scanner(System.in);
        Locale locale = null;
        for (; ; ) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            if (line.equals("ru")) {
                locale = new Locale("ru", "RU");
                manager.setLocale(locale);

            }
            if (line.equals("be")) {
                locale = new Locale("be", "BY");
                manager.setLocale(locale);
            }
            if (line.equals("en")) {
                locale = new Locale("en", "UK");
                manager.setLocale(locale);
            }
            Date date = new Date();
            DateFormat simpleDateFormat = SimpleDateFormat.getDateInstance(SimpleDateFormat.FULL, locale);
            System.out.println(simpleDateFormat.format(date));
            System.out.println(manager.get(Message.hello));
            System.out.println(manager.get(Message.question));
            System.out.println(manager.get(User.name));
            System.out.println(manager.get(User.surname));
        }
    }
}
