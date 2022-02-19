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
    void givenShorPassword_whenValidatePassword_thenFalse() {
        NumbersLettersPasswordGenerator passwordGenerator = new NumbersLettersPasswordGenerator();
        String password = "1223988";

        boolean isValid = passwordGenerator.validatePassword(password);

        assertFalse(isValid);
    }
}