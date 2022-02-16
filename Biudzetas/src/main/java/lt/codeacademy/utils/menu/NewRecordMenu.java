package lt.codeacademy.utils.menu;

import static lt.codeacademy.Programa.SCANNER;

public abstract class NewRecordMenu {

    /**
     * Prompts user to enter new amount, in case of illegal arguments
     * throws NumberFormatException
     *
     * @return new amount
     */
    protected double newAmountMenu() {
        System.out.print("Iveskit suma: ");
        String newAmount = SCANNER.nextLine();

        double amount = Double.parseDouble(newAmount);
        if (amount < 0) {
            throw new NumberFormatException();
        }

        return amount;
    }

    /**
     * Prompts user to enter new comment
     *
     * @return new comment
     */
    protected String newCommentMenu() {
        System.out.print("\nIveskit papildoma informacija: ");
        return SCANNER.nextLine();
    }
}
