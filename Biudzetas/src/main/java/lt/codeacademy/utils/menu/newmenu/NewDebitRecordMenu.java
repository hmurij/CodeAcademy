package lt.codeacademy.utils.menu.newmenu;

import lt.codeacademy.budget.Budget;
import lt.codeacademy.budget.entity.DebitRecord;
import lt.codeacademy.type.PaymentType;
import lt.codeacademy.type.DebitType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static lt.codeacademy.Program.SCANNER;

/**
 * Utility class to manage user interactions, while entering
 * data for new debit record
 */
public class NewDebitRecordMenu extends NewRecordMenu {

    /**
     * Prompts user to enter appropriate fields, creates new {@link DebitRecord} object
     * and adds new record to budget.
     */
    public final void newDebitRecordMenu(Budget budget) {
        try {
            double newAmount = newAmountMenu();
            LocalDateTime newDateTime = newDateTimeMenu();
            DebitType newDebitCategory = newDebitCategoryMenu();
            PaymentType newPaymentType = newPaymentTypeMenu();
            String newComment = newCommentMenu();

            budget.addRecord(
                    new DebitRecord(newAmount,
                    newDateTime.toLocalDate(),
                    newDateTime.toLocalTime(),
                    newDebitCategory,
                    newPaymentType,
                    newComment)
            );

            System.out.println("\nSekmingai sukurtas naujas islaidu irasas.\n");
        } catch (NumberFormatException | DateTimeParseException e) {
            System.out.println("Netinkamas parametras!\n");
        }
    }

    /**
     * Prompts user to enter new date and time in format YYYY-MM-DD HH:MM,
     * throws DateTimeParseException – if date and time cannot be parsed
     *
     * @return new date and time
     */
    protected LocalDateTime newDateTimeMenu() {
        System.out.print("Iveskit data ir laika formatu (YYYY-MM-DD HH:MM): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return LocalDateTime.parse(SCANNER.nextLine(), formatter);
    }

    /**
     * Prompts user select new debit category, throws NumberFormatException
     * in case of invalid category index
     *
     * @return new debit category
     */
    protected DebitType newDebitCategoryMenu() {
        return newTypeMenu("Pasirinkit viena is islaidu kategoriju varijantu: ", DebitType.values());
    }

    /**
     * Prompts user select new payment type, throws NumberFormatException
     * in case of invalid payment type index
     *
     * @return new payment type
     */
    protected PaymentType newPaymentTypeMenu() {
        return newTypeMenu("Pasirinkit viena is atsiskaitymo budu:", PaymentType.values());
    }
}
