package by.it.stefankin.jd02_05.txt;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Resman  {
    INSTANCE;
    public static final String BASENAME = "by.it.stefankin.jd02_05.resourses.language";
    private Locale locale;

    private ResourceBundle bundle;


    Resman(){
        locale=Locale.US;
        setlocale(locale);
    }

    public void setlocale(Locale locale) {
        bundle=ResourceBundle.getBundle(BASENAME, locale);
    }

    public String getSrng (String key){
        return bundle.getString(key);
    }


}
