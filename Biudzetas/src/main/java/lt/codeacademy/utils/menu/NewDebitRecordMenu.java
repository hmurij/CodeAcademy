package lt.codeacademy.utils.menu;

import lt.codeacademy.model.Biudzetas;
import lt.codeacademy.model.IslaiduIrasas;
import lt.codeacademy.type.AtsiskaitymoBudas;
import lt.codeacademy.type.IslaiduKategorija;

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
     * Prompts user to enter appropriate fields, creates new {@link IslaiduIrasas} object
     * and adds new record to biudzetas.
     */
    public void newDebitRecordMenu(Biudzetas biudzetas) {
        try {
            double newAmount = newAmountMenu();
            LocalDateTime newDateTime = newDateTimeMenu();
            IslaiduKategorija newDebitCategory = newDebitCategoryMenu();
            AtsiskaitymoBudas newPaymentType = newPaymentTypeMenu();
            String newComment = newCommentMenu();

            biudzetas.pridetiIslaiduIrasa(new IslaiduIrasas(newAmount,
                    newDateTime,
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
    private IslaiduKategorija newDebitCategoryMenu() {
        IslaiduKategorija[] categories = IslaiduKategorija.values();

        System.out.print("\nPasirinkit viena is islaidu kategoriju varijantu: ");
        for (int i = 0; i < categories.length; i++) {
            System.out.print("\n\t" + (i + 1) + " - " + categories[i].getKategorija());
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
    private AtsiskaitymoBudas newPaymentTypeMenu() {
        AtsiskaitymoBudas[] paymentType = AtsiskaitymoBudas.values();

        System.out.print("\nPasirinkit viena is atsiskaitymo budu:");
        for (int i = 0; i < paymentType.length; i++) {
            System.out.print("\n\t" + (i + 1) + " - " + paymentType[i].getAtsiskaitymoBudas());
        }

        System.out.print("\nIveskit jusu pasirinkima: ");
        int paymentTypeIndex = Integer.parseInt(SCANNER.nextLine());

        if (1 > paymentTypeIndex || paymentTypeIndex > paymentType.length) {
            throw new NumberFormatException();
        }

        return paymentType[paymentTypeIndex - 1];
    }
}
