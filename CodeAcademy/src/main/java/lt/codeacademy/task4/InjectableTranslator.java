package lt.codeacademy.task4;

import java.util.function.Function;

import static lt.codeacademy.task4.Translator.toLocale;

public class InjectableTranslator implements Function<String, String> {

    @Override
    public String apply(String key) {
        return toLocale(key);
    }
}
