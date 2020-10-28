package by.it.tarasevich.jd02_05;




import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        Lang manager = Lang.RB;
        manager.setLocale(Locale.ENGLISH);
        if (args.length==2){
            Locale locale = new Locale(args[0], args[1]);
            manager.setLocale(locale);
        }
        System.out.println(manager.get(Messege.WELCOME));
        System.out.println(manager.get(Messege.QUESTION));
        System.out.println(manager.get(User.FIRST_NAME));
        System.out.println(manager.get(User.LAST_NAME));
    }
}
