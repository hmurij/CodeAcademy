package lt.codeacademy.initial.generator.password;

import lt.codeacademy.initial.generator.symbol.SymbolGenerator;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface PasswordGenerator<T extends SymbolGenerator> {
    String getPassword();

    default String generatePassword(T[] symbolGenerators, int minLength){

        return Stream.generate(()-> symbolGenerators[new Random().nextInt(symbolGenerators.length)].generateSymbol())
                .limit(minLength + new Random().nextInt(10))
                .collect(Collectors.joining());
    }
}
