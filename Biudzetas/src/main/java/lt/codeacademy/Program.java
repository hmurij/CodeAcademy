package lt.codeacademy;

import lt.codeacademy.budget.Budget;
import lt.codeacademy.factory.BudgetFactory;
import lt.codeacademy.utils.menu.EditDebitRecordMenu;
import lt.codeacademy.utils.menu.EditIncomeRecordMenu;
import lt.codeacademy.utils.menu.MainMenu;
import lt.codeacademy.utils.menu.NewDebitRecordMenu;
import lt.codeacademy.utils.menu.NewIncomeRecordMenu;
import lt.codeacademy.utils.reports.DebitReportTableConsole;
import lt.codeacademy.utils.reports.IncomeReportTableConsole;

import java.util.Scanner;

import static lt.codeacademy.utils.FileUtils.saveBudgetToFile;
import static lt.codeacademy.utils.menu.CheckBalanceMenu.checkBalanceMenu;
import static lt.codeacademy.utils.menu.DeleteRecordMenu.deleteRecordMenu;

/**
 * Interaktyvia programą, su kurios pagalba vartotojas turi galimybę pasirinkti ką įvesti (pajamas/išlaidas),
 * turi galimybe gauti reikiamą informaciją kiek išleido ir gavo pajamų.
 */
public class Program {
    private static final Budget BUDGET;
    public static final Scanner SCANNER;
    private static final String FILE_PATH = "Data/data.dat";

    private static final MainMenu MAIN_MENU;

    static {
//        BUDGET = FileUtils.readBudgetFromFile(FILE_PATH);

        BUDGET = BudgetFactory.generateBudgetMockObject();

        SCANNER = new Scanner(System.in);

        MAIN_MENU = new MainMenu();
    }

    public static void main(String[] args) {

        MAIN_MENU.printBudgetLogo();

        while (true) {
            MAIN_MENU.printMenu();
            processInput(MAIN_MENU.readUserInput());
        }
    }

    /**
     * Processes user input, program terminates on user entering "0"
     *
     * @param input any String with valid input "1", "2", "3", "4", "0"
     */
    private static void processInput(String input) {
        switch (input) {
            case "1":
                new DebitReportTableConsole().printTable(BUDGET.getDebitRecords());
                break;
            case "2":
                new IncomeReportTableConsole().printTable(BUDGET.getIncomeRecords());
                break;
            case "3":
                new NewDebitRecordMenu().newDebitRecordMenu(BUDGET);
                break;
            case "4":
                new NewIncomeRecordMenu().newIncomeRecordMenu(BUDGET);
                break;
            case "5":
                new EditDebitRecordMenu().editDebitRecordMenu(BUDGET);
                break;
            case "6":
                new EditIncomeRecordMenu().editDebitRecordMenu(BUDGET);
                break;
            case "7":
                deleteRecordMenu(BUDGET);
                break;
            case "8":
                checkBalanceMenu(BUDGET);
                break;
            case "0":
                System.out.println("Aciu uz demesi!");
                shutDown();
                System.exit(0);
                break;
            default:
                System.out.println("Netinkamas parametras!\n");
                break;
        }
    }

    /**
     * On program exit closes scanner and saves budget to file
     */
    private static void shutDown() {
        SCANNER.close();
        saveBudgetToFile(BUDGET, FILE_PATH);
    }
}
