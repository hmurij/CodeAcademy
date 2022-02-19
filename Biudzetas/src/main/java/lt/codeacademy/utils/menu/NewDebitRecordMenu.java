package lt.codeacademy.utils.menu;

import lt.codeacademy.budget.Budget;
import lt.codeacademy.model.DebitRecord;
import lt.codeacademy.type.PaymentType;
import lt.codeacademy.type.DebitType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static lt.codeacademy.Programa.SCANNER;

/**
 * Utility class to manage user interactions, while entering
 * data for new debit record
 */
public class NewDebitRecordMenu extends NewRecordMenu{

    /**
     * Prompts user to enter appropriate fields, creates new {@link DebitRecord} object
     * and adds new record to budget.
     */
    public void newDebitRecordMenu(Budget budget) {
        try {
            double newAmount = newAmountMenu();
            LocalDateTime newDateTime = newDateTimeMenu();
            DebitType newDebitCategory = newDebitCategoryMenu();
            PaymentType newPaymentType = newPaymentTypeMenu();
            String newComment = newCommentMenu();

            budget.addDebitRecord(new DebitRecord(newAmount,
                    newDateTime.toLocalDate(),
                    newDateTime.toLocalTime(),
                    newDebitCategory,
                    newPaymentType,
                    newComment));

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
    private LocalDateTime newDateTimeMenu() {
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
    private DebitType newDebitCategoryMenu() {
        DebitType[] categories = DebitType.values();

        System.out.print("\nPasirinkit viena is islaidu kategoriju varijantu: ");
        for (int i = 0; i < categories.length; i++) {
            System.out.print("\n\t" + (i + 1) + " - " + categories[i].getType());
        }

        System.out.print("\nIveskit jusu pasirinkima: ");
        int debitCategoryIndex = Integer.parseInt(SCANNER.nextLine());

        if (1 > debitCategoryIndex || debitCategoryIndex > categories.length) {
            throw new NumberFormatException();
        }

        return categories[debitCategoryIndex - 1];
    }

    /**
     * Prompts user select new payment type, throws NumberFormatException
     * in case of invalid payment type index
     *
     * @return new payment type
     */
    private PaymentType newPaymentTypeMenu() {
        PaymentType[] paymentType = PaymentType.values();

        System.out.print("\nPasirinkit viena is atsiskaitymo budu:");
        for (int i = 0; i < paymentType.length; i++) {
            System.out.print("\n\t" + (i + 1) + " - " + paymentType[i].getType());
        }

        System.out.print("\nIveskit jusu pasirinkima: ");
        int paymentTypeIndex = Integer.parseInt(SCANNER.nextLine());

        if (1 > paymentTypeIndex || paymentTypeIndex > paymentType.length) {
            throw new NumberFormatException();
        }

        return paymentType[paymentTypeIndex - 1];
    }
}
