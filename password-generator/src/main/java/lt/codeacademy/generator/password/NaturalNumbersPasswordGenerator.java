package lt.codeacademy.generator.password;

import lt.codeacademy.generator.symbol.NumberGenerator;
import lt.codeacademy.generator.symbol.SymbolGenerator;

import java.util.Arrays;

public class NaturalNumbersPasswordGenerator extends PasswordGenerator<SymbolGenerator> {
    private static final int MIN_SYMBOLS = 12;

    /**
     * Calls generatePassword method with {@link NumberGenerator} as parameter.
     * Returns password with MIN_SYMBOLS length consisting of numbers.
     *
     * @return generated password of MIN_SYMBOLS length
     */
    @Override
    public String getPassword() {
        return generatePassword(
                new SymbolGenerator[]{new NumberGenerator()},
                MIN_SYMBOLS
        );
    }

    /**
     * Checks whether password is of MIN_SYMBOLS length
     *
     * @param password to validate
     * @return true if password valid, false otherwise
     */
    @Override
    boolean validatePassword(String password) {
        int length = password.length();

        boolean onlyDigits = Arrays.stream(password.split("")).filter(s -> Character.isDigit(s.charAt(0))).count() == length;

        return length >= MIN_SYMBOLS && onlyDigits;
    }

}
