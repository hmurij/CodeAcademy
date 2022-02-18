package lt.codeacademy.initial.factory;


import lt.codeacademy.initial.generator.password.LetterPasswordGenerator;
import lt.codeacademy.initial.generator.password.NaturalNumbersPasswordGenerator;
import lt.codeacademy.initial.generator.password.NumbersLettersPasswordGenerator;
import lt.codeacademy.initial.generator.password.PasswordGenerator;

public class GeneratorFactory {

    public static PasswordGenerator getGenerator(String generatorType) {
        PasswordGenerator passwordGenerator = null;

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
