package lt.codeacademy.utils.menu;

import lt.codeacademy.budget.Budget;

import static lt.codeacademy.Program.SCANNER;

public class EditDebitRecordMenu {

    public void editDebitRecordMenu(Budget budget){
        int id;
        try {
            System.out.println("Iveskyte redaguojamo iraso id: ");
            id = Integer.parseInt(SCANNER.nextLine());

//            DebitRecord debitRecord = budget.getRecordById(id).



        } catch (NumberFormatException e) {
            System.out.println("Netinkamas parametras!\n");
        }

    }
}
