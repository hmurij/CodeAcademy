package lt.codeacademy.initial.generator;

public class NumbersLettersPasswordGenerator implements PasswordGenerator{
    @Override
    public void generatePassword() {
        System.out.println("Generate password using using letters and numbers length minimum 6 symbols," +
                " at least one number, lower case and uppercase letter");
    }
}
