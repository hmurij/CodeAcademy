package lt.codeacademy.utils.menu;

import static lt.codeacademy.Program.SCANNER;

/**
 * Menu utility class to manage user interaction with main program
 */
public class MainMenu {
    private static final String BUDGET_LOGO =
            "*************************************\n" +
                    "* Interaktyvia programą - Biudzetas *\n" +
                    "*************************************\n";

    private static final String MAIN_MENU =
            "Pasirinkit viena is varijantu: " +
                    "\n\t1 - Atspausdinti visus islaidu irasus" +
                    "\n\t2 - Atspasdinit visus pajamu irasus" +
                    "\n\t3 - Ivesti nauja islaidu irasa" +
                    "\n\t4 - Ivesti nauja pajamu irasa" +
                    "\n\t5 - Redaguoti islaidu irasa" +
                    "\n\t6 - Redaguoti pajamu irasa" +
                    "\n\t7 - Pasalinti irasa" +
                    "\n\t8 - Pasitikrinti balansa" +
                    "\n\t0 - Iseiti" +
                    "\nIveskit jusu pasirinkima: ";


    /**
     * Prints main program logo
     */
    public static void printBudgetLogo() {
        System.out.println(BUDGET_LOGO);
    }

    /**
     * Prints main menu to console
     */
    public static void printMainMenu() {
        System.out.print(MAIN_MENU);
    }

    public static String readUserInput(){
        String choice = SCANNER.nextLine();
        System.out.println("Jusu pasirinkimas: " + choice + "\n");
        return choice;
    }
}
