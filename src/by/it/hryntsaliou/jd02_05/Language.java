package by.it.hryntsaliou.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {
    RB;
    private static final String LANGUAGE = "by.it.hryntsaliou.jd02_05.resources.language";

    private Locale locale;

    private ResourceBundle resourceBundle;

    Language() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(LANGUAGE, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}
