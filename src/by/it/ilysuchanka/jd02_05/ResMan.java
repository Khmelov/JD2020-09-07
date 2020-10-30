package by.it.ilysuchanka.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum  ResMan {
    INSTANCE;
    public static final String LANGUAGE = "by.it.kulik.jd02_05.res.language";
    private Locale locale;
    private ResourceBundle bundle;



    ResMan() {
        locale = Locale.US;
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
       bundle= ResourceBundle.getBundle(LANGUAGE, locale);
    }
    public String get(String key){
        return bundle.getString(key);
    }
}
