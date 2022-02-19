package lt.codeacademy.factory;


import lt.codeacademy.generator.password.LetterPasswordGenerator;
import lt.codeacademy.generator.password.NaturalNumbersPasswordGenerator;
import lt.codeacademy.generator.password.NumbersLettersPasswordGenerator;
import lt.codeacademy.generator.password.PasswordGenerator;
import lt.codeacademy.generator.symbol.SymbolGenerator;

public class GeneratorFactory {

    public static PasswordGenerator<SymbolGenerator> getGenerator(String generatorType) {
        PasswordGenerator<SymbolGenerator> passwordGenerator = null;

        if (generatorType.equalsIgnoreCase("NUMBERS")) {
            passwordGenerator = new NaturalNumbersPasswordGenerator();
        } else if (generatorType.equalsIgnoreCase("LETTERS")) {
            passwordGenerator = new LetterPasswordGenerator();
        } else if (generatorType.equalsIgnoreCase("NUMBERS_LETTERS")) {
            passwordGenerator = new NumbersLettersPasswordGenerator();
        }

        return passwordGenerator;
    }
}
