package by.it.tarasevich.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum  Lang {
    RB;


    private static final String KEYWORDS ="by.it.tarasevich.jd02_05.resources.keywords";


    private Locale locale;

    private ResourceBundle resourceBundle;

    Lang() {
        setLocale(Locale.UK);
    }

    public void setLocale(Locale locale) {
        this.locale=locale;
        resourceBundle = ResourceBundle.getBundle(KEYWORDS, locale);

    }

    public String get(String key){
        return resourceBundle.getString(key);
    }


    public Locale getLocale() {
        return locale;
    }
}
