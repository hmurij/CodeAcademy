package lt.codeacademy.menu;

import static lt.codeacademy.PasswordGeneratorApplication.SCANNER;

/**
 * Every console menu's should use this interface
 *
 * @author pavel.vrublevskij
 */
public interface ConsoleMenu {

    /**
     * Method should contain a menu as text for console application.
     */
    void print();

    /**
     * Method waits for user input and return @{@link String}
     *
     * @return String as input
     */
    default String readInput() {
        System.out.print("Your input: ");

        return SCANNER.nextLine();
    }
}
