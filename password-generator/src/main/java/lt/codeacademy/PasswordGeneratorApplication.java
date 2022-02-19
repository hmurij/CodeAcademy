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
                System.out.println(new NaturalNumbersPasswordGenerator().getPassword());
                break;
            case "2":
                System.out.println(new LetterPasswordGenerator().getPassword());
                break;
            case "3":
                System.out.println(new NumbersLettersPasswordGenerator().getPassword());
                break;
            case "0":
                System.out.println("Bye");
                SCANNER.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid parameter");
        }
    }
}
