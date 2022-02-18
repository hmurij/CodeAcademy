package lt.codeacademy.initial.generator.password;

public class NaturalNumbersPasswordGenerator implements PasswordGenerator{
    @Override
    public void generatePassword() {
        System.out.println("Generate password using natural numbers length minimum 12 symbols");
    }
}
