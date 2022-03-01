package lt.codeacademy.generator.password;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NaturalNumbersPasswordGeneratorTest {

    @Test
    void givenValidPassword_whenValidatePassword_thenTrue() {
        NaturalNumbersPasswordGenerator passwordGenerator = new NaturalNumbersPasswordGenerator();
        String password = "123434939392";

        boolean isValid = passwordGenerator.validatePassword(password);

        assertTrue(isValid);
    }

    @Test
    void givenInvalidPassword_whenValidatePassword_thenTrue() {
        NaturalNumbersPasswordGenerator passwordGenerator = new NaturalNumbersPasswordGenerator();
        String password = "12d343L493K9392";

        boolean isValid = passwordGenerator.validatePassword(password);

        assertFalse(isValid);
    }

    @Test
    void givenShortPassword_whenValidatePassword_thenFalse() {
        NumbersLettersPasswordGenerator passwordGenerator = new NumbersLettersPasswordGenerator();
        String password = "12345678901";

        boolean isValid = passwordGenerator.validatePassword(password);

        assertFalse(isValid);
    }
}