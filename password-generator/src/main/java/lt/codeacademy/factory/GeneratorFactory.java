package lt.codeacademy.factory;


import lt.codeacademy.GeneratorType;
import lt.codeacademy.generator.password.LetterPasswordGenerator;
import lt.codeacademy.generator.password.NaturalNumbersPasswordGenerator;
import lt.codeacademy.generator.password.NumbersLettersPasswordGenerator;
import lt.codeacademy.generator.password.PasswordGenerator;
import lt.codeacademy.generator.symbol.SymbolGenerator;

public class GeneratorFactory {

    public static PasswordGenerator<SymbolGenerator> getGenerator(GeneratorType generatorType) {
        PasswordGenerator<SymbolGenerator> passwordGenerator = null;

        if (generatorType == GeneratorType.NUMBERS) {
            passwordGenerator = new NaturalNumbersPasswordGenerator();
        } else if (generatorType == GeneratorType.LETTERS) {
            passwordGenerator = new LetterPasswordGenerator();
        } else if (generatorType == GeneratorType.NUMBERS_LETTERS) {
            passwordGenerator = new NumbersLettersPasswordGenerator();
        }

        return passwordGenerator;
    }
}
