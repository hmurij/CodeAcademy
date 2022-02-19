package lt.codeacademy.generator.password;

import lt.codeacademy.generator.symbol.SymbolGenerator;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class PasswordGenerator<T extends SymbolGenerator> {
    abstract String getPassword();

    /**
     * Generates password of provided minimum length using array of symbol generators
     *
     * @param symbolGenerators array of {@link SymbolGenerator} objects
     * @param minLength minimum length of password
     * @return generated password of minimum length
     */
    String generatePassword(T[] symbolGenerators, int minLength){
        String password;

        do {
            password = Stream.generate(()-> symbolGenerators[new Random().nextInt(symbolGenerators.length)].generateSymbol())
                    .limit(minLength + new Random().nextInt(10))
                    .collect(Collectors.joining());
        } while (!validatePassword(password));

        return password;
    }

    abstract boolean validatePassword(String password);
}
