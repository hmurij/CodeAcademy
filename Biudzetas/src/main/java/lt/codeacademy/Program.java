package lt.codeacademy;

import lt.codeacademy.budget.Budget;
import lt.codeacademy.model.Record;
import lt.codeacademy.utils.FileUtils;
import lt.codeacademy.utils.HibernateUtils;
import lt.codeacademy.utils.menu.MainMenu;
import lt.codeacademy.utils.menu.editmenu.EditDebitRecordMenu;
import lt.codeacademy.utils.menu.editmenu.EditIncomeRecordMenu;
import lt.codeacademy.utils.menu.newmenu.NewDebitRecordMenu;
import lt.codeacademy.utils.menu.newmenu.NewIncomeRecordMenu;
import lt.codeacademy.utils.reports.DebitReportTableConsole;
import lt.codeacademy.utils.reports.IncomeReportTableConsole;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lt.codeacademy.utils.menu.CheckBalanceMenu.checkBalanceMenu;
import static lt.codeacademy.utils.menu.DeleteRecordMenu.deleteRecordMenu;

/**
 * Interaktyvia programą, su kurios pagalba vartotojas turi galimybę pasirinkti ką įvesti (pajamas/išlaidas),
 * turi galimybe gauti reikiamą informaciją kiek išleido ir gavo pajamų.
 */
public class Program {
    public static final Scanner SCANNER;
    public static final SessionFactory SESSION_FACTORY = HibernateUtils.getSessionFactory();
    private static final String FILE_PATH = "Data/data.csv";
    private static final MainMenu MAIN_MENU;

    private static final Budget Budget = new Budget(FileUtils.readData(FILE_PATH));
//    private static final Budget Budget = BudgetFactory.generateBudgetMockObject();

    static {
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
                new DebitReportTableConsole().printTable(Budget.getDebitRecords());
                break;
            case "2":
                new IncomeReportTableConsole().printTable(Budget.getIncomeRecords());
                break;
            case "3":
                new NewDebitRecordMenu().newDebitRecordMenu(Budget);
                break;
            case "4":
                new NewIncomeRecordMenu().newIncomeRecordMenu(Budget);
                break;
            case "5":
                new EditDebitRecordMenu().editDebitRecordMenu(Budget);
                break;
            case "6":
                new EditIncomeRecordMenu().editDebitRecordMenu(Budget);
                break;
            case "7":
                deleteRecordMenu(Budget);
                break;
            case "8":
                checkBalanceMenu(Budget);
                break;
            case "9":
                saveData();
                System.out.println("Duomenis issaugoti\n");
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

    private static void saveData() {
        List<Record> records = Stream.of(Budget.getDebitRecords(), Budget.getIncomeRecords())
                .flatMap(List::stream).collect(Collectors.toList());
        FileUtils.saveData(records, FILE_PATH);
    }

    /**
     * On program exit closes scanner and saves budget to file
     */
    private static void shutDown() {
        SCANNER.close();
        saveData();
    }
}
