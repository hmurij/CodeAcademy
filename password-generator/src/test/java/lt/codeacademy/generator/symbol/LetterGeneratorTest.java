package lt.codeacademy.generator.symbol;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LetterGeneratorTest {

    @RepeatedTest(20)
    public void givenLetterGenerator_whenGenerateSymbol_thenIsLetterTrue() {
        LetterGenerator letterGenerator = new LetterGenerator();

        String letter = letterGenerator.generateSymbol();

        assertAll(
                () -> assertEquals(1, letter.length()),
                () -> assertTrue(Character.isLetter(letter.charAt(0)))
        );
    }
}