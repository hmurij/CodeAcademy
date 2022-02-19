package lt.codeacademy.generator.password;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LetterPasswordGeneratorTest {

    @Test
    void givenValidPassword_whenValidatePassword_thenTrue() {
        LetterPasswordGenerator passwordGenerator = new LetterPasswordGenerator();
        String password = "abcdABCD";

        boolean isValid = passwordGenerator.validatePassword(password);

        assertTrue(isValid);
    }

    @Test
    void givenInvalidPassword_whenValidatePassword_thenTrue() {
        LetterPasswordGenerator passwordGenerator = new LetterPasswordGenerator();
        String password = "abcdABCD12";

        boolean isValid = passwordGenerator.validatePassword(password);

        assertFalse(isValid);
    }

    @Test
    void givenShortPassword_whenValidatePassword_thenFalse() {
        LetterPasswordGenerator passwordGenerator = new LetterPasswordGenerator();
        String password = "abcdABC";

        boolean isValid = passwordGenerator.validatePassword(password);

        assertFalse(isValid);
    }

}