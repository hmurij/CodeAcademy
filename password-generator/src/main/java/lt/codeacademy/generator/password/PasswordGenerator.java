package lt.codeacademy.generator.password;

import lt.codeacademy.generator.symbol.SymbolGenerator;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class PasswordGenerator<T extends SymbolGenerator> {
    abstract public String getPassword();

    /**
     * Generates password of provided minimum length using array of symbol generators
     *
     * @param symbolGenerators array of {@link SymbolGenerator} objects
     * @param minLength minimum password length
     * @return generated password of minimum length
     */
    String generatePassword(T[] symbolGenerators, int minLength){
        Random random = new Random();
        String password;

        do {
            password = Stream.generate(()-> symbolGenerators[random.nextInt(symbolGenerators.length)].generateSymbol())
                    .limit(minLength + random.nextInt(10))
                    .collect(Collectors.joining());
        } while (!validatePassword(password));

        return password;
    }

    abstract boolean validatePassword(String password);
}
