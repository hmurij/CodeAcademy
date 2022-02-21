package lt.codeacademy.task4;

import java.util.Map;

public class Translator {
    private static Map<String, String> translations = Map.of(
            "hello", "Welcome to our app",
            "entry_added", "Entry has been added",
            "logout", "Logout");

    public static String toLocale(String key) {
        return translations.get(key);
    }
}
