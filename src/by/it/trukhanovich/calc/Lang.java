package by.it.trukhanovich.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Lang {
    LANG;

    public static final String BASE_NAME = "by.it.trukhanovich.calc.res.keywords";
    private ResourceBundle bundle;
    private Locale locale;
    Lang() {
        locale=Locale.getDefault();
        setLocale(locale);

    }

    public void setLocale(Locale locale) {
        bundle=ResourceBundle.getBundle(BASE_NAME,locale);
    }
    public String get(String key){
        return bundle.getString(key);
    }

}
