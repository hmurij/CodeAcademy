package lt.codeacademy.generator.symbol;

import java.util.Random;

public class NumberGenerator extends SymbolGenerator {

    /**
     * Generates number in range from 0 to 9 inclusive
     * @return generated number as String object
     */
    @Override
    public String generateSymbol() {
        return "" + new Random().nextInt(10);
    }
}
