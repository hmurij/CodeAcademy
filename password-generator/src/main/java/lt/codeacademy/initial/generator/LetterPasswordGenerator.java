package lt.codeacademy.initial.generator;

public class LetterPasswordGenerator implements PasswordGenerator{
    @Override
    public void generatePassword() {
        System.out.println("Generate password using using letters length minimum 8 symbols");
    }
}
