package lt.codeacademy;

import lt.codeacademy.model.Biudzetas;
import lt.codeacademy.utils.menu.NewDebitRecordMenu;
import lt.codeacademy.utils.menu.NewIncomeRecordMenu;
import lt.codeacademy.utils.reports.DebitReportTable;
import lt.codeacademy.utils.reports.IncomeReportTable;

import java.util.Scanner;

import static lt.codeacademy.utils.FileUtils.readBiudzetasFromFile;
import static lt.codeacademy.utils.FileUtils.saveBiudzetasToFile;
import static lt.codeacademy.utils.menu.MainMenuUtils.printBiudzetasLogo;
import static lt.codeacademy.utils.menu.MainMenuUtils.printMainMenu;
import static lt.codeacademy.utils.menu.MainMenuUtils.readUserInput;

/**
 * Interaktyvia programą, su kurios pagalba vartotojas turi galimybę pasirinkti ką įvesti (pajamas/išlaidas),
 * turi galimybe gauti reikiamą informaciją kiek išleido ir gavo pajamų.
 */
public class Programa {
    private static final Biudzetas BIUDZETAS;
    public static final Scanner SCANNER;
    private static final String FILE_PATH = "Data/data.dat";

    static {
        BIUDZETAS = readBiudzetasFromFile(FILE_PATH);

//        BIUDZETAS = BiudzetasFactory.generateBiudzetasMockObject();

        SCANNER = new Scanner(System.in);
    }

    public static void main(String[] args) {

        printBiudzetasLogo();

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
                new NewDebitRecordMenu().newDebitRecordMenu(BIUDZETAS);
                break;
            case "2":
                new NewIncomeRecordMenu().newIncomeRecordMenu(BIUDZETAS);
                break;
            case "3":
                new DebitReportTable().printTable(BIUDZETAS.gautiIslaiduIrasus());
                break;
            case "4":
                new IncomeReportTable().printTable(BIUDZETAS.gautiPajamuIrasus());
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
     * On program exit closes scanner and saves biudzetas to file
     */
    private static void shutDown() {
        SCANNER.close();
        saveBiudzetasToFile(BIUDZETAS, FILE_PATH);
    }
}
