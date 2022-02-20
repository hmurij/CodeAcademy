package lt.codeacademy;

import lt.codeacademy.budget.Budget;
import lt.codeacademy.factory.BudgetFactory;
import lt.codeacademy.utils.menu.CheckBalanceMenu;
import lt.codeacademy.utils.menu.NewDebitRecordMenu;
import lt.codeacademy.utils.menu.NewIncomeRecordMenu;
import lt.codeacademy.utils.reports.DebitReportTableConsole;
import lt.codeacademy.utils.reports.IncomeReportTableConsole;

import java.util.Scanner;

import static lt.codeacademy.utils.FileUtils.saveBudgetToFile;
import static lt.codeacademy.utils.menu.MainMenu.printBudgetLogo;
import static lt.codeacademy.utils.menu.MainMenu.printMainMenu;
import static lt.codeacademy.utils.menu.MainMenu.readUserInput;

/**
 * Interaktyvia programą, su kurios pagalba vartotojas turi galimybę pasirinkti ką įvesti (pajamas/išlaidas),
 * turi galimybe gauti reikiamą informaciją kiek išleido ir gavo pajamų.
 */
public class Programa {
    private static final Budget BUDGET;
    public static final Scanner SCANNER;
    private static final String FILE_PATH = "Data/data.dat";

    static {
//        BUDGET = FileUtils.readBudgetFromFile(FILE_PATH);

        BUDGET = BudgetFactory.generateBudgetMockObject();

        SCANNER = new Scanner(System.in);
    }

    public static void main(String[] args) {

        printBudgetLogo();

        while (true) {
            printMainMenu();

            processInput(readUserInput());
        }
    }

    /**
     * Processes user input, program terminates on user entering "0"
     *
     * @param choice any String with valid input "1", "2", "3", "4", "0"
     */
    private static void processInput(String choice) {
        switch (choice) {
            case "1":
                new NewDebitRecordMenu().newDebitRecordMenu(BUDGET);
                break;
            case "2":
                new NewIncomeRecordMenu().newIncomeRecordMenu(BUDGET);
                break;
            case "3":
                new DebitReportTableConsole().printTable(BUDGET.getDebitRecords());
                break;
            case "4":
                new IncomeReportTableConsole().printTable(BUDGET.getIncomeRecords());
                break;
            case "5":
                new CheckBalanceMenu().checkBalance(BUDGET);
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
