package lt.codeacademy.exercise.menu.console;

import static lt.codeacademy.ConsolePrinter.print;

public class BankReportMenu implements ConsoleMenu {

    private static final String MENU_TEXT =
            "=========== P R I N T  B A N K  R E C O R D S ==========\n" +
            "Please enter bank name: ";

    @Override
    public void generateMenu() {
        print(MENU_TEXT);
    }
}
