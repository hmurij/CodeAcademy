package lt.codeacademy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Interaktyvia programą, su kurios pagalba vartotojas turi galimybę pasirinkti ką įvesti (pajamas/išlaidas),
 * turi galimybe gauti reikiamą informaciją kiek išleido ir gavo pajamų.
 */
public class Programa {
    public static void main(String[] args) {
        System.out.println("Interaktyvia programą - Biudzetas");

        Biudzetas biudzetas = new Biudzetas();
        Scanner sc = new Scanner(System.in);


        while(true) {
            int choice;
            showMainMenu();

            try {
                choice = sc.nextInt();

                if(0 > choice || choice > 4){
                    throw new InputMismatchException();
                }


            } catch (InputMismatchException e) {
                System.out.println("Netinkamas parametras!\n");
                sc.nextLine();
                continue;
            }

            System.out.println("Jusu pasirinkimas: " + choice + "\n");
            processInput(choice);

            if(choice == 0){
                System.out.println("Aciu uz demesi!");
                break;
            }
        }


    }

    /**
     * Processes user input
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
                System.out.println("Display all debit records\n");
                break;
            case 4:
                System.out.println("Display all income records\n");

        }
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
