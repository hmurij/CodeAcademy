package lt.codeacademy.generator.symbol;

import java.util.Random;

public class LetterGenerator extends SymbolGenerator{

    /**
     * Generates random capital letter in range from A to Z inclusive
     * @return generated letter, randomly changed to lower case
     */
    @Override
    public String generateSymbol() {
        Random random = new Random();
        String randomUppercaseLetter = "" + (char) (65 + random.nextInt(26));
        return random.nextBoolean() ? randomUppercaseLetter : randomUppercaseLetter.toLowerCase();
    }
}
