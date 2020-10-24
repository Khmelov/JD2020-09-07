package by.it.trukhanovich.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum  Lang {
    INSTANCE;
    public static final String BASE_NAME = "by.it.trukhanovich.jd02_05.resources.keywords";
    private Locale locale;
    private ResourceBundle bundle;

    Lang() {
        locale = Locale.getDefault();
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(
                BASE_NAME, locale);
    }
    public String get(String key){
        return bundle.getString(key);
    }
}
