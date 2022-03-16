package lt.codeacademy.utils.menu;

import lt.codeacademy.budget.Budget;

import static lt.codeacademy.Program.SCANNER;

public class DeleteRecordMenu {

    /**
     * Prompts user to enter id of record to be deleted.
     * If record exists it is deleted otherwise user informed that record with
     * provided id does not exist.
     * @param budget from which to delete record
     */
    public static void deleteRecordMenu(Budget budget){
        int id;
        try {
            System.out.print("Iveskit pasalinamo iraso id: ");
            id = Integer.parseInt(SCANNER.nextLine());
            boolean deleted = budget.deleteRecord(id);

            if (deleted) {
                System.out.println("Sekmingai pasalintas irasas id: " + id + "\n");
            } else {
                System.out.println("Nerastas irasas id: " + id + "\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Netinkamas parametras!\n");
        }
    }
}
