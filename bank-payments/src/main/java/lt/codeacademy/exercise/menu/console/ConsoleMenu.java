package lt.codeacademy.exercise.menu.console;

import lt.codeacademy.ConsolePrinter;
import lt.codeacademy.exercise.menu.Menu;

import static lt.codeacademy.exercise.menu.console.initialiser.ScannerInitializer.getScanner;

/**
 * Every console menu's should use this interface
 *
 * @author pavel.vrublevskij
 */
public interface ConsoleMenu extends Menu {

    /**
     * Method waits for user input and return @{@link String}
     *
     * @return String as input
     */
    default String readInput() {
        ConsolePrinter.print("Your input: ");

        return getScanner().nextLine();
    }

    default String printAndRead() {
        generateMenu();
        return readInput();
    }
}
