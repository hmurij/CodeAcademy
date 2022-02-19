package lt.codeacademy.generator.password;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersLettersPasswordGeneratorTest {

    @Test
    void givenValidPassword_whenValidatePassword_thenTrue() {
        NumbersLettersPasswordGenerator passwordGenerator = new NumbersLettersPasswordGenerator();
        String password = "1234KKKlll";

        boolean isValid = passwordGenerator.validatePassword(password);

        assertTrue(isValid);
    }

    @Test
    void givenShorPassword_whenValidatePassword_thenFalse() {
        NumbersLettersPasswordGenerator passwordGenerator = new NumbersLettersPasswordGenerator();
        String password = "12Kll";

        boolean isValid = passwordGenerator.validatePassword(password);

        assertFalse(isValid);
    }

    @Test
    void givenNoDigitPassword_whenValidatePassword_thenFalse() {
        NumbersLettersPasswordGenerator passwordGenerator = new NumbersLettersPasswordGenerator();
        String password = "KLMNDSOlldaldksjf";

        boolean isValid = passwordGenerator.validatePassword(password);

        assertFalse(isValid);
    }

    @Test
    void givenNoUppercaseLetterPassword_whenValidatePassword_thenFalse() {
        NumbersLettersPasswordGenerator passwordGenerator = new NumbersLettersPasswordGenerator();
        String password = "12345i59daldksjf";

        boolean isValid = passwordGenerator.validatePassword(password);

        assertFalse(isValid);
    }

    @Test
    void givenNoLowercaseLetterPassword_whenValidatePassword_thenFalse() {
        NumbersLettersPasswordGenerator passwordGenerator = new NumbersLettersPasswordGenerator();
        String password = "12345I59DALDKE";

        boolean isValid = passwordGenerator.validatePassword(password);

        assertFalse(isValid);
    }
}