package by.it.stefankin.jd02_05.txt;

import by.it.stefankin.jd02_05.txt.Message;

import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {
    public static void main(String[] args) {
        Resman resur =Resman.INSTANCE;
        if (args.length==2){
            Locale locale=new Locale(args[0],args[1]);
            resur.setlocale(locale);
        }
        System.out.println(resur.getSrng(Message.hello));
        System.out.println(resur.getSrng(Message.question));
        System.out.println(resur.getSrng(User.lastname));
        System.out.println(resur.getSrng(User.firstname));
    }


}
