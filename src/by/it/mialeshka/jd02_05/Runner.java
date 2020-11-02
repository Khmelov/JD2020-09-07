package by.it.mialeshka.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class Runner{
    public static void main(String[] args) {
        ResMan res = ResMan.INSTANCE;
        if (args.length == 2){
            Locale locale = new Locale(args[0], args[1]);
            res.setLocale(locale);
        }
        else{
            Scanner scanner = new Scanner(System.in);
            res.setLocale(scanner.next());
        }
        System.out.println(res.get(Message.hello));
        System.out.println(res.get(Message.question));
        System.out.println(res.get(User.firstName));
        System.out.println(res.get(User.lastName));
        System.out.println(res.getDate());
    }
}
