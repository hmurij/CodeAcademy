package lt.codeacademy.initial;

import lt.codeacademy.initial.generator.password.LetterPasswordGenerator;
import lt.codeacademy.initial.generator.password.NaturalNumbersPasswordGenerator;
import lt.codeacademy.initial.generator.password.NumbersLettersPasswordGenerator;
import lt.codeacademy.initial.menu.ConsoleMenu;
import lt.codeacademy.initial.menu.MainMenu;

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
