package lt.codeacademy;

import lt.codeacademy.generator.password.LetterPasswordGenerator;
import lt.codeacademy.generator.password.NaturalNumbersPasswordGenerator;
import lt.codeacademy.generator.password.NumbersLettersPasswordGenerator;
import lt.codeacademy.menu.ConsoleMenu;
import lt.codeacademy.menu.MainMenu;

import java.util.Scanner;

public class PasswordGeneratorApplication {

    public static final Scanner SCANNER;

    static {
        SCANNER = new Scanner(System.in);
    }

    private final ConsoleMenu mainMenu;

    public PasswordGeneratorApplication() {
        this.mainMenu = new MainMenu();
    }

    public void run() {

        while (true) {
            mainMenu.print();
            processInput(mainMenu.readInput());
        }

    }

    /**
     * Processes user input. Terminates program on user input "0"
     * @param input user input
     */
    private void processInput(String input) {
        switch(input){
            case "1":
                System.out.println("\nGenerated password: " + new NaturalNumbersPasswordGenerator().getPassword() + "\n");
                break;
            case "2":
                System.out.println("\nGenerated password: " + new LetterPasswordGenerator().getPassword() + "\n");
                break;
            case "3":
                System.out.println("\nGenerated password: " + new NumbersLettersPasswordGenerator().getPassword() + "\n");
                break;
            case "0":
                System.out.println("\nThank you for generating!");
                shutDown();
                break;
            default:
                System.out.println("\nInvalid parameter\n");
        }
    }

    /**
     * Closes SCANNER and exits application
     */
    private void shutDown() {
        SCANNER.close();
        System.exit(0);
    }
}
