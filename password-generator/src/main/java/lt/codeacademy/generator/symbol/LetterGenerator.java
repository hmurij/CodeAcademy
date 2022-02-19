package lt.codeacademy.generator.symbol;

import java.util.Random;

public class LetterGenerator extends SymbolGenerator{

    /**
     * Generates random capital letter in range from A to Z inclusive
     * @return generated letter, randomly changed to lower case
     */
    @Override
    public String generateSymbol() {
        String randomUppercaseLetter = "" + (char) (65 + new Random().nextInt(26));
        return new Random().nextBoolean() ? randomUppercaseLetter : randomUppercaseLetter.toLowerCase();
    }
}
