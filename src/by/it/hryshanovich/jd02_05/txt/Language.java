package by.it.hryshanovich.jd02_05.txt;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {
    RB;
    private static final String KEYWORDS = "by.it.hryshanovich.jd02_05.resources.keywords";
    private Locale locale;
    private ResourceBundle resourceBundle;

    Language() {
        setLocale(new Locale("en","UK"));
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(KEYWORDS, locale);
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}
