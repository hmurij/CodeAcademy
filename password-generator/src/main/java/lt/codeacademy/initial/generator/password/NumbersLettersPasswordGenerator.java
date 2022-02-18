package lt.codeacademy.initial.generator.password;

import lt.codeacademy.initial.generator.symbol.LetterGenerator;
import lt.codeacademy.initial.generator.symbol.NumberGenerator;
import lt.codeacademy.initial.generator.symbol.SymbolGenerator;

public class NumbersLettersPasswordGenerator implements PasswordGenerator<SymbolGenerator>{
    private static final int MIN_SYMBOLS = 8;

    @Override
    public String getPassword() {
        return this.generatePassword(new SymbolGenerator[]{new NumberGenerator(), new LetterGenerator()},
                MIN_SYMBOLS);
    }
}
