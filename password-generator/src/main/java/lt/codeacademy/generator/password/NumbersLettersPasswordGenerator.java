package lt.codeacademy.generator.password;

import lt.codeacademy.generator.symbol.LetterGenerator;
import lt.codeacademy.generator.symbol.NumberGenerator;
import lt.codeacademy.generator.symbol.SymbolGenerator;

import java.util.Arrays;

public class NumbersLettersPasswordGenerator implements PasswordGenerator<SymbolGenerator> {
    private static final int MIN_SYMBOLS = 8;

    /**
     * Calls generatePassword method with {@link NumberGenerator} and {@link LetterGenerator} as parameters.
     * Returns password with MIN_SYMBOLS length consisting of letters and numbers with minimum one number and
     * two upper case and lower case letters.
     *
     * @return generated password of MIN_SYMBOLS length
     */
    @Override
    public String getPassword() {
        String password;

        do {
            password = this.generatePassword(new SymbolGenerator[]{new NumberGenerator(), new LetterGenerator()},
                    MIN_SYMBOLS);
        } while (!validatePassword(password));

        return password;
    }

    /**
     * Checks whether password is of MIN_SYMBOLS length and contains minimum one number and
     * two upper case and lower case letters.
     *
     * @param password to validate
     * @return true if password valid, false otherwise
     */
    boolean validatePassword(String password) {
        int length = password.length();
        String[] symbols = password.split("");

        boolean hasNumber = Arrays.stream(symbols).anyMatch(s -> Character.isDigit(s.charAt(0)));
        boolean hasUpperCaseLetter = Arrays.stream(symbols).anyMatch(s -> Character.isUpperCase(s.charAt(0)));
        boolean hasLowerCaseLetter = Arrays.stream(symbols).anyMatch(s -> Character.isLowerCase(s.charAt(0)));

        return length >= MIN_SYMBOLS && hasNumber && hasLowerCaseLetter && hasUpperCaseLetter;
    }
}
