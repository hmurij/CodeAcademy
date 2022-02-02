package lt.codeacademy.exercise.menu.console;

import static lt.codeacademy.ConsolePrinter.print;

public class FilterByDateMenu implements ConsoleMenu {
    private static final String MENU_TEXT =
            "=========== P R I N T  R E C O R D S  B Y  D A T E ==========\n" +
                    "Please enter date format (YYYY-MM-DD): ";

    @Override
    public void generateMenu() {
        print(MENU_TEXT);
    }
}
