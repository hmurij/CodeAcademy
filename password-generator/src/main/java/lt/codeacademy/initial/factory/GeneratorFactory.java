package lt.codeacademy.initial.factory;


import lt.codeacademy.initial.generator.LetterPasswordGenerator;
import lt.codeacademy.initial.generator.NaturalNumberPasswordGenerator;
import lt.codeacademy.initial.generator.NumbersLettersPasswordGenerator;
import lt.codeacademy.initial.generator.PasswordGenerator;

public class GeneratorFactory {

    public static PasswordGenerator getGenerator(String generatorType) {
        PasswordGenerator passwordGenerator = null;

        if (generatorType.equalsIgnoreCase("NUMBERS")) {
            passwordGenerator = new NaturalNumberPasswordGenerator();
        } else if (generatorType.equalsIgnoreCase("LETTERS")) {
            passwordGenerator = new LetterPasswordGenerator();
        } else if (generatorType.equalsIgnoreCase("NUMBERS_LETTERS")) {
            passwordGenerator = new NumbersLettersPasswordGenerator();
        }

        return passwordGenerator;
    }
}
