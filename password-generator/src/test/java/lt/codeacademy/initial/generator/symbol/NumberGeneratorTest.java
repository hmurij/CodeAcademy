package lt.codeacademy.initial.generator.symbol;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberGeneratorTest {

    @RepeatedTest(20)
    void givenNumberGeneratorObject_whenGenerateSymbol_thenIsDigitTrue() {
        NumberGenerator numberGenerator = new NumberGenerator();

        String generatedNumber = numberGenerator.generateSymbol();

        assertAll(
                () -> assertEquals(1, generatedNumber.length()),
                () -> assertTrue(Character.isDigit(generatedNumber.charAt(0)))
        );

    }
}