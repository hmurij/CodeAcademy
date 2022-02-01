package lt.codeacademy.exercise.menu.console;

import static lt.codeacademy.ConsolePrinter.print;

public class MainMenu implements ConsoleMenu {

    private static final String MENU_TEXT =
            "=========== M A I N   M E N U ==========\n" +
                    "Please choose what you want to generate:\n" +
                    "[1] -> Read formatted \"LumiData\" payments \n" +
                    "[2] -> Read formatted \"SepData\" payments \n" +
                    "[3] -> Read formatted \"ShvedData\" payments \n" +
                    "[4] -> Show all banks payments (as table) \n" +
                    "[0] -> Exit";

    @Override
    public void generateMenu() {
        print(MENU_TEXT);
    }
}
