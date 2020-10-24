package by.it.trukhanovich.jd02_05;


import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        Lang resource = Lang.INSTANCE;
        if (args.length==2){
            Locale locale = new Locale(args[0],args[1]);
            resource.setLocale(locale);
        }
        else resource.setLocale(new Locale("en", "UK"));

        System.out.println(resource.get(Message.QUESTION));
        System.out.println(resource.get(Message.WELCOME));
        System.out.println(resource.get(User.FIRST_NAME));
        System.out.println(resource.get(User.LAST_NAME));

    }
}
