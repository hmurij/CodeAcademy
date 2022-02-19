package lt.codeacademy.utils.menu;

import lt.codeacademy.budget.Budget;
import lt.codeacademy.model.DebitRecord;
import lt.codeacademy.model.IncomeRecord;
import lt.codeacademy.type.IncomeType;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static lt.codeacademy.Programa.SCANNER;

/**
 * Utility class to manage user interactions, while entering
 * data for new income record
 */
public class NewIncomeRecordMenu extends NewRecordMenu {

    /**
     * Prompts user to enter appropriate fields, creates new {@link DebitRecord} object
     * and adds new record to budget.
     */
    public void newIncomeRecordMenu(Budget budget) {
        try {
            double newAmount = newAmountMenu();
            LocalDate newDate = newDateMenu();
            IncomeType newIncomeCategory = newIncomeTypeMenu();
            boolean isReceived = newIsPaymentReceivedMenu();
            String newComment = newCommentMenu();

            budget.addIncomeRecord(new IncomeRecord(newAmount,
                    newDate,
                    newIncomeCategory,
                    isReceived,
                    newComment));

            System.out.println("\nSekmingai sukurtas naujas pajamu irasas.\n");
        } catch (NumberFormatException | DateTimeParseException e) {
            System.out.println("Netinkamas parametras!\n");
        }
    }

    /**
     * Prompts user to enter new date in format YYYY-MM-DD,
     * throws DateTimeParseException – if date and time cannot be parsed
     *
     * @return new date
     */
    private LocalDate newDateMenu() {
        System.out.print("Iveskit data formatu (YYYY-MM-DD): ");

        return LocalDate.parse(SCANNER.nextLine());
    }

    /**
     * Prompts user select new income category, throws NumberFormatException
     * in case of invalid category index
     *
     * @return new income category
     */
    private IncomeType newIncomeTypeMenu() {
        IncomeType[] incomeTypes = IncomeType.values();

        System.out.print("\nPasirinkit viena is pajamu kategoriju varijantu: ");
        for (int i = 0; i < incomeTypes.length; i++) {
            System.out.print("\n\t" + (i + 1) + " - " + incomeTypes[i].getType());
        }
        System.out.print("\nIveskit jusu pasirinkima: ");

        int incomeTypeIndex = Integer.parseInt(SCANNER.nextLine());
        if (1 > incomeTypeIndex || incomeTypeIndex > incomeTypes.length) {
            throw new NumberFormatException();
        }

        return incomeTypes[incomeTypeIndex - 1];
    }

    /**
     * Prompts user to select whether payment received
     * @return true if received, false otherwise
     */
    private boolean newIsPaymentReceivedMenu() {
        System.out.print("\nPajamos banke, pasirinkit viena is varijantu: " +
                "\n\t 1 - Taip" +
                "\n\t 2 - Ne" +
                "\nIveskit jusu pasirinkima: ");

        int isPaymentReceived = Integer.parseInt(SCANNER.nextLine());
        if (1 > isPaymentReceived || isPaymentReceived > 2) {
            throw new NumberFormatException();
        }

        return isPaymentReceived == 1;
    }
}
