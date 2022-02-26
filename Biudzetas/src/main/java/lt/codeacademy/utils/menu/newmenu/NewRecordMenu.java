package lt.codeacademy.utils.menu.newmenu;

import lt.codeacademy.type.Type;

import static lt.codeacademy.Program.SCANNER;

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
     * Prompts user select new type, throws NumberFormatException
     * in case of invalid type index
     *
     * @return new type
     */
    protected <T extends Type> T newTypeMenu(String prompt, T[] types) {
        System.out.print(prompt);

        printTypes(types);

        System.out.print("\nIveskit jusu pasirinkima: ");
        int typeIndex = Integer.parseInt(SCANNER.nextLine());

        if (1 > typeIndex || typeIndex > types.length) {
            throw new NumberFormatException();
        }

        return types[typeIndex - 1];
    }

    protected <T extends Type> void printTypes(T[] types) {
        for (int i = 0; i < types.length; i++) {
            System.out.print("\n\t" + (i + 1) + " - " + types[i].getType());
        }
    }

    /**
     * Prompts user to enter new comment
     *
     * @return new comment
     */
    protected String newCommentMenu() {
        System.out.print("Iveskit papildoma informacija: ");
        return SCANNER.nextLine();
    }
}
