package lt.codeacademy.utils.menu;

/**
 * Menu utility class to manage user interaction with main program
 */
public class MainMenu extends Menu {
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
                    "\n\t9 - Issaugoti duomenis" +
                    "\n\t0 - Iseiti" +
                    "\nIveskit jusu pasirinkima: ";

    public MainMenu() {
        super(MAIN_MENU);
    }

    /**
     * Prints main program logo
     */
    public void printBudgetLogo() {
        System.out.println(BUDGET_LOGO);
    }
}
