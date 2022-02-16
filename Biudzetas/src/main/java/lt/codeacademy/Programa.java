package lt.codeacademy;

import lt.codeacademy.model.Biudzetas;
import lt.codeacademy.model.IslaiduIrasas;
import lt.codeacademy.model.PajamuIrasas;
import lt.codeacademy.type.AtsiskaitymoBudas;
import lt.codeacademy.type.IslaiduKategorija;
import lt.codeacademy.type.PajamuKategorija;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Interaktyvia programą, su kurios pagalba vartotojas turi galimybę pasirinkti ką įvesti (pajamas/išlaidas),
 * turi galimybe gauti reikiamą informaciją kiek išleido ir gavo pajamų.
 */
public class Programa {

    private static Biudzetas biudzetas;
    private static final Scanner SCANNER;

    static {
        biudzetas = new Biudzetas();

//        biudzetas = BiudzetasFactory.generateBiudzetasMockObject();

        SCANNER = new Scanner(System.in);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("*************************************");
        System.out.println("* Interaktyvia programą - Biudzetas *");
        System.out.println("*************************************\n");

        while (true) {
            int choice;
            showMainMenu();

            try {
                choice = SCANNER.nextInt();

                if (0 > choice || choice > 4) {
                    throw new InputMismatchException();
                }


            } catch (InputMismatchException e) {
                System.out.println("Netinkamas parametras!\n");
                continue;
            }

            System.out.println("Jusu pasirinkimas: " + choice + "\n");
            processInput(choice);


            if (choice == 0) {
                System.out.println("Aciu uz demesi!");
                break;
            }
        }

        SCANNER.close();

        saveBiudzetasToFile();

    }


    /**
     * Processes user input
     *
     * @param choice int in range from 0 to 4
     */
    private static void processInput(int choice) {
        switch (choice) {
            case 1:
                newIslaiduIrasasMenu();
                break;
            case 2:
                newPajamuIrasasMenu();
                break;
            case 3:
                printIslaiduIrasus();
                break;
            case 4:
                printPajamuIrasus();

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

        biudzetas.pridetiIslaiduIrasa(new IslaiduIrasas(newSuma,
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

        biudzetas.pridetiPajamuIrasa(new PajamuIrasas(newSuma,
                newData,
                kategorijas[kategorija - 1],
                (pajamosBankeChoice == 1),
                info));

        System.out.println("\nSekmingai sukurtas naujas pajamu irasas.\n");

    }

    /**
     * Prints all PajamuIrasas records to console
     */
    private static void printPajamuIrasus() {
        PajamuIrasas[] pajamuIrasai = biudzetas.gautiPajamuIrasus();

        String separator = "+" + "-".repeat(11) + "+" + "-".repeat(21) + "+" + "-".repeat(16)
                + "+" + "-".repeat(21) + "+" + "-".repeat(31) + "+\n";

        System.out.print(separator);
        String format = "| %-10s| %-20s| %-15s| %-20s| %-30s|\n";
        System.out.printf(format, "Suma", "Data", "Kategorija", "Pajamos banke", "Informacija");
        System.out.print(separator);

        format = "| %-10.2f| %-20s| %-15s| %-20s| %-30s|\n";
        for (PajamuIrasas pajamuIrasas : pajamuIrasai) {
            String comment = pajamuIrasas.getPapildomaInfo();
            System.out.printf(format,
                    pajamuIrasas.getSuma(),
                    String.format("%1$tY-%1$tb-%1$td", pajamuIrasas.getData()),
                    pajamuIrasas.getKategorija(),
                    pajamuIrasas.isPozymisArIBanka() ? "Taip" : "Ne",
                    comment.length() > 25 ? comment.substring(0, 25) + "..." : comment);

        }
        System.out.print(separator);
        System.out.printf("Is viso: %5.2f\n", Arrays.stream(pajamuIrasai).filter(PajamuIrasas::isPozymisArIBanka)
                .mapToDouble(PajamuIrasas::getSuma).sum());

        System.out.println();

    }

    /**
     * Prints all IslaiduIrasas records to console
     */
    private static void printIslaiduIrasus() {
        IslaiduIrasas[] islaiduIrasai = biudzetas.gautiIslaiduIrasa();
        String separator = "+" + "-".repeat(11) + "+" + "-".repeat(21) + "+" + "-".repeat(16)
                + "+" + "-".repeat(21) + "+" + "-".repeat(31) + "+\n";

        System.out.print(separator);
        String format = "| %-10s| %-20s| %-15s| %-20s| %-30s|\n";
        System.out.printf(format, "Suma", "Data / laikas", "Kategorija", "Atsiskaitymo Budas", "Informacija");
        System.out.print(separator);

        format = "| %-10.2f| %-20s| %-15s| %-20s| %-30s|\n";
        for (IslaiduIrasas islaiduIrasas : islaiduIrasai) {
            String comment = islaiduIrasas.getPapildomaInfo();
            System.out.printf(format,
                    islaiduIrasas.getSuma(),
                    String.format("%1$tY-%1$tb-%1$td %1$tH:%1$tM", islaiduIrasas.getDataSuLaiku()),
                    islaiduIrasas.getKategorija(),
                    islaiduIrasas.getAtsiskaitymoBudas(),
                    comment.length() > 25 ? comment.substring(0, 25) + "..." : comment);
        }
        System.out.print(separator);

        System.out.printf("Is viso: %5.2f\n", Arrays.stream(islaiduIrasai).map(IslaiduIrasas::getSuma)
                .mapToDouble(Double::doubleValue).sum());
        System.out.println();
    }

    /**
     * Prints main menu to console
     */
    public static void showMainMenu() {
        System.out.print("Pasirinkit viena is varijantu: " +
                "\n\t1 - Ivesti nauja islaidu irasa" +
                "\n\t2 - Ivesti nauja pajamu irasa" +
                "\n\t3 - Atspausdinti visus islaidu irasus" +
                "\n\t4 - Atspasdinit visus pajamu irasus" +
                "\n\t0 - Iseiti" +
                "\nIveskit jusu pasirinkima: ");
    }



    /**
     * Reads {@link Biudzetas} object from file Data/data.dat
     */
    private static void readBiudzetasFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Data/data.dat"))) {
            biudzetas = (Biudzetas) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writed {@link Biudzetas} object to file Data/data.dat
     * @throws IOException in case of Data/data.dat file is missing.
     */
    private static void saveBiudzetasToFile() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Data/data.dat"))) {
            out.writeObject(biudzetas);
        }
    }
}
