package lt.codeacademy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Interaktyvia programą, su kurios pagalba vartotojas turi galimybę pasirinkti ką įvesti (pajamas/išlaidas),
 * turi galimybe gauti reikiamą informaciją kiek išleido ir gavo pajamų.
 */
public class Programa {

    private static Biudzetas biudzetas;
    private static Scanner sc;

    static {
        biudzetas = new Biudzetas();

        for (int i = 0; i < 10; i++) {
            biudzetas.pridetiIslaiduIrasa(generateIslaiduIrasas());
            biudzetas.pridetiPajamuIrasa(generatePajamuData());
        }

        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        System.out.println("*************************************");
        System.out.println("* Interaktyvia programą - Biudzetas *");
        System.out.println("*************************************\n");

        while (true) {
            int choice;
            showMainMenu();

            try {
                choice = sc.nextInt();

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

        sc.close();
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
            newSuma = sc.nextDouble();
            if (newSuma < 0) {
                throw new InputMismatchException();
            }
            sc.nextLine();

            System.out.print("\nIveskit data ir laika formatu (YYYY-MM-DD HH:MM): ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            newDataLaikas = LocalDateTime.parse(sc.nextLine(), formatter);

            System.out.print("\nPasirinkit viena is islaidu kategoriju varijantu: ");
            for (int i = 0; i < kategorijas.length; i++) {
                System.out.print("\n\t" + (i + 1) + " - " + kategorijas[i].getKategorija());
            }
            System.out.print("\nIveskit jusu pasirinkima: ");
            kategorija = sc.nextInt();
            if (1 > kategorija || kategorija > kategorijas.length) {
                throw new InputMismatchException();
            }
            sc.nextLine();

            System.out.print("\nPasirinkit viena is atsiskaitymo budu:");
            for (int i = 0; i < atsiskaitymoBudai.length; i++) {
                System.out.print("\n\t" + (i + 1) + " - " + atsiskaitymoBudai[i].getAtsiskaitymoBudas());
            }
            System.out.print("\nIveskit jusu pasirinkima: ");
            atsiskaitymoBudas = sc.nextInt();
            if (1 > atsiskaitymoBudas || atsiskaitymoBudas > atsiskaitymoBudai.length) {
                throw new InputMismatchException();
            }
            sc.nextLine();

            System.out.print("\nIveskit papildoma informacija: ");
            info = sc.nextLine();


        } catch (InputMismatchException e) {
            System.out.println("Netinkamas parametras!\n");
            sc.nextLine();
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
        System.out.println();
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
            System.out.print("Iveskit islaidu suma: ");
            newSuma = sc.nextDouble();
            if (newSuma < 0) {
                throw new InputMismatchException();
            }
            sc.nextLine();

            System.out.print("\nIveskit data formatu (YYYY-MM-DD): ");
            newData = LocalDate.parse(sc.nextLine());

            System.out.print("\nPasirinkit viena is pajamu kategoriju varijantu: " +
                    "\n\t 1 - Atlyginimas" +
                    "\n\t 2 - Ismokos" +
                    "\n\t 3 - Socialinė parama" +
                    "\n\t 4 - Honoraras" +
                    "\n\t 5 - Nedarbinės pajamos" +
                    "\n\t 6 - Renta" +
                    "\nIveskit jusu pasirinkima: ");
            kategorija = sc.nextInt();
            if (1 > kategorija || kategorija > 6) {
                throw new InputMismatchException();
            }
            sc.nextLine();

            System.out.print("\nPajamos banke, pasirinkit viena is varijantu: " +
                    "\n\t 1 - Taip" +
                    "\n\t 2 - Ne" +
                    "\nIveskit jusu pasirinkima: ");
            pajamosBankeChoice = sc.nextInt();
            if (1 > pajamosBankeChoice || pajamosBankeChoice > 2) {
                throw new InputMismatchException();
            }
            sc.nextLine();

            System.out.print("\nIveskit papildoma informacija: ");
            info = sc.nextLine();


        } catch (InputMismatchException e) {
            System.out.println("Netinkamas parametras!\n");
            sc.nextLine();
            return;
        } catch (DateTimeParseException e) {
            System.out.println("Netinkamas parametras!\n");
            return;
        }

//        System.out.println("newSuma: " + newSuma);
//        System.out.println("newData: " + newData);
//        System.out.println("kategorija: " + kategorijas[kategorija - 1]);
//        System.out.println("pajamosBanke: " + (pajamosBankeChoice == 1 ? "Taip" : "Ne"));
//        System.out.println("info: " + info);
//        System.out.println();

        biudzetas.pridetiPajamuIrasa(new PajamuIrasas(newSuma,
                newData,
                kategorijas[kategorija - 1],
                (pajamosBankeChoice == 1),
                info));

        System.out.println();

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
     * Generates random IslaiduIrasas object
     *
     * @return random IslaiduIrasas object
     */
    public static IslaiduIrasas generateIslaiduIrasas() {
        Random r = new Random();
        IslaiduKategorija[] kategorijas = IslaiduKategorija.values();
        AtsiskaitymoBudas[] atsiskaitymoBudas = AtsiskaitymoBudas.values();

        return new IslaiduIrasas(r.nextDouble() * 1000,
                LocalDateTime.now().minusDays(r.nextInt(365)).minusMinutes(r.nextInt(60 * 24)),
                kategorijas[r.nextInt(kategorijas.length)],
                atsiskaitymoBudas[r.nextInt(atsiskaitymoBudas.length)],
                generateComment());
    }

    /**
     * Generates random PajamuIrasas object
     *
     * @return random PajamuIrasas object
     */
    public static PajamuIrasas generatePajamuData() {
        Random r = new Random();
        PajamuKategorija[] kategorijas = PajamuKategorija.values();

        return new PajamuIrasas(r.nextDouble() * 1000,
                LocalDate.now().minusDays(r.nextInt(365)),
                kategorijas[r.nextInt(kategorijas.length)],
                r.nextBoolean(),
                generateComment());
    }

    /**
     * Generates random dummy text comment
     *
     * @return random dummy text comment
     */
    public static String generateComment() {
        String[] comments = {"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa." +
                "Lorem ipsum dolor sit amet.", "Lorem ipsum dolor.", "Lorem ipsum dolor sit amet, consectetuer adipiscing.",
                "Lorem ipsum."};

        return comments[new Random().nextInt(comments.length)];
    }
}
