package lt.codeacademy.exercise.menu.console;

import static lt.codeacademy.ConsolePrinter.print;

public class FilterByDateRangeMenu implements ConsoleMenu {
    private static final String MENU_TEXT =
            "=========== P R I N T  R E C O R D S  B Y  D A T E  R A N G E ==========\n" +
                    "Please enter date range in format \"start end\" (YYYY-MM-DD YYYY-MM-DD): ";

    @Override
    public void generateMenu() {
        print(MENU_TEXT);
    }
}
