package by.it.mialeshka.jd02_05.calc;

import java.util.*;

public enum ResMan {
    INSTANCE;
    Map<String, String> mapLanguage = new HashMap<>();{
        mapLanguage.put("ru", "ru");
        mapLanguage.put("be", "be");
        mapLanguage.put("en", "en");
    }
    Map<String, String> mapСountry = new HashMap<>();{
        mapСountry.put("ru", "RU");
        mapСountry.put("be", "BY");
        mapСountry.put("en", "US");
    }
    public static final String BASE_NAME = "by/it/mialeshka/jd02_05/calc/res/language";
    private ResourceBundle bundle;
    Locale locale;

    ResMan() {
        locale = Locale.getDefault();
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BASE_NAME, locale);
    }

    public void setLocale(String localeStr) {
        Locale locale = new Locale(mapLanguage.getOrDefault(localeStr, "en"), mapСountry.getOrDefault(localeStr, "US"));
        setLocale(locale);
    }

    public String get(String key){
        return bundle.getString(key);
    }

}
