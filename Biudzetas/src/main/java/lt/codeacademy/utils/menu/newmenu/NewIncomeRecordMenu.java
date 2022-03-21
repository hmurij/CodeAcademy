package lt.codeacademy.utils.menu.newmenu;

import lt.codeacademy.budget.Budget;
import lt.codeacademy.budget.entity.DebitRecord;
import lt.codeacademy.budget.entity.IncomeRecord;
import lt.codeacademy.type.IncomeType;
import lt.codeacademy.type.ReceivedType;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static lt.codeacademy.Program.SCANNER;

/**
 * Utility class to manage user interactions, while entering
 * data for new income record
 */
public class NewIncomeRecordMenu extends NewRecordMenu {

    /**
     * Prompts user to enter appropriate fields, creates new {@link DebitRecord} object
     * and adds new record to budget.
     */
    public final void newIncomeRecordMenu(Budget budget) {
        try {
            double newAmount = newAmountMenu();
            LocalDate newDate = newDateMenu();
            IncomeType newIncomeCategory = newIncomeTypeMenu();
            boolean isReceived = newIsPaymentReceivedMenu();
            String newComment = newCommentMenu();

            budget.addRecord(
                    new IncomeRecord(newAmount,
                    newDate,
                    newIncomeCategory,
                    isReceived,
                    newComment)
            );

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
    protected LocalDate newDateMenu() {
        System.out.print("Iveskit data formatu (YYYY-MM-DD): ");

        return LocalDate.parse(SCANNER.nextLine());
    }

    /**
     * Prompts user select new income category, throws NumberFormatException
     * in case of invalid category index
     *
     * @return new income category
     */
    protected IncomeType newIncomeTypeMenu() {
        return newTypeMenu("Pasirinkit viena is pajamu kategoriju varijantu: ", IncomeType.values());
    }

    /**
     * Prompts user to select whether payment received
     * @return true if received, false otherwise
     */
    protected boolean newIsPaymentReceivedMenu() {
        return newTypeMenu(
                "Pajamos banke, pasirinkit viena is varijantu: ",
                ReceivedType.values()
        ).getType().equals("Taip");
    }
}
