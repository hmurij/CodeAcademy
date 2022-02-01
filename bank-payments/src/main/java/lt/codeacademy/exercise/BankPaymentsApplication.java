package lt.codeacademy.exercise;

import lt.codeacademy.exercise.menu.console.ConsoleMenu;
import lt.codeacademy.exercise.menu.console.MainMenu;

public class BankPaymentsApplication {

    private final ConsoleMenu mainMenu;

    public BankPaymentsApplication() {
        this.mainMenu = new MainMenu();
    }

    public void run() {
        String selectedOption = mainMenu.printAndRead();
        //TODO: your implementation here
    }
}
