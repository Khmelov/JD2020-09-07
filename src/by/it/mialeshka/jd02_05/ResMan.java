package by.it.mialeshka.jd02_05;

import java.text.DateFormat;
import java.util.*;

public enum  ResMan {
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
    public static final String BASE_NAME = "by/it/mialeshka/jd02_05/Res/language";
    private ResourceBundle bundle;
    private DateFormat dateFormat;
    Locale locale;

    ResMan() {
        locale = Locale.US;
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BASE_NAME, locale);
        dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
    }

    public void setLocale(String localeStr) {
        Locale locale = new Locale(mapLanguage.getOrDefault(localeStr, "en"), mapСountry.getOrDefault(localeStr, "US"));
        setLocale(locale);
    }

    public String get(String key){
        return bundle.getString(key);
    }

    public String getDate(){
        Date date = new Date();
        return dateFormat.format(date);
    }
}
