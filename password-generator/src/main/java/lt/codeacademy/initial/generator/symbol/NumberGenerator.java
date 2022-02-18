package lt.codeacademy.initial.generator.symbol;

import java.util.Random;

public class NumberGenerator extends SymbolGenerator {
    @Override
    public String generateSymbol() {
        return "" + new Random().nextInt(10);
    }
}
