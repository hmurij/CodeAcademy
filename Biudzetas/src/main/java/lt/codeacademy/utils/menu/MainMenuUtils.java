package lt.codeacademy.utils.menu;

import static lt.codeacademy.Programa.SCANNER;

/**
 * Menu utility class to manage user interaction with main program
 */
public class MainMenuUtils {
    private static final String BIUDZETAS_LOGO =
            "*************************************\n" +
                    "* Interaktyvia programą - Biudzetas *\n" +
                    "*************************************\n";

    private static final String MAIN_MENU =
            "Pasirinkit viena is varijantu: " +
                    "\n\t1 - Ivesti nauja islaidu irasa" +
                    "\n\t2 - Ivesti nauja pajamu irasa" +
                    "\n\t3 - Atspausdinti visus islaidu irasus" +
                    "\n\t4 - Atspasdinit visus pajamu irasus" +
                    "\n\t0 - Iseiti" +
                    "\nIveskit jusu pasirinkima: ";


    /**
     * Prints main program logo
     */
    public static void printBiudzetasLogo() {
        System.out.println(BIUDZETAS_LOGO);
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
