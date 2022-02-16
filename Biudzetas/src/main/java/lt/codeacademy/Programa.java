package lt.codeacademy;

import lt.codeacademy.model.Biudzetas;
import lt.codeacademy.model.IslaiduIrasas;
import lt.codeacademy.model.PajamuIrasas;
import lt.codeacademy.type.AtsiskaitymoBudas;
import lt.codeacademy.type.IslaiduKategorija;
import lt.codeacademy.type.PajamuKategorija;
import lt.codeacademy.utils.reports.DebitReportTable;
import lt.codeacademy.utils.reports.IncomeReportTable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static lt.codeacademy.utils.FileUtils.readBiudzetasFromFile;
import static lt.codeacademy.utils.FileUtils.saveBiudzetasToFile;
import static lt.codeacademy.utils.MainMenuUtils.printBiudzetasLogo;
import static lt.codeacademy.utils.MainMenuUtils.printMainMenu;
import static lt.codeacademy.utils.MainMenuUtils.readUserInput;

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

//        biudzetas = BiudzetasFactory.generateBiudzetasMockObject();

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
                newIslaiduIrasasMenu();
                break;
            case "2":
                newPajamuIrasasMenu();
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
     * Prompts user to enter appropriate fields, creates new {@link IslaiduIrasas} object
     * and adds new record to biudzetas.
     */
    private static void newIslaiduIrasasMenu() {
        double newSuma;
        LocalDateTime newDataLaikas;
        IslaiduKategorija[] kategorijas = IslaiduKategorija.values();
        int kategorija;
        AtsiskaitymoBudas[] atsiskaitymoBudai = AtsiskaitymoBudas.values();
        int atsiskaitymoBudas;
        String info;

        try {
            System.out.print("Iveskit islaidu suma: ");
            newSuma = SCANNER.nextDouble();
            if (newSuma < 0) {
                throw new InputMismatchException();
            }
            SCANNER.nextLine();

            System.out.print("\nIveskit data ir laika formatu (YYYY-MM-DD HH:MM): ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            newDataLaikas = LocalDateTime.parse(SCANNER.nextLine(), formatter);

            System.out.print("\nPasirinkit viena is islaidu kategoriju varijantu: ");
            for (int i = 0; i < kategorijas.length; i++) {
                System.out.print("\n\t" + (i + 1) + " - " + kategorijas[i].getKategorija());
            }
            System.out.print("\nIveskit jusu pasirinkima: ");
            kategorija = SCANNER.nextInt();
            if (1 > kategorija || kategorija > kategorijas.length) {
                throw new InputMismatchException();
            }
            SCANNER.nextLine();

            System.out.print("\nPasirinkit viena is atsiskaitymo budu:");
            for (int i = 0; i < atsiskaitymoBudai.length; i++) {
                System.out.print("\n\t" + (i + 1) + " - " + atsiskaitymoBudai[i].getAtsiskaitymoBudas());
            }
            System.out.print("\nIveskit jusu pasirinkima: ");
            atsiskaitymoBudas = SCANNER.nextInt();
            if (1 > atsiskaitymoBudas || atsiskaitymoBudas > atsiskaitymoBudai.length) {
                throw new InputMismatchException();
            }
            SCANNER.nextLine();

            System.out.print("\nIveskit papildoma informacija: ");
            info = SCANNER.nextLine();


        } catch (InputMismatchException e) {
            System.out.println("Netinkamas parametras!\n");
            SCANNER.nextLine();
            return;
        } catch (DateTimeParseException e) {
            System.out.println("Netinkamas parametras!\n");
            return;
        }

        BIUDZETAS.pridetiIslaiduIrasa(new IslaiduIrasas(newSuma,
                newDataLaikas,
                kategorijas[kategorija - 1],
                atsiskaitymoBudai[atsiskaitymoBudas - 1],
                info));

        System.out.println("\nSekmingai sukurtas naujas islaidu irasas.\n");
    }

    /**
     * Prompts user to enter appropriate fields, creates new {@link PajamuIrasas} object
     * and adds new record to biudzetas.
     */
    private static void newPajamuIrasasMenu() {

        double newSuma;
        LocalDate newData;
        PajamuKategorija[] kategorijas = PajamuKategorija.values();
        int kategorija;
        int pajamosBankeChoice;
        String info;


        try {
            System.out.print("Iveskit pajamu suma: ");
            newSuma = SCANNER.nextDouble();
            if (newSuma < 0) {
                throw new InputMismatchException();
            }
            SCANNER.nextLine();

            System.out.print("\nIveskit data formatu (YYYY-MM-DD): ");
            newData = LocalDate.parse(SCANNER.nextLine());

            System.out.print("\nPasirinkit viena is pajamu kategoriju varijantu: " +
                    "\n\t 1 - Atlyginimas" +
                    "\n\t 2 - Ismokos" +
                    "\n\t 3 - Socialinė parama" +
                    "\n\t 4 - Honoraras" +
                    "\n\t 5 - Nedarbinės pajamos" +
                    "\n\t 6 - Renta" +
                    "\nIveskit jusu pasirinkima: ");
            kategorija = SCANNER.nextInt();
            if (1 > kategorija || kategorija > 6) {
                throw new InputMismatchException();
            }
            SCANNER.nextLine();

            System.out.print("\nPajamos banke, pasirinkit viena is varijantu: " +
                    "\n\t 1 - Taip" +
                    "\n\t 2 - Ne" +
                    "\nIveskit jusu pasirinkima: ");
            pajamosBankeChoice = SCANNER.nextInt();
            if (1 > pajamosBankeChoice || pajamosBankeChoice > 2) {
                throw new InputMismatchException();
            }
            SCANNER.nextLine();

            System.out.print("\nIveskit papildoma informacija: ");
            info = SCANNER.nextLine();


        } catch (InputMismatchException e) {
            System.out.println("Netinkamas parametras!\n");
            SCANNER.nextLine();
            return;
        } catch (DateTimeParseException e) {
            System.out.println("Netinkamas parametras!\n");
            return;
        }

        BIUDZETAS.pridetiPajamuIrasa(new PajamuIrasas(newSuma,
                newData,
                kategorijas[kategorija - 1],
                (pajamosBankeChoice == 1),
                info));

        System.out.println("\nSekmingai sukurtas naujas pajamu irasas.\n");

    }

    private static void shutDown() {
        SCANNER.close();
        saveBiudzetasToFile(BIUDZETAS, FILE_PATH);
    }

}
