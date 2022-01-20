package lt.codeacademy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Interaktyvia programą, su kurios pagalba vartotojas turi galimybę pasirinkti ką įvesti (pajamas/išlaidas),
 * turi galimybe gauti reikiamą informaciją kiek išleido ir gavo pajamų.
 */
public class Programa {
    public static void main(String[] args) {
        System.out.println("Interaktyvia programą - Biudzetas");

        Stream.generate(Programa::generatePajamuData).limit(10).forEach(System.out::println);
        System.out.println();

        Stream.generate(Programa::generateIslaiduIrasas).limit(10).forEach(System.out::println);
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
