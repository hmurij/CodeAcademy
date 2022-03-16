package lt.codeacademy.utils.menu;

import static lt.codeacademy.Program.SCANNER;

public abstract class Menu {
    private final String MENU;

    public Menu(String menu) {
        this.MENU = menu;
    }

    /**
     * Prints main menu to console
     */
    public void printMenu(){
        System.out.print(MENU);
    }

    /**
     * Reads user input
     * @return user input
     */
    public String readUserInput(){
        String choice = SCANNER.nextLine();
        System.out.println();
        return choice;
    }
}
