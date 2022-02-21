package lt.codeacademy.task4;

import java.util.function.Function;

public class SpeechEngine {
    private Function<String, String> translator;

    public SpeechEngine(Function<String, String> translator) {
        this.translator = translator;
    }

    public String speak(String key) {
//        return translator.andThen(String::toUpperCase).apply(key);
        return translator.andThen(value -> value.toUpperCase()).apply(key);
    }

    public static void main(String[] args) {
        InjectableTranslator injectableTranslator = new InjectableTranslator();
        SpeechEngine speechEngine = new SpeechEngine(injectableTranslator);

        System.out.println(speechEngine.speak("hello"));
        System.out.println(speechEngine.speak("entry_added"));
        System.out.println(speechEngine.speak("logout"));
    }
}

