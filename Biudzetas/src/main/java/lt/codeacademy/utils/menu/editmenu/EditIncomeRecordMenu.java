package lt.codeacademy.utils.menu.editmenu;

import lt.codeacademy.budget.Budget;
import lt.codeacademy.budget.entity.IncomeRecord;
import lt.codeacademy.utils.menu.newmenu.NewIncomeRecordMenu;
import lt.codeacademy.utils.reports.IncomeReportTableConsole;

import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

import static lt.codeacademy.Program.SCANNER;

public class EditIncomeRecordMenu extends NewIncomeRecordMenu {
    private final String MENU =
            "Pasirinkit redaguojamo iraso lauka: " +
                    "\n\t1 - Suma" +
                    "\n\t2 - Data" +
                    "\n\t3 - Kategorija" +
                    "\n\t4 - Pajamos banke" +
                    "\n\t5 - Informacija" +
                    "\n\t0 - Iseiti" +
                    "\nIveskit jusu pasirinkima: ";

    private final EditMenu EDIT_MENU = new EditMenu(MENU);

    /**
     * Prompts user to enter edit record id, if found prints record and
     * guides user through edit process.
     * @param budget budget object containing edit record
     */
    public void editDebitRecordMenu(Budget budget) {
        int id;
        try {
            System.out.print("Iveskyte redaguojamo iraso id: ");
            id = Integer.parseInt(SCANNER.nextLine());

            Optional<IncomeRecord> incomeRecord = budget.getRecordById(id, IncomeRecord.class);

            if (incomeRecord.isPresent()) {
                String input;
                IncomeRecord editRecord = incomeRecord.get();
                do {
                    new IncomeReportTableConsole().printTable(List.of(editRecord));
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

    /**
     * Processes user input
     * @param input user selected option
     * @param record edit record
     * @return user selected option
     */
    private String processInput(String input, IncomeRecord record) {
        try {
            switch (input) {
                case "1":
                    record.setAmount(newAmountMenu());
                    break;
                case "2":
                    record.setDate(newDateMenu());
                    break;
                case "3":
                    record.setIncomeType(newIncomeTypeMenu());
                    break;
                case "4":
                    record.setIncomeReceived(newIsPaymentReceivedMenu());
                    break;
                case "5":
                    record.setComments(newCommentMenu());
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
