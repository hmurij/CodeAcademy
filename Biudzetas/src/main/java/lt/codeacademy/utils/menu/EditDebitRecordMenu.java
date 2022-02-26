package lt.codeacademy.utils.menu;

import lt.codeacademy.budget.Budget;
import lt.codeacademy.model.DebitRecord;
import lt.codeacademy.utils.reports.DebitReportTableConsole;

import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

import static lt.codeacademy.Program.SCANNER;

public class EditDebitRecordMenu extends NewDebitRecordMenu {
    private final String MENU =
            "Pasirinkit redaguojamo iraso lauka: " +
                    "\n\t1 - Suma" +
                    "\n\t2 - Data" +
                    "\n\t3 - Laika" +
                    "\n\t4 - Kategorija" +
                    "\n\t5 - Atsiskaitymo buda" +
                    "\n\t6 - Informacija" +
                    "\n\t0 - Iseiti" +
                    "\nIveskit jusu pasirinkima: ";

    private final EditMenu EDIT_MENU = new EditMenu(MENU);

    public void editDebitRecordMenu(Budget budget){
        int id;
        try {
            System.out.print("Iveskyte redaguojamo iraso id: ");
            id = Integer.parseInt(SCANNER.nextLine());

            Optional<DebitRecord> debitRecord = budget.getRecordById(id, DebitRecord.class);

            if (debitRecord.isPresent()) {
                String input;
                DebitRecord editRecord = debitRecord.get();
                do {
                    new DebitReportTableConsole().printTable(List.of(editRecord));
                    EDIT_MENU.printMenu();
                    input = processInput(EDIT_MENU.readUserInput(), editRecord);
                } while (!input.equals("0"));

            } else {
                System.out.println("Nerastas irasas id: " + id + "\n");
            }

        } catch (NumberFormatException e) {
            System.out.println("Netinkamas parametras!\n");
        }
    }

    private String processInput(String input, DebitRecord record) {
        try {
            switch (input) {
                case "1":
                    record.setAmount(newAmountMenu());
                    break;
                case "0":
                    break;
                default:
                    throw new NumberFormatException();
            }
        } catch (NumberFormatException | DateTimeParseException e) {
            System.out.println("Netinkamas parametras!\n");
        } finally {
            return input;
        }
    }
}
