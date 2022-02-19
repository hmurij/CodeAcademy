package lt.codeacademy.generator.password;

import lt.codeacademy.generator.symbol.SymbolGenerator;

public class LetterPasswordGenerator extends PasswordGenerator<SymbolGenerator> {

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    boolean validatePassword(String password) {
        return false;
    }
}
