package lt.codeacademy.initial.generator.symbol;

import java.util.Random;

public class LetterGenerator extends SymbolGenerator{
    @Override
    public String generateSymbol() {
        String randomUppercaseLetter = "" + (char) (65 + new Random().nextInt(26));

        return new Random().nextBoolean() ? randomUppercaseLetter : randomUppercaseLetter.toLowerCase();
    }
}
