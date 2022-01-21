package lt.codeacademy;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    static {
        biudzetas = new Biudzetas();

        for (int i = 0; i < 10; i++) {
            biudzetas.pridetiIslaiduIrasa(generateIslaiduIrasas());
            biudzetas.pridetiPajamuIrasa(generatePajamuData());
        }
    }

    public static void main(String[] args) {
        System.out.println("Interaktyvia programą - Biudzetas\n");

        Scanner sc = new Scanner(System.in);

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
                sc.nextLine();
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
                System.out.println("Show new debit record menu\n");
                break;
            case 2:
                System.out.println("Show new income record menu\n");
                break;
            case 3:
                printIslaiduIrasus();
                break;
            case 4:
                System.out.println("Display all income records\n");

        }
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
        System.out.printf(format, "Suma", "Data / laikas", "Katerorija", "Atsiskaitymo Budas", "Informacija");
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
                "Lorem ipsum dolor sit amet.", "Lorem ipsum dolor.", "Lorem ipsum dolor sit amet, consectetuer adipiscing",
                "Lorem ipsum"};

        return comments[new Random().nextInt(comments.length)];
    }
}
