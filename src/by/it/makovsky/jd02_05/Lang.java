package by.it.makovsky.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Lang {
    EA;
    private static final String KEYWORDS = "by.it.makovsky.jd02_05.res.language";

    private Locale locale;

    private ResourceBundle resourceBundle;

    Lang() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        this.locale=locale;
        resourceBundle = ResourceBundle.getBundle(KEYWORDS, locale);

    }

    public String get(String key){
        return resourceBundle.getString(key);
    }


}
