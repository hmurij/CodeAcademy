package lt.codeacademy.utils.menu;

import lt.codeacademy.budget.Budget;
import lt.codeacademy.model.DebitRecord;
import lt.codeacademy.utils.reports.DebitReportTableConsole;

import java.util.List;
import java.util.Optional;

import static lt.codeacademy.Program.SCANNER;

public class EditDebitRecordMenu {
    private final String MENU =
            "Pasirinkit redaguojamo iraso lauka: " +
                    "\n\t1 - Suma" +
                    "\n\t2 - Data" +
                    "\n\t3 - Laika" +
                    "\n\t4 - Kategorija" +
                    "\n\t5 - Atsiskaitymo bud" +
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
                new DebitReportTableConsole().printTable(List.of(debitRecord.get()));

                while (true) {
                    EDIT_MENU.printMenu();
                    processInput(EDIT_MENU.readUserInput());
                }

            } else {
                System.out.println("Nerastas irasas id: " + id + "\n");
            }

        } catch (NumberFormatException e) {
            System.out.println("Netinkamas parametras!\n");
        }

    }

    private void processInput(String input) {
        switch (input) {
            case "0":
                return;
        }
    }
}
